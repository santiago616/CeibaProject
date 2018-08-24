package com.ceiba.estacionamiento.estacionamiento.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.estacionamiento.estacionamiento.dominio.Estacionamiento;
import com.ceiba.estacionamiento.estacionamiento.dto.RegistroDTO;
import com.ceiba.estacionamiento.estacionamiento.entity.RegistroEntity;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IEstacionamientoService;
import com.ceiba.estacionamiento.estacionamiento.service.IRegistroVigilanteService;

@Service
public class RegistroVigilanteServiceImpl implements IRegistroVigilanteService {

	RegistroVigilanteRepository registroVigilanteRepository;

	IEstacionamientoService estacionamientoService;

	Estacionamiento registroEstacionamiento = new Estacionamiento();

	private final ModelMapper modelMapper = new ModelMapper();
	
	private List<String> listaErrores;

	@Autowired
	public RegistroVigilanteServiceImpl(RegistroVigilanteRepository registroVigilanteRepository,
			IEstacionamientoService estacionamientoService) {
		this.registroVigilanteRepository = registroVigilanteRepository;
		this.estacionamientoService = estacionamientoService;
	}

	@Override
	@Transactional
	public RegistroDTO almacenarRegistro(RegistroDTO registroVigilanteDTO) {
		
			if (validarIngresoVehiculo(registroVigilanteDTO)) {
				if(registroVigilanteDTO.getHoraEntrada()==null) {
					registroVigilanteDTO.setHoraEntrada(new Date());
				}
				registroVigilanteDTO.setFacturado(Boolean.FALSE);
				RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
				return   modelMapper.map(registroVigilanteRepository.save(registroVigilante),RegistroDTO.class);

			} 
		return null;
	}

	@Override
	@Transactional
	public RegistroDTO facturarVehiculo(String placa) {
		RegistroDTO registroVigilanteDTO=consultarVehiculoPorPlaca(placa);
		if (registroVigilanteDTO != null) {
			registroVigilanteDTO.setHoraSalida(new Date());
			int[] tiempoTotal=registroEstacionamiento.calcularTiempoParqueado(registroVigilanteDTO);
			registroVigilanteDTO.setTiempoTotal(tiempoTotal);
			BigDecimal tarifaTotalPorVehiculo = registroEstacionamiento.calcularValorParqueadero(registroVigilanteDTO);
			registroVigilanteDTO.setTotalServicio(tarifaTotalPorVehiculo);
			registroVigilanteDTO.setFacturado(Boolean.TRUE);
			return actualizarRegistroFacturado(registroVigilanteDTO);
			
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public RegistroDTO consultarVehiculoPorPlaca(String placa) {
		if (placa != null) {
			RegistroEntity registroVigilante = registroVigilanteRepository.buscarRegistroPorPlaca(placa);
			if (registroVigilante != null) {
				
				return modelMapper.map(registroVigilante, RegistroDTO.class);
			}
		}
		return null;
	}

	@Override
	@Transactional
	public RegistroDTO actualizarRegistroFacturado(RegistroDTO registroVigilanteDTO) {
		if (registroVigilanteDTO.getId() != null) {
			RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
			return modelMapper.map(registroVigilanteRepository.save(registroVigilante),RegistroDTO.class);
		}
		return null;

	}

	@Override
	public Boolean validarIngresoVehiculo(RegistroDTO registroVigilanteDTO) {
		RegistroDTO vehiculoExistente = consultarVehiculoPorPlaca(registroVigilanteDTO.getPlaca());
		listaErrores=new ArrayList<>();
		if(vehiculoExistente!=null) {
			listaErrores.add("El vehiculo ya se encuentra registrado o la placa es invalida");
		}
		Boolean existenCuposDisponibles = estacionamientoService.validarCuposEstacionamiento(registroVigilanteDTO.getTipoVehiculo());
		if(!existenCuposDisponibles) {
			listaErrores.add("No existen cupos disponibles para este tipo de vehiculo.");
		}
		Boolean placaValida = estacionamientoService.validarPlacaVehiculo(registroVigilanteDTO);
		if(!placaValida) {
			listaErrores.add("El vehiculo no se encuentra autorizado para ingresar.");
		}
		return (listaErrores.isEmpty());
	}
	
	

	public List<String> getListaErrores() {
		return listaErrores;
	}

	public void setListaErrores(List<String> listaErrores) {
		this.listaErrores = listaErrores;
	}

}
