package com.ceiba.estacionamiento.estacionamiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.estacionamiento.dominio.Registro;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IParqueaderoService;

@Service
public class ParqueaderoServiceImpl implements IParqueaderoService {

	RegistroVigilanteRepository registroVigilanteRepository;


	Registro registroParqueadero = new Registro();
	
	@Autowired
	public ParqueaderoServiceImpl(RegistroVigilanteRepository registroVigilanteRepository) {
		this.registroVigilanteRepository=registroVigilanteRepository;
	}

	@Override
	public Boolean validarCuposParqueadero(String tipoVehiculo) {
		Long vehiculosParqueados=registroVigilanteRepository.buscarRegistrosPorTipoVehiculo(tipoVehiculo);
		return registroParqueadero.validarDisponiblidadCupos(vehiculosParqueados, tipoVehiculo);
	}

	@Override
	public Boolean validarPlacaVehiculo(String placa) {
		return registroParqueadero.validarPlacaDomingoLunes(placa);
	}

}
