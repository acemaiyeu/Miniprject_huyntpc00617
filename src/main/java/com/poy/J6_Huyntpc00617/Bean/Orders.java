package com.poy.J6_Huyntpc00617.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	Long orderid;
	@Temporal(TemporalType.DATE)
	Date Orderdate;
	Date Requireddate;
	Date Shippeddate;
	String Shipaddress;
	String City;
	Double Shippostalcode;
	Boolean Status;
	
	@ManyToOne @JoinColumn(name = "username")
	Accounts accounts;
	@ManyToOne @JoinColumn(name = "shipvia")
	Shipper shipper;
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<Orderdetails> ListOrderDetails;
	@ManyToOne @JoinColumn(name = "statusorderid")
	StatusOrder statusrder;
}
