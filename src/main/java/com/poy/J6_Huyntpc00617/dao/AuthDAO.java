package com.poy.J6_Huyntpc00617.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Accounts;
import com.poy.J6_Huyntpc00617.Bean.Auth;

public interface AuthDAO extends JpaRepository<Auth, Integer>{

	@Query("SELECT DISTINCT a FROM Auth a WHERE a.accounts IN ?1")
	List<Auth> authoritiesOf(List<Accounts> account);
	
}
