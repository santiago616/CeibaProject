package com.ceiba.estacionamiento.estacionamiento.dto;

import java.math.BigDecimal;

public class ParametrizacionDTO {

	private BigDecimal valorHoraVehiculo;
	
	private BigDecimal valorDiaVehiculo;
	
	
	private String tipoVehiculo;

	public ParametrizacionDTO() {
		super();
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
