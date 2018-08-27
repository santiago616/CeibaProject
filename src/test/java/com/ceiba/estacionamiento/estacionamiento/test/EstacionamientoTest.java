package com.ceiba.estacionamiento.estacionamiento.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.estacionamiento.estacionamiento.dominio.Estacionamiento;
import com.ceiba.estacionamiento.estacionamiento.dto.ParametrizacionDTO;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.dto.VehiculoDTO;

public class EstacionamientoTest {
	
	private Estacionamiento estacionamiento;
	
	
	@Before
	public void setup() {
		estacionamiento=new Estacionamiento();
	}

	@Test
	public void testCalcularAuto_diaTresHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.AUTO);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.AUTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_CARRO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_HORA_CARRO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,2,55);
		fechaSalida.set(2018, Calendar.AUGUST,22,5,55);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("11000"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_diaTresHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.MOTO);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.MOTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_MOTO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_HORA_MOTO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,2,55);
		fechaSalida.set(2018, Calendar.AUGUST,22,5,55);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("5500"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_diezHorasSeisCiencuentaCC() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.MOTO);
		registro.getVehiculo().setCilindraje(650);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.MOTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_MOTO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_HORA_MOTO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,8,00);
		fechaSalida.set(2018, Calendar.AUGUST,21,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("6000"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_diezHorasMenoCilindraje() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.MOTO);
		registro.getVehiculo().setCilindraje(500);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.MOTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_MOTO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_HORA_MOTO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,8,00);
		fechaSalida.set(2018, Calendar.AUGUST,21,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("4000"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularAuto_dosDiasNueveHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.AUTO);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.AUTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_CARRO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_DIA_CARRO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("24000"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularAuto_dosDiasOchoHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.AUTO);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.AUTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_CARRO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_HORA_CARRO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,17,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("24000"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_dosDiasNueveHorasSeisCientosCC() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.MOTO);
		registro.getVehiculo().setCilindraje(600);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.MOTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_MOTO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_HORA_MOTO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("14000"), tarifaParqueo);
	}
	
	
	@Test
	public void testCalcularMoto_dosDiasOchoHorasCuatroCientosCC() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.MOTO);
		registro.getVehiculo().setCilindraje(400);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		ParametrizacionDTO parametrizacionDTO = new ParametrizacionDTO();
		parametrizacionDTO.setTipoVehiculo(Estacionamiento.MOTO);
		parametrizacionDTO.setCupoVehiculo(20);
		parametrizacionDTO.setValorDiaVehiculo(Estacionamiento.VALOR_DIA_MOTO);
		parametrizacionDTO.setValorHoraVehiculo(Estacionamiento.VALOR_HORA_MOTO);
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,17,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro,parametrizacionDTO);
		assertEquals(new BigDecimal("12000"), tarifaParqueo);
	}
	
	
	@Test
	public void testCuposDisponibleMoto() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.MOTO);
		registro.getVehiculo().setCilindraje(400);
		
		Boolean cuposDisponibles=estacionamiento.validarDisponiblidadCupos(new Long(15), registro.getVehiculo().getTipoVehiculo());
		assertEquals(true, cuposDisponibles);
	}
	
	
	@Test
	public void testCuposNoDisponibleMoto() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.MOTO);
		registro.getVehiculo().setCilindraje(400);
		
		Boolean cuposDisponibles=estacionamiento.validarDisponiblidadCupos(new Long(20), registro.getVehiculo().getTipoVehiculo());
		assertEquals(false, cuposDisponibles);
	}
	
	
	@Test
	public void testCuposDisponibleAuto() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.AUTO);
		
		Boolean cuposDisponibles=estacionamiento.validarDisponiblidadCupos(new Long(15), registro.getVehiculo().getTipoVehiculo());
		assertEquals(true, cuposDisponibles);
	}
	
	
	@Test
	public void testCuposNoDisponibleAuto() {
		RegistroDTO registro = new RegistroDTO();
		registro.setVehiculo(new VehiculoDTO());
		registro.getVehiculo().setTipoVehiculo(Estacionamiento.AUTO);
		Boolean cuposDisponibles=estacionamiento.validarDisponiblidadCupos(new Long(20), registro.getVehiculo().getTipoVehiculo());
		assertEquals(false, cuposDisponibles);
	}
	

}
