package com.example.prueba.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@ApiModel("Modelo")
public class UserTest {

	
	@Id
	private int id;
	
	@ApiModelProperty(value="name", example="Manolo")
	@NotBlank(message="El nombre es obligatorio")
	private String name;
	
	@ApiModelProperty(value="fecha")
	@NotNull(message="La fecha es obligatoria")
	private Date fecha;
	
	

	public UserTest() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
