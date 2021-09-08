package com.poy.J6_Huyntpc00617.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Accounts;

public interface AccountDAO extends JpaRepository<Accounts, String>{
	@Query("SELECT DISTINCT ar.accounts FROM Auth ar WHERE ar.role.id IN ('ADMIN','PM')")
	List<Accounts> getAdministrators();
}
