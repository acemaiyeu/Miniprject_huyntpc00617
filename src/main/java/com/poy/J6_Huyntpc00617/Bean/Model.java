package com.poy.J6_Huyntpc00617.Bean;

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
@AllArgsConstructor @NoArgsConstructor
@Data
public class Model {
	@Id
	Integer modelid;
	String modelname;
	@JsonIgnore
	@OneToMany(mappedBy = "model")
	List<Descriptions> Descriptions;
}
