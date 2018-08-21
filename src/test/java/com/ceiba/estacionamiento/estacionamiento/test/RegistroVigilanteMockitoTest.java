package com.ceiba.estacionamiento.estacionamiento.test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.entity.RegistroEntity;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IEstacionamientoService;
import com.ceiba.estacionamiento.estacionamiento.service.IRegistroVigilanteService;
import com.ceiba.estacionamiento.estacionamiento.service.impl.RegistroVigilanteServiceImpl;

public class RegistroVigilanteMockitoTest {
	
	@Mock
	private RegistroVigilanteRepository registroRepository;
	
	
	private IRegistroVigilanteService registroVigilanteService;
	
	@Mock
	private IEstacionamientoService estacionamientoService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		registroVigilanteService= new RegistroVigilanteServiceImpl(registroRepository, estacionamientoService);
	}
	
	@Test
	public void testRegistrarVehiculoestacionamiento_vehiculoNoRegistrado() {
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setPlaca("PNG121");
		registroTest.setTipoVehiculo("auto");
		
		when(registroRepository.buscarRegistroPorPlaca(registroTest.getPlaca())).thenReturn(null);
		
		RegistroDTO ingresoValido=registroVigilanteService.consultarVehiculoPorPlaca(registroTest.getPlaca());
		
		assertThat(ingresoValido,nullValue());
	
	}
	
	
	@Test
	public void testRegistrarVehiculoestacionamiento_vehiculoRegistrado() {
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setPlaca("PNG121");
		registroTest.setTipoVehiculo("auto");
		
		when(registroRepository.buscarRegistroPorPlaca(registroTest.getPlaca())).thenReturn(new RegistroEntity());
		
		RegistroDTO ingresoValido=registroVigilanteService.consultarVehiculoPorPlaca(registroTest.getPlaca());
		
		assertThat(ingresoValido,notNullValue());
	
	}
	
	@Test
	public void testValidarIngresoVehiculoestacionamiento_cupoNoDisponible() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setPlaca("PNG121");
		registroTest.setTipoVehiculo("auto");
		
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getTipoVehiculo())).thenReturn(Boolean.FALSE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(false, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoVehiculoestacionamiento_cupoDisponible() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setPlaca("PNG121");
		registroTest.setTipoVehiculo("auto");
		
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(true, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoVehiculoestacionamiento_placaNoValida() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setPlaca("ANG121");
		registroTest.setTipoVehiculo("auto");
		Calendar hoy = Calendar.getInstance();
		hoy.set(2018, Calendar.AUGUST, 20,1,00);
		registroTest.setHoraEntrada(hoy.getTime());
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.FALSE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(false, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoVehiculoestacionamiento_placaValida() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setPlaca("PNG121");
		registroTest.setTipoVehiculo("auto");
		Calendar hoy = Calendar.getInstance();
		hoy.set(2018, Calendar.AUGUST, 21,1,00);
		registroTest.setHoraEntrada(hoy.getTime());
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(true, ingresoValido);
	}
	
}
