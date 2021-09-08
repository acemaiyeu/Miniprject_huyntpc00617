package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Role;
import com.poy.J6_Huyntpc00617.dao.RoleDAO;
import com.poy.J6_Huyntpc00617.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
@Autowired RoleDAO roledao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roledao.findAll();
	}

}
