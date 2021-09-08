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

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Shipper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String shiperid;
	String shipername;
	String address;
	String city;
	String phonenumber;
	String email;
	Boolean status;
	@JsonIgnore
	@OneToMany(mappedBy = "shipper")
	List<Orders> ListOrders;
}
