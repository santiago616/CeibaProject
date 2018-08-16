package com.ceiba.estacionamiento.estacionamiento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RegistroVigilante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String placa;

	private int cilindraje;

	private Date horaEntrada;

	private Date horaSalida;

	private Boolean facturado;

	private BigDecimal totalServicio;

	private Parqueadero parqueadero;

	public RegistroVigilante() {
		super();
	}

	public RegistroVigilante(String placa, int cilindraje, Date horaEntrada, Date horaSalida, Boolean facturado,
			BigDecimal totalServicio, Parqueadero parqueadero) {
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.facturado = facturado;
		this.totalServicio = totalServicio;
		this.parqueadero = parqueadero;
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

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	@Override
	public String toString() {
		return "RegistroVigilante [id=" + id + ", placa=" + placa + ", cilindraje=" + cilindraje + ", horaEntrada="
				+ horaEntrada + ", horaSalida=" + horaSalida + ", estado=" + facturado + ", totalServicio="
				+ totalServicio + ", parqueadero=" + parqueadero + "]";
	}

}
