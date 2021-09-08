package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Category;
import com.poy.J6_Huyntpc00617.Service.CategoryService;
import com.poy.J6_Huyntpc00617.dao.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired CategoryDAO cdao;
	
	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

}
