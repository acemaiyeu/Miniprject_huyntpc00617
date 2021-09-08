package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Price;
import com.poy.J6_Huyntpc00617.Bean.Product;
import com.poy.J6_Huyntpc00617.Bean.ReportProduct;
import com.poy.J6_Huyntpc00617.Service.ProductService;
import com.poy.J6_Huyntpc00617.dao.CategoryDAO;
import com.poy.J6_Huyntpc00617.dao.PriceDAO;
import com.poy.J6_Huyntpc00617.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired ProductDAO prodao;
	@Autowired CategoryDAO cadao;
	@Autowired PriceDAO pricedao;
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return prodao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		
		return prodao.findByIdProduct(id);
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub
		return cadao.findByCategory(cid);
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return prodao.save(product);
	}

	@Override
	public void delete(Integer id) {
		prodao.deleteById(id);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return prodao.save(product);
	}

	@Override
	public List<ReportProduct> findAllReport() {
		// TODO Auto-generated method stub
		return prodao.Report();
	}

	@Override
	public Product getProductLast() {
		// TODO Auto-generated method stub
		return prodao.getProductLast();
	}

}
