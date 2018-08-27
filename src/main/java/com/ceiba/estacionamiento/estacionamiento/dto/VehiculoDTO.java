package com.ceiba.estacionamiento.estacionamiento.dto;



public class VehiculoDTO {


	private Long id;

	private String placa;
	
	private int cilindraje;
	
	private String tipoVehiculo;
	
	private double tiempoHoras;
	
	private double tiempoDias;
	
	public VehiculoDTO() {
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

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public double getTiempoHoras() {
		return tiempoHoras;
	}

	public void setTiempoHoras(double tiempoHoras) {
		this.tiempoHoras = tiempoHoras;
	}

	public double getTiempoDias() {
		return tiempoDias;
	}

	public void setTiempoDias(double tiempoDias) {
		this.tiempoDias = tiempoDias;
	}
	
	
}
