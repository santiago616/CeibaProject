package com.ceiba.estacionamiento.estacionamiento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "registro")
public class RegistroEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String placa;

	private int cilindraje;

	private Date horaEntrada;

	private Date horaSalida;

	private Boolean facturado;

	private BigDecimal totalServicio;

	private String tipoVehiculo;

	public RegistroEntity() {
		super();
	}

	public RegistroEntity(String placa, int cilindraje, Date horaEntrada, Date horaSalida, Boolean facturado,
			BigDecimal totalServicio, String tipoVehiculo) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.facturado = facturado;
		this.totalServicio = totalServicio;
		this.tipoVehiculo = tipoVehiculo;
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

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Boolean getFacturado() {
		return facturado;
	}

	public void setFacturado(Boolean facturado) {
		this.facturado = facturado;
	}

	public BigDecimal getTotalServicio() {
		return totalServicio;
	}

	public void setTotalServicio(BigDecimal totalServicio) {
		this.totalServicio = totalServicio;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", placa=" + placa + ", cilindraje=" + cilindraje + ", horaEntrada=" + horaEntrada
				+ ", horaSalida=" + horaSalida + ", facturado=" + facturado + ", totalServicio=" + totalServicio
				+ ", tipoVehiculo=" + tipoVehiculo + "]";
	}

}
