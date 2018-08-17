package com.ceiba.estacionamiento.estacionamiento.dto;

import java.math.BigDecimal;
import java.util.Date;


public class RegistroDTO {


		private Long id;

		private String placa;
		
		private int cilindraje;
		
		private Date horaEntrada;
		
		private Date horaSalida;
		
		private Boolean facturado;
		
		private BigDecimal totalServicio;
		
		private String tipoVehiculo;
		

		public RegistroDTO() {
			super();
		}
		

		public RegistroDTO( String placa, int cilindraje, Date horaEntrada, Date horaSalida,
				Boolean facturado, BigDecimal totalServicio,String tipo) {
			this.placa = placa;
			this.cilindraje = cilindraje;
			this.horaEntrada = horaEntrada;
			this.horaSalida = horaSalida;
			this.facturado = facturado;
			this.totalServicio = totalServicio;
			this.tipoVehiculo=tipo;
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


		public void setTipoVehiculo(String tipo) {
			this.tipoVehiculo = tipo;
		}
		
		
	
		
		
		

	

}
