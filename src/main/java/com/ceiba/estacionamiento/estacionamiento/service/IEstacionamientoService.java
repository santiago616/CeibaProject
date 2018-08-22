package com.ceiba.estacionamiento.estacionamiento.service;

import java.util.Calendar;

import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;

public interface IEstacionamientoService {

	
	public Boolean validarCuposEstacionamiento(String tipoVehiculo);
	
	public Boolean validarPlacaVehiculo(RegistroDTO registroVigilanteDTO,Calendar hoy);
}
