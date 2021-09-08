package com.poy.J6_Huyntpc00617.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Color;
import com.poy.J6_Huyntpc00617.Bean.Input_product;
import com.poy.J6_Huyntpc00617.Bean.Price;
import com.poy.J6_Huyntpc00617.Bean.Product;
import com.poy.J6_Huyntpc00617.Bean.Supplier;
import com.poy.J6_Huyntpc00617.Service.*;
@CrossOrigin("/*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
@Autowired
ProductService proservice;
@Autowired
PriceService priceService;
@Autowired
SupplierService supplierservice;
@Autowired
colorservice colorservice;


@Autowired InputProductService insertvice;
@GetMapping("{id}")
public Product getOne(@PathVariable("id") Integer id) {
	Product pro = proservice.findById(id);
	Input_product in = insertvice.getProductid(id);
	//System.out.println("ProductID: "+pro.getProductidl());
	Product pr = new Product();
	pr.setProductidl(pro.getProductidl());
	pr.setProductname(pro.getProductname());
	pr.setCreatedate(in.getDate_input());
	pr.setQty(pro.getQty());
	pr.setPrice(priceService.priceProduct(id));
	return pr;
}
@GetMapping("/priceproduct/{id}")
public Double getPriceProduct(@PathVariable("id") Integer id) {
//System.out.println("PriceProduct: "+priceService.priceProduct(id));
	return priceService.priceProduct(id);
}
@GetMapping()
public List<Product> getAll() {
	List<Product> list = proservice.findAll();
	for(Product p : list) {
		Input_product in = insertvice.getProductid(p.getProductidl());
		p.setPrice(priceService.priceProduct(p.getProductidl()));
		p.setCreatedate(in.getDate_input());
		//System.out.println(p.getProductidl());
	}
	return list;
}
@PostMapping("/{supplierid}")
public Product create(@RequestBody Product product, @PathVariable("supplierid") String supplierid) throws ParseException {
	proservice.create(product);
	Supplier sup = supplierservice.findByID(supplierid);
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String date = simpleDateFormat.format(new Date());
	Date datenew = simpleDateFormat.parse(date);
	
	Product pro = new Product();
	List<Product> list = proservice.findAll();
	for(Product p : list) {
		 pro = p;
	 }
	//them gia san pham
	 Price price = new Price();
	 price.setPrice_input(product.getPrice());
	 price.setPrice_output_old(product.getPrice()+(product.getPrice()*0.2));
	 price.setPrice_output_new(product.getPrice()+(product.getPrice()*0.2));
	 price.setProduct(pro);
	 price.setDate_output(datenew);
	// System.out.println(date +" date");
	 priceService.save(price);
	 //them input san pham
//	 List<Supplier> listsp = supplierservice.getAll();
//	 Supplier sp = new Supplier();
//	 for(Supplier s : listsp) {
//		 sp = s;
//	 }
	 Input_product in = new Input_product();
	 in.setDate_input(datenew);
	 in.setQuantity(pro.getQty());
	 in.setSupplier(sup);
	 in.setProduct(pro);
	 in.setUnitproduct("Chiếc");
	 insertvice.save(in);
	 Product pro1 = proservice.getProductLast();
	 //System.out.println("Productlasst: "+pro1.getProductidl());
	 return pro1;
//	return proservice.create(product);
}
@DeleteMapping("/delete/{id}")
public void delete(@PathVariable("id") Integer id) {
	List<Price> price = priceService.getProductId(id);
	for(Price p : price) {
		if(p.getProduct().getProductidl() == id) {
			priceService.deleteByID(p.getPriceid());
		}
	}
	//delete color
	List<Color> listcolor = colorservice.getProductID(id);
	for(Color c : listcolor) {
		if(c.getProduct().getProductidl() == id) {
			priceService.deleteByID(c.getColorid());
		}
	}
	Input_product inp = insertvice.getProductid(id);
	insertvice.deleteByID(inp.getInput_id());
	proservice.delete(id);
}
@PutMapping("/{supplierid}")
public Product update(@PathVariable("supplierid") String supplierid,@RequestBody Product product) throws ParseException {
	Input_product inp = insertvice.findById(product.getProductidl());
	product.setCreatedate(inp.getDate_input());
	product.setUpdateedate(new Date());
	proservice.update(product);
	Supplier sup = supplierservice.findByID(supplierid);
	inp.setSupplier(sup);
	insertvice.save(inp);
//insert price
	String pattern = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String date = simpleDateFormat.format(new Date());
	Date datenew = simpleDateFormat.parse(date);
	List<Price> pricelist = priceService.getAll();
	
	for(Price p : pricelist) {
		if(p.getProduct().getProductidl() == product.getProductidl() && p.getDate_output() == new Date()) {
			//System.out.println(product.getProductname());
		}
	}
	 Price pri = priceService.ProductIDAndNewDate(product.getProductidl(), new Date());
	 
	 if(pri == null) {
		 Price price = new Price();
		 price.setPrice_input(product.getPrice());
		 price.setPrice_output_old(product.getPrice()+(product.getPrice()*0.2));
		 price.setPrice_output_new(product.getPrice()+(product.getPrice()*0.2));
		 price.setProduct(product);
		 price.setDate_output(datenew);
	 priceService.save(price);
	 }
	return proservice.findById(product.getProductidl());
}



}
