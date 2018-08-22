package com.ceiba.estacionamiento.estacionamiento.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(path = "/guardarRegistro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> guardarRegistro(@RequestBody RegistroDTO registroVigilanteDTO) {
		if(registroVigilanteDTO!=null) {
			registroVigilanteService.almacenarRegistro(registroVigilanteDTO);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return null;
	}
	
	@PutMapping(value = "/registro/{placa}")
	public ResponseEntity<Void> facturarRegistro(@PathVariable(value="placa") String placa) {
		if(placa!=null) {
			registroVigilanteService.facturarVehiculo(placa);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value = "/registro/{placa}", method = RequestMethod.GET)
	public ResponseEntity<RegistroDTO> obtenerRegistro(@PathVariable(value="placa")String placa) {
		ResponseEntity<RegistroDTO> resultado=null;
		RegistroDTO registoConsultado= registroVigilanteService.consultarVehiculoPorPlaca(placa);
		if(registoConsultado!=null) {
			resultado= ResponseEntity.ok().body(registoConsultado);
		}else {
			resultado=ResponseEntity.badRequest().body(null);
		}
		return resultado;
	}
}
