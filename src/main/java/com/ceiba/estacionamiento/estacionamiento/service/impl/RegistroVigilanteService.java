package com.ceiba.estacionamiento.estacionamiento.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.estacionamiento.estacionamiento.dto.RegistroVigilanteDTO;
import com.ceiba.estacionamiento.estacionamiento.entity.RegistroVigilante;
import com.ceiba.estacionamiento.estacionamiento.repository.RegistroVigilanteRepository;
import com.ceiba.estacionamiento.estacionamiento.service.IRegistroVigilanteService;

@Service
public class RegistroVigilanteService implements IRegistroVigilanteService{

	@Autowired
	private RegistroVigilanteRepository	registroVigilanteRepository;
	
	private final  ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional
	public void almacenarRegistro(RegistroVigilanteDTO registroVigilanteDTO) {
		registroVigilanteDTO.setHoraEntrada(new Date());
		registroVigilanteDTO.setHoraSalida(new Date());
		registroVigilanteDTO.setFacturado(Boolean.FALSE);
		RegistroVigilante registroVigilante = modelMapper.map(registroVigilanteDTO,RegistroVigilante.class);
		registroVigilanteRepository.save(registroVigilante);
		
	}

	@Override
	@Transactional
	public void facturarVehiculo(RegistroVigilanteDTO registroVigilanteDTO) {
		if(registroVigilanteDTO.getId()!=null) {
		//RegistroVigilanteDTO registroVigilanteDTO= consultarVehiculoPorId(id);
		if(registroVigilanteDTO.getId()!=null) {
//			registroVigilanteDTO.setTotalServicio(new BigDecimal(500000));
//			registroVigilanteDTO.setFacturado(Boolean.FALSE);
			actualizarRegistroFacturado(registroVigilanteDTO);
		}
		}
	}

	@Override
	@Transactional(readOnly=true)
	public RegistroVigilanteDTO consultarVehiculoPorId(Long id) {
		if(id!=null) {
			RegistroVigilante registroVigilante= registroVigilanteRepository.findById(id).orElse(null);
			if(registroVigilante.getId()!=null) {
			RegistroVigilanteDTO registroVigilanteDTO= modelMapper.map(registroVigilante,RegistroVigilanteDTO.class);
			return registroVigilanteDTO;
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public void actualizarRegistroFacturado(RegistroVigilanteDTO registroVigilanteDTO) {
		if(registroVigilanteDTO.getId()!=null) {
			RegistroVigilante registroVigilante = modelMapper.map(registroVigilanteDTO,RegistroVigilante.class);
			registroVigilanteRepository.save(registroVigilante);
			registroVigilanteRepository.flush();
		}
		
	}

}
