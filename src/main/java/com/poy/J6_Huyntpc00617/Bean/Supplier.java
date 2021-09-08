package com.poy.J6_Huyntpc00617.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
public class Supplier implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String supplierid;
	String suppliername;
	String contactname;
	String email;
	String address;
	String city; 
	String country;
	String phone;
	String fax;
	@JsonIgnore
	@OneToMany(mappedBy = "supplier")
	List<Input_product> ListInputProduct;
}
