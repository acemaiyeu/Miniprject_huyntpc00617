package com.poy.J6_Huyntpc00617.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
@Table(name = "company")
public class Company implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String code;
	String address;
	String description;
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	List<Company_Sub> company_sub;
}
