package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.ColorsDetails;
import com.poy.J6_Huyntpc00617.Service.ColorsDetailsService;
import com.poy.J6_Huyntpc00617.dao.ColorDetailsDAO;

@Service
public class ColorDetailsServiceImpl implements ColorsDetailsService{
	@Autowired ColorDetailsDAO colordao;
	@Override
	public List<ColorsDetails> getAll() {
		// TODO Auto-generated method stub
		return colordao.findAll();
	}

}
