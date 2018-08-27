package com.ceiba.estacionamiento.estacionamiento.dto;

import java.math.BigDecimal;

public class ParametrizacionDTO {

	private BigDecimal valorHoraVehiculo;
	
	private BigDecimal valorDiaVehiculo;
	
	private int cupoVehiculo;
	
	private String tipoVehiculo;

	public ParametrizacionDTO() {
	}



	public int getCupoVehiculo() {
		return cupoVehiculo;
	}

	public void setCupoVehiculo(int cupoVehiculo) {
		this.cupoVehiculo = cupoVehiculo;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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
