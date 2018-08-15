package com.ceiba.estacionamiento.estacionamiento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.estacionamiento.ServiceImpl.VehiculoService;
import com.ceiba.estacionamiento.estacionamiento.entity.Vehiculo;

@RestController
public class EstacionamientoController {

	@Autowired
	private VehiculoService vehiculoService;

	@RequestMapping(value = "/vehiculos", method = RequestMethod.GET)
	public List<Vehiculo> vehiculos() {

		List<Vehiculo> vehiculos = vehiculoService.mostrarVehiculos();
		return vehiculos;
	}
}
