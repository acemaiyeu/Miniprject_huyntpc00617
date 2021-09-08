package com.poy.J6_Huyntpc00617.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
public class Orderstemp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	Long orderid;
	@Temporal(TemporalType.DATE)
	Date orderdate;
	@Column(name="")
	@Temporal(TemporalType.DATE)
	Date requireddate;
	String shipaddress;
	String city;
	String shippostalcode;
	@ManyToOne @JoinColumn(name = "username")
	Accounts accounts;
	@JsonIgnore
	@OneToMany(mappedBy = "ordertemp")
	List<Orderdetailstemp> listorderdetailstemp;
	@ManyToOne @JoinColumn(name = "statusorderid")
	StatusOrder statusrder;
}
