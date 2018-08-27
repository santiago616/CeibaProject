package com.ceiba.estacionamiento.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ceiba.estacionamiento.estacionamiento.entity.VehiculoEntity;

public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long>{

	@Query(value =  "	SELECT v from vehiculo v where UPPER(v.placa) like (:placa)")
	VehiculoEntity buscarRegistroPorPlaca(@Param("placa") String placa);
}
