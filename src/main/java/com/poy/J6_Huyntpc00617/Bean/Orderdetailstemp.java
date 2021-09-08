package com.poy.J6_Huyntpc00617.Bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Ordersdetailstemp")
public class Orderdetailstemp implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long orderdetailsid;
	String unitprice;
	Double quantity;
	Double discount;
	@Temporal(TemporalType.DATE)
	Date create_date;
	Double price;
	Boolean status;
	@ManyToOne@JoinColumn(name = "orderid")
	Orderstemp ordertemp;
	@ManyToOne@JoinColumn(name = "productid")
	Product product;
}
