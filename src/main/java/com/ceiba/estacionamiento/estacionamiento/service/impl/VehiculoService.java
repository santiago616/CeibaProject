package com.ceiba.estacionamiento.estacionamiento.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.estacionamiento.entity.Vehiculo;
import com.ceiba.estacionamiento.estacionamiento.repository.VehiculoRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IVehiculoService;

@Service
public class VehiculoService implements IVehiculoService{

	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Override
	public List<Vehiculo> mostrarVehiculos() {
		List<Vehiculo> vehiculos =  vehiculoRepository.findAll();
		return vehiculos;
	}

}
