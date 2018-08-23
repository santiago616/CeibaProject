package com.ceiba.estacionamiento.estacionamiento.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

	@PostMapping(path = "/guardarRegistro")
	public ResponseEntity<RegistroDTO> guardarRegistro(@RequestBody RegistroDTO registroVigilanteDTO) {
		ResponseEntity<RegistroDTO> result = null;
		if (!registroVigilanteDTO.getPlaca().isEmpty()) {
			RegistroDTO registro=registroVigilanteService.almacenarRegistro(registroVigilanteDTO);
			List<String> listaErrores = registroVigilanteService.getListaErrores();
			if (listaErrores.isEmpty()) {
				result = ResponseEntity.ok().body(registro);
			} else {
				String retornarErrores = "";
				for (int i = 0; i < listaErrores.size(); i++) {
					retornarErrores =   new StringBuilder().append(listaErrores.get(i)).append(" ").toString() ;
				}
				HttpHeaders headers = new HttpHeaders();
				headers.set("errores-estacionamiento", retornarErrores);
				result = ResponseEntity.badRequest().headers(headers).body(registro);
				return result;
			}
		}
		return result;
	}

	@PutMapping(value = "/registro/{placa}")
	public ResponseEntity<RegistroDTO> facturarRegistro(@PathVariable(value = "placa") String placa) {
		ResponseEntity<RegistroDTO> result = null;
		RegistroDTO registroActualizado=registroVigilanteService.facturarVehiculo(placa);
		if(registroActualizado!=null) {
			result= ResponseEntity.ok().body(registroActualizado);
		}else {
			HttpHeaders headers = new HttpHeaders();
			headers.set("vehiculo-no-existe", "El vehiculo a facturar no existe");
			result = ResponseEntity.badRequest().headers(headers).body(registroActualizado);
		}
		
		return result;

	}

	@RequestMapping(value = "/registro/{placa}", method = RequestMethod.GET)
	public ResponseEntity<RegistroDTO> obtenerRegistro(@PathVariable(value = "placa") String placa) {
		ResponseEntity<RegistroDTO> resultado = null;
		RegistroDTO registoConsultado = registroVigilanteService.consultarVehiculoPorPlaca(placa);
		if (registoConsultado != null) {
			resultado = ResponseEntity.ok().body(registoConsultado);
		} else {
			resultado = ResponseEntity.badRequest().body(null);
		}
		return resultado;
	}
}
