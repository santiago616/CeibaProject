package com.ceiba.estacionamiento.estacionamiento.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.estacionamiento.estacionamiento.dominio.Estacionamiento;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;

public class EstacionamientoTest {
	
	private Estacionamiento estacionamiento;
	
	
	@Before
	public void setup() {
		estacionamiento=new Estacionamiento();
	}

	@Test
	public void testCalcularAuto_diaTresHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("auto");
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,2,55);
		fechaSalida.set(2018, Calendar.AUGUST,22,5,55);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("11000.0"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_diaTresHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("MOTO");
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,2,55);
		fechaSalida.set(2018, Calendar.AUGUST,22,5,55);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("5500.0"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_diezHorasSeisCiencuentaCC() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("MOTO");
		registro.setCilindraje(650);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,8,00);
		fechaSalida.set(2018, Calendar.AUGUST,21,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("6000.0"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_diezHorasMenoCilindraje() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("MOTO");
		registro.setCilindraje(500);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,8,00);
		fechaSalida.set(2018, Calendar.AUGUST,21,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("4000.0"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularAuto_dosDiasNueveHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("auto");
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("24000.0"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularAuto_dosDiasOchoHoras() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("auto");
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,17,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("24000.0"), tarifaParqueo);
	}
	
	@Test
	public void testCalcularMoto_dosDiasNueveHorasSeisCientosCC() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("MOTO");
		registro.setCilindraje(600);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,18,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("14000.0"), tarifaParqueo);
	}
	
	
	@Test
	public void testCalcularMoto_dosDiasOchoHorasCuatroCientosCC() {
		RegistroDTO registro = new RegistroDTO();
		registro.setTipoVehiculo("MOTO");
		registro.setCilindraje(400);
		Calendar fechaEntrada= Calendar.getInstance();
		Calendar fechaSalida= Calendar.getInstance();
		
		fechaEntrada.set(2018, Calendar.AUGUST,21,9,00);
		fechaSalida.set(2018, Calendar.AUGUST,23,17,00);
		registro.setHoraEntrada(fechaEntrada.getTime());
		registro.setHoraSalida(fechaSalida.getTime());
		BigDecimal tarifaParqueo=estacionamiento.calcularValorParqueadero(registro);
		assertEquals(new BigDecimal("12000.0"), tarifaParqueo);
	}
	
	
}
