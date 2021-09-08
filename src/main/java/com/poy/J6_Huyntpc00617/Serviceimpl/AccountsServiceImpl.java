package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Accounts;
import com.poy.J6_Huyntpc00617.Service.AccountService;
import com.poy.J6_Huyntpc00617.dao.AccountDAO;

@Service
public class AccountsServiceImpl implements AccountService{

	@Autowired AccountDAO acdao; 
	
	
	@Override
	public Accounts findById(String username) {
		// TODO Auto-generated method stub
		return acdao.getOne(username);
	}

	@Override
	public List<Accounts> getAdministrators() {
		// TODO Auto-generated method stub
		return acdao.getAdministrators();
	}

	@Override
	public List<Accounts> findAll() {
		return acdao.findAll();
	}

	@Override
	public Accounts update(Accounts account) {
		// TODO Auto-generated method stub
		return acdao.save(account);
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		acdao.deleteById(username);
	}

	@Override
	public Accounts create(Accounts account) {
		// TODO Auto-generated method stub
		return acdao.save(account);
	}

}
