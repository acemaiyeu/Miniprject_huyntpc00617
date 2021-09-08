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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Descriptions implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer descriptionid;
	String internal_memory; 
	String network;
	String sim_slot;
	Boolean waterproof;
	String screen_size;
	String resolution;
	String operating_system;
	String ram;
	String rear_camera;
	String front_camera;
	Boolean gps;
	Boolean bluetooth;
	String microusb;
	Double the_battery;
	String origin;
	@ManyToOne @JoinColumn(name = "brandid")
	Brand brand;
	@ManyToOne @JoinColumn(name = "modelid")
	Model model;
	@JsonIgnore
	@OneToMany(mappedBy = "descriptions")
	List<Product> ListProduct;
}
