package com.ceiba.estacionamiento.estacionamiento.service.impl;

import java.math.BigDecimal;
import java.util.Date;

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

	@Autowired
	public RegistroVigilanteServiceImpl(RegistroVigilanteRepository registroVigilanteRepository,
			IEstacionamientoService estacionamientoService) {
		this.registroVigilanteRepository = registroVigilanteRepository;
		this.estacionamientoService = estacionamientoService;
	}

	@Override
	@Transactional
	public void almacenarRegistro(RegistroDTO registroVigilanteDTO) {
		RegistroDTO vehiculoExistente = consultarVehiculoPorPlaca(registroVigilanteDTO.getPlaca());

			if (vehiculoExistente == null
					&& validarIngresoVehiculo(registroVigilanteDTO)) {
				registroVigilanteDTO.setFacturado(Boolean.FALSE);
				RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
				registroVigilanteRepository.save(registroVigilante);

			} else {
				// EL AUTO YA ESTA ALMACENADO
			}
		
	}

	@Override
	@Transactional
	public void facturarVehiculo(String placa) {
		RegistroDTO registroVigilanteDTO=consultarVehiculoPorPlaca(placa);
		if (registroVigilanteDTO != null) {
			registroVigilanteDTO.setHoraSalida(new Date());
			BigDecimal tarifaTotalPorVehiculo = registroEstacionamiento.calcularValorParqueadero(registroVigilanteDTO);
			registroVigilanteDTO.setTotalServicio(tarifaTotalPorVehiculo);
			registroVigilanteDTO.setFacturado(Boolean.TRUE);
			actualizarRegistroFacturado(registroVigilanteDTO);
		}
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
	public void actualizarRegistroFacturado(RegistroDTO registroVigilanteDTO) {
		if (registroVigilanteDTO.getId() != null) {
			RegistroEntity registroVigilante = modelMapper.map(registroVigilanteDTO, RegistroEntity.class);
			registroVigilanteRepository.save(registroVigilante);
			registroVigilanteRepository.flush();
		}

	}

	@Override
	public Boolean validarIngresoVehiculo(RegistroDTO registroVigilanteDTO) {
		Boolean existenCuposDisponibles = estacionamientoService.validarCuposEstacionamiento(registroVigilanteDTO.getTipoVehiculo());
		Boolean placaValida = estacionamientoService.validarPlacaVehiculo(registroVigilanteDTO);
		return (existenCuposDisponibles && placaValida);
	}

}
