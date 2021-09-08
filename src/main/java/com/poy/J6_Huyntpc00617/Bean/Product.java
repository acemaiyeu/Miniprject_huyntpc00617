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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	Integer productidl;
	@NotBlank(message ="Productname cann't be null")
	String productname;
	@Temporal(TemporalType.DATE)
	Date createdate;
	@Temporal(TemporalType.DATE)
	Date updateedate;
	String imagename1;
	String imagename2;
	String imagename3;
	Double qty;
	@Min(value=0, message="Price should not be less than 0")
	Double price;
	Boolean Status;
	@NotNull(message="Category cann't be null")
	@ManyToOne @JoinColumn(name = "categoryid")
	Category category;
	@NotNull(message="Description cann't be null")
	@ManyToOne @JoinColumn(name = "descriptionid")
	Descriptions descriptions;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Color> listcolor;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Input_product> ListInputProduct;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Price> ListPrice;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Orderdetails> ListOrderDetails;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<Orderdetailstemp> ListOrderDetailstemp;
}
