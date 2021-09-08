package com.poy.J6_Huyntpc00617.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProduct {
	@Id
	Integer	productid;
	String	productname;
	Date	createdate;
	Date	updateedate;
	String	categoryname;
	Boolean	status;
	String	imagename1;
	String	imagename2;
	String	imagename3;
	String	quantity;
	Double	price;
	String	unitproduct;
	String	supplierid;
}
