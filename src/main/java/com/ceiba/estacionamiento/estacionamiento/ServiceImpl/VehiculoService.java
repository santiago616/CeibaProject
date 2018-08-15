package com.ceiba.estacionamiento.estacionamiento.ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.estacionamiento.estacionamiento.IService.IVehiculoService;
import com.ceiba.estacionamiento.estacionamiento.Repository.VehiculoRepository;
import com.ceiba.estacionamiento.estacionamiento.entity.Vehiculo;

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
