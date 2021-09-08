package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.*;
import com.poy.J6_Huyntpc00617.Service.AuthorityService;
import com.poy.J6_Huyntpc00617.dao.AccountDAO;
import com.poy.J6_Huyntpc00617.dao.AuthDAO;

@Service
public class AuthServiceImpl implements AuthorityService{
@Autowired AuthDAO audao;
@Autowired AccountDAO acdao;
	
	@Override
	public List<Auth> findAuthoritiesOfAdministrators() {
		List<Accounts> account = acdao.getAdministrators();
		return audao.authoritiesOf(account);
	}

	@Override
	public List<Auth> findAll() {
		return audao.findAll();
	}

	@Override
	public Auth save(Auth Auth) {
		// TODO Auto-generated method stub
		return audao.save(Auth);
	}
	
	@Override
	public void Delete(Integer id) {
		audao.deleteById(id);
	}
}
