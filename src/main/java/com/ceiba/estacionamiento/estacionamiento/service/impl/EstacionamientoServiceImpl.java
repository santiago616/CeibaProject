package com.ceiba.estacionamiento.estacionamiento.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.estacionamiento.dominio.Estacionamiento;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IEstacionamientoService;

@Service
public class EstacionamientoServiceImpl implements IEstacionamientoService {

	RegistroVigilanteRepository registroVigilanteRepository;


	Estacionamiento registroParqueadero = new Estacionamiento();
	
	@Autowired
	public EstacionamientoServiceImpl(RegistroVigilanteRepository registroVigilanteRepository) {
		this.registroVigilanteRepository=registroVigilanteRepository;
	}

	@Override
	public Boolean validarCuposEstacionamiento(String tipoVehiculo) {
		Long vehiculosParqueados=registroVigilanteRepository.buscarRegistrosPorTipoVehiculo(tipoVehiculo);
		return registroParqueadero.validarDisponiblidadCupos(vehiculosParqueados, tipoVehiculo);
	}

	@Override
	public Boolean validarPlacaVehiculo(RegistroDTO registroVigilanteDTO,Calendar hoy) {
		return registroParqueadero.validarPlacaDomingoLunes(registroVigilanteDTO,hoy);
	}

}
