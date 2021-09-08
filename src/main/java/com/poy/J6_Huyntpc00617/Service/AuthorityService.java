package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Auth;

public interface AuthorityService {

	List<Auth> findAuthoritiesOfAdministrators();

	List<Auth> findAll();

	Auth save(Auth authority);
	void Delete(Integer id);
}
