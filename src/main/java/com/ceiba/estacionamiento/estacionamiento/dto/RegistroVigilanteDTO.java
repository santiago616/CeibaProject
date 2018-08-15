package com.ceiba.estacionamiento.estacionamiento.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.ceiba.estacionamiento.estacionamiento.entity.Parqueadero;

public class RegistroVigilanteDTO {


		private Long id;

		private String placa;
		
		private int cilindraje;
		
		private Date horaEntrada;
		
		private Date horaSalida;
		
		private Boolean estado;
		
		private BigDecimal totalServicio;
		
		private Parqueadero parqueadero;

		public RegistroVigilanteDTO() {
			super();
		}
		

		public RegistroVigilanteDTO(Long id, String placa, int cilindraje, Date horaEntrada, Date horaSalida,
				Boolean estado, BigDecimal totalServicio, Parqueadero parqueadero) {
			this.id = id;
			this.placa = placa;
			this.cilindraje = cilindraje;
			this.horaEntrada = horaEntrada;
			this.horaSalida = horaSalida;
			this.estado = estado;
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

		public Boolean getEstado() {
			return estado;
		}

		public void setEstado(Boolean estado) {
			this.estado = estado;
		}

		public BigDecimal getTotalServicio() {
			return totalServicio;
		}

		public void setTotalServicio(BigDecimal totalServicio) {
			this.totalServicio = totalServicio;
		}
		
		
		public Parqueadero getParqueadero() {
			return parqueadero;
		}

		public void setParqueadero(Parqueadero parqueadero) {
			this.parqueadero = parqueadero;
		}

		
		
		

	

}
