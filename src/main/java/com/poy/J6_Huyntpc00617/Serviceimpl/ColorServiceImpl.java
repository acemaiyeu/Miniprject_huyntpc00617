package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Color;
import com.poy.J6_Huyntpc00617.Service.colorservice;
import com.poy.J6_Huyntpc00617.dao.ColorDAO;

@Service
public class ColorServiceImpl implements colorservice{
@Autowired ColorDAO colordao;

	@Override
	public List<Color> getAll() {
		// TODO Auto-generated method stub
		return colordao.findAll();
	}

	@Override
	public List<Color> getNameColor(Integer productid) {
		// TODO Auto-generated method stub
		return colordao.getColorName(productid);
	}

	@Override
	public Color save(Color c) {
		// TODO Auto-generated method stub
		return colordao.save(c);
	}

	@Override
	public Color findByProductColordetails(Integer productid, String tim) {
		// TODO Auto-generated method stub
		return colordao.findByProductColordetails(productid, tim);
	}

	@Override
	public void deleteByProductIdAndColorDetailsID(Integer productid, String colordetailsid) {
	
	}

	@Override
	public List<Color> getProductID(Integer id) {
		// TODO Auto-generated method stub
		return colordao.getProductid(id);
	}

	@Override
	public void deleteByID(Integer colorid) {
		colordao.deleteById(colorid);
		
	}

}
