package com.poy.J6_Huyntpc00617.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.ColorsDetails;
import com.poy.J6_Huyntpc00617.Service.ColorDetailsSerivce;
import com.poy.J6_Huyntpc00617.dao.ColorDetailsDAO;

@Service
public class ColorDetailsSerivceImpl implements ColorDetailsSerivce{
@Autowired ColorDetailsDAO cddao;
	
	@Override
	public ColorsDetails findById(String id) {
		// TODO Auto-generated method stub
		return cddao.getById(id);
	}
	
}
