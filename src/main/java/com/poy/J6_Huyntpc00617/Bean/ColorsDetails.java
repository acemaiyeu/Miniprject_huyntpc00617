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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "colorsdetails")
public class ColorsDetails implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	String colorid;
	String colorname;
	@JsonIgnore
	@OneToMany(mappedBy = "colorsdetails")
	List<Color> color;
}
