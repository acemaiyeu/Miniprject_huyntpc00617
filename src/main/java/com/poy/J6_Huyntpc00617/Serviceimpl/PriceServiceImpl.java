package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Price;
import com.poy.J6_Huyntpc00617.Bean.Product;
import com.poy.J6_Huyntpc00617.Service.PriceService;
import com.poy.J6_Huyntpc00617.dao.PriceDAO;

@Service
public class PriceServiceImpl implements PriceService{
	@Autowired PriceDAO pricedao;
	@Override
	public Price GetOneOutput(Integer productid) {
		// TODO Auto-generated method stub
		return pricedao.GetOnePrice(productid);
	}
	@Override
	public Double priceProduct(Integer id)
	{
	 List<Price> list = pricedao.findAll();
	Double price = 0.0;	
	 for(Price p : list) {
			if(p.getProduct().getProductidl() == id) {
				Price pri =  pricedao.GetOnePrice(id);
				price = pri.getPrice_output_new();
			}
		}
		return price;
	}
	@Override
	public Price save(Price price) {
		// TODO Auto-generated method stub
		return pricedao.save(price);
	}
	@Override
	public List<Price> getAll() {
		// TODO Auto-generated method stub
		return pricedao.findAll();
	}
	@Override
	public Price ProductIDAndNewDate(Integer productid, Date date) {
		// TODO Auto-generated method stub
		return pricedao.getByProductIdAndNewDate(productid, date);
	}
	@Override
	public List<Price> getProductId(Integer id) {
		// TODO Auto-generated method stub
		return pricedao.getByProductID(id);
	}
	@Override
	public void deleteByID(Integer priceid) {
		pricedao.deleteById(priceid);
	}
	@Override
	public void deleteByProductID(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
