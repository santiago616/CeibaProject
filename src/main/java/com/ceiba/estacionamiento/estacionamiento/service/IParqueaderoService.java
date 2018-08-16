package com.ceiba.estacionamiento.estacionamiento.service;

public interface IParqueaderoService {

	
	public boolean validarCuposParqueadero(String tipoVehiculo);
	
	public boolean validarPlacaVehiculo(String placa);
}
