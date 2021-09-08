package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Supplier;

public interface SupplierService {
List<Supplier> getAll();

Supplier findByID(String supplierid);
}
