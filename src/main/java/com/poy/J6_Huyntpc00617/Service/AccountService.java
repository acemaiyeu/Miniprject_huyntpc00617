package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Accounts;

public interface AccountService {
 Accounts findById(String username);

List<Accounts> getAdministrators();

List<Accounts> findAll();

Accounts update(Accounts account);

void delete(String username);

Accounts create(Accounts account);

}
