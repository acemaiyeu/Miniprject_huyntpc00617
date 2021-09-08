package com.poy.J6_Huyntpc00617.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Accounts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String username;
	String fullname;
	String password;
	String email;
	String photo;
	String address;
	@Temporal(TemporalType.DATE)
	Date birthday;
	String city;
	Boolean status;
	@JsonIgnore
	@OneToMany(mappedBy = "accounts")
	List<Orders> ListOrders;
	@JsonIgnore
	@OneToMany(mappedBy = "accounts")
	List<Auth> ListAuth;
}
