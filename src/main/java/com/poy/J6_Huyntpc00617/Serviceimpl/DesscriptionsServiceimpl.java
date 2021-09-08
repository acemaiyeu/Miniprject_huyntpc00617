package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Descriptions;
import com.poy.J6_Huyntpc00617.Service.DescriptionsService;
import com.poy.J6_Huyntpc00617.dao.DescriptionsDAO;

@Service
public class DesscriptionsServiceimpl implements DescriptionsService{
@Autowired DescriptionsDAO ddao;
	@Override
	public List<Descriptions> getAll() {
		// TODO Auto-generated method stub
		return ddao.findAll();
	}

}
