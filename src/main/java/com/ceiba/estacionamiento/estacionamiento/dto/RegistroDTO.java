package com.ceiba.estacionamiento.estacionamiento.dto;

import java.math.BigDecimal;
import java.util.Date;


public class RegistroDTO {


		private Long id;
		
		private VehiculoDTO vehiculo;
		
		private Date horaEntrada;
		
		private Date horaSalida;
		
		private Boolean facturado;
		
		private BigDecimal totalServicio;
		
		private int[] tiempoTotal;
		

		public RegistroDTO() {
			super();
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		

		public Date getHoraEntrada() {
			return horaEntrada;
		}

		public void setHoraEntrada(Date horaEntrada) {
			this.horaEntrada = horaEntrada;
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



		public int[] getTiempoTotal() {
			return tiempoTotal;
		}



		public void setTiempoTotal(int[] tiempoTotal) {
			this.tiempoTotal = tiempoTotal;
		}



		public VehiculoDTO getVehiculo() {
			return vehiculo;
		}



		public void setVehiculo(VehiculoDTO vehiculo) {
			this.vehiculo = vehiculo;
		}



		public Date getHoraSalida() {
			return horaSalida;
		}



		public void setHoraSalida(Date horaSalida) {
			this.horaSalida = horaSalida;
		}



		
		
	
		
		
		

	

}
