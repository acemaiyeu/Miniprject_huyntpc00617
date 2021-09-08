package com.poy.J6_Huyntpc00617.Controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poy.J6_Huyntpc00617.Bean.Price;
import com.poy.J6_Huyntpc00617.Bean.Product;
import com.poy.J6_Huyntpc00617.Service.PriceService;
import com.poy.J6_Huyntpc00617.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productservice;
	@Autowired
	PriceService priceService;
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("id") Optional<String> cid) {
		List<Price> listpricetemp = new ArrayList<>();
		
		if(cid.isPresent()) {
			List<Product> list = productservice.findByCategoryId(cid.get());
			
			List<Product> prolist = new ArrayList<>();
			for(Product p : list) {
				Price price = priceService.GetOneOutput(p.getProductidl());
				listpricetemp.add(price);
				try {
					File file = new ClassPathResource("/static/assets/images/"+p.getImagename1()).getFile();
					System.out.println(file.exists());
					
					if(p.getImagename1().trim().equals("") || p.getImagename1().equals("null") || p.getImagename1().trim() == "") {
						p.setImagename1("image-error.png");
					}
					prolist.add(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Hình không tồn tại");	
					p.setImagename1("image-error.png");
					prolist.add(p);
				}	
			}
			for(int i = 0; i < list.size(); i++) {
				list.get(i).setListPrice(null);
				if(i < list.size()) {
					list.get(i).setListPrice(listpricetemp);
				}
			}
			model.addAttribute("items", prolist);
		}
		else {
			List<Product> list = productservice.findAll();
			List<Product> prolist = new ArrayList<>();
			for(Product p : list) {
				Price price = priceService.GetOneOutput(p.getProductidl());
				listpricetemp.add(price);
				try {
					File file = new ClassPathResource("/static/assets/images/"+p.getImagename1()).getFile();
					System.out.println(file);
					System.out.println(file.exists());
					if(p.getImagename1().trim().equals("") || p.getImagename1().equals("null") || p.getImagename1().trim() == "") {
						p.setImagename1("image-error.png");
					}
					prolist.add(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Hình không tồn tại");	
					p.setImagename1("image-error.png");
					prolist.add(p);
				}	
			}
			for(int i = 0; i < list.size(); i++) {
				list.get(i).setListPrice(null);
				if(i < list.size()) {
					list.get(i).setListPrice(listpricetemp);
				}
			}
			model.addAttribute("items", prolist);
		}
		return "product/list";
	}
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		Product item = productservice.findById(id);
		List<Product> list = productservice.findAll();
		for(Product p : list) {
			Price price = priceService.GetOneOutput(p.getProductidl());
			if(price.getProduct().getProductidl() == id) {
				item.setPrice(price.getPrice_output_new());
			}
		}
		Product ite = item;
		model.addAttribute("item", ite);
		return "product/detail";
	}
}
