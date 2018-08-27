package com.ceiba.estacionamiento.estacionamiento.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.dto.VehiculoDTO;
import com.ceiba.estacionamiento.estacionamiento.repository.ParametrizacionRepository;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IEstacionamientoService;
import com.ceiba.estacionamiento.estacionamiento.service.IRegistroVigilanteService;
import com.ceiba.estacionamiento.estacionamiento.service.impl.RegistroVigilanteServiceImpl;

public class RegistroVigilanteMockitoTest {
	
	@Mock
	private RegistroVigilanteRepository registroRepository;
	
	@Mock
	private ParametrizacionRepository parametrizacionRepository;
	
	
	private IRegistroVigilanteService registroVigilanteService;
	
	@Mock
	private IEstacionamientoService estacionamientoService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		registroVigilanteService= new RegistroVigilanteServiceImpl(registroRepository, estacionamientoService,parametrizacionRepository);
	}


	@Test
	public void testValidarIngresoVehiculoestacionamiento_cupoNoDisponible() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("PNG121");
		registroTest.getVehiculo().setTipoVehiculo("auto");
		
		
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.FALSE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(false, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoVehiculoestacionamiento_cupoDisponible() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("PNG121");
		registroTest.getVehiculo().setTipoVehiculo("auto");
		
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(true, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoMotoestacionamiento_cupoNoDisponible() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("PQP22D");
		registroTest.getVehiculo().setTipoVehiculo("moto");
		
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.FALSE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(false, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoMotoestacionamiento_cupoDisponible() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("PQP22D");
		registroTest.getVehiculo().setTipoVehiculo("moto");
		
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(true, ingresoValido);
	}
	
	

	
	@Test
	public void testValidarIngresoVehiculoestacionamiento_placaNoValida() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("ANG121");
		registroTest.getVehiculo().setTipoVehiculo("auto");
		Calendar hoy = Calendar.getInstance();
		hoy.set(2018, Calendar.AUGUST, 20,1,00);
		registroTest.setHoraEntrada(hoy.getTime());
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.FALSE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(false, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoMotoestacionamiento_placaNoValida() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("AQP22D");
		registroTest.getVehiculo().setTipoVehiculo("moto");
		Calendar hoy = Calendar.getInstance();
		hoy.set(2018, Calendar.AUGUST, 20,1,00);
		registroTest.setHoraEntrada(hoy.getTime());
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.FALSE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(false, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoMotoestacionamiento_placaValida() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("PQP22D");
		registroTest.getVehiculo().setTipoVehiculo("moto");
		Calendar hoy = Calendar.getInstance();
		hoy.set(2018, Calendar.AUGUST, 21,1,00);
		registroTest.setHoraEntrada(hoy.getTime());
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(true, ingresoValido);
	}
	
	@Test
	public void testValidarIngresoVehiculoestacionamiento_placaValida() {
	
		RegistroDTO registroTest= new RegistroDTO();
		registroTest.setVehiculo(new VehiculoDTO());
		registroTest.getVehiculo().setPlaca("PNG121");
		registroTest.getVehiculo().setTipoVehiculo("auto");
		Calendar hoy = Calendar.getInstance();
		hoy.set(2018, Calendar.AUGUST, 21,1,00);
		registroTest.setHoraEntrada(hoy.getTime());
		when(estacionamientoService.validarCuposEstacionamiento(registroTest.getVehiculo().getTipoVehiculo())).thenReturn(Boolean.TRUE);
		when(estacionamientoService.validarPlacaVehiculo(registroTest)).thenReturn(Boolean.TRUE);
		
		Boolean ingresoValido=registroVigilanteService.validarIngresoVehiculo(registroTest);
		
		assertEquals(true, ingresoValido);
	}
	
}
