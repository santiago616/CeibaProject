package com.ceiba.estacionamiento.estacionamiento.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "vehiculo")
public class VehiculoEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String placa;
	
	private String tipoVehiculo;
	
	private int cilindraje;

	
	
	public VehiculoEntity() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getTipoVehiculo() {
		return tipoVehiculo;
	}



	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}



	public int getCilindraje() {
		return cilindraje;
	}



	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	
	

}
