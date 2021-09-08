package com.poy.J6_Huyntpc00617.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Table(name = "company_sub_sub")
public class Company_sub_sub implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String code;
	String address;
	String description;
	@ManyToOne @JoinColumn(name = "codecompany_sub")
	Company_Sub company_sub;
	
	
}
