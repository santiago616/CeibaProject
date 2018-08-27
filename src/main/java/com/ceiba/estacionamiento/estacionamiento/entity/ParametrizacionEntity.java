package com.ceiba.estacionamiento.estacionamiento.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "parametrizacion")
public class ParametrizacionEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private BigDecimal valorHoraVehiculo;
	
	private BigDecimal valorDiaVehiculo;
	
	private int cupoVehiculo;
	
	private String tipoVehiculo;




	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCupoVehiculo() {
		return cupoVehiculo;
	}

	public void setCupoVehiculo(int cupoVehiculo) {
		this.cupoVehiculo = cupoVehiculo;
	}

	public BigDecimal getValorHoraVehiculo() {
		return valorHoraVehiculo;
	}

	public void setValorHoraVehiculo(BigDecimal valorHoraVehiculo) {
		this.valorHoraVehiculo = valorHoraVehiculo;
	}

	public BigDecimal getValorDiaVehiculo() {
		return valorDiaVehiculo;
	}

	public void setValorDiaVehiculo(BigDecimal valorDiaVehiculo) {
		this.valorDiaVehiculo = valorDiaVehiculo;
	}

	


	
	
	
}
