package com.ceiba.estacionamiento.estacionamiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.service.IRegistroVigilanteService;

@RestController
@RequestMapping("/registroVigilante")
public class RegistroVigilanteController {

	@Autowired
	private IRegistroVigilanteService registroVigilanteService;
	
	@PostMapping
	public void guardarRegistro(@RequestBody RegistroDTO registroVigilanteDTO) {
		System.out.println(registroVigilanteDTO.getId());
		if(registroVigilanteDTO!=null) {
			registroVigilanteService.almacenarRegistro(registroVigilanteDTO);
		}
	}
	
	@PutMapping
	public void facturarRegistro(@RequestBody RegistroDTO registroVigilanteDTO) {
		System.out.println(registroVigilanteDTO.getId());
		if(registroVigilanteDTO!=null) {
			registroVigilanteService.facturarVehiculo(registroVigilanteDTO);
		}
	}
	
	@RequestMapping(value = "/vehiculosParq/{id}", method = RequestMethod.GET)
	public RegistroDTO obtenerRegistro(@PathVariable(value="placa")String placa) {
		return registroVigilanteService.consultarVehiculoPorPlaca(placa);
	}
}
