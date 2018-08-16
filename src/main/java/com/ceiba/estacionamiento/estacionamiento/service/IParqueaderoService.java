package com.ceiba.estacionamiento.estacionamiento.service;

public interface IParqueaderoService {

	
	public Boolean validarCuposParqueadero(String tipoVehiculo);
	
	public Boolean validarPlacaVehiculo(String placa);
}
