package com.ceiba.estacionamiento.estacionamiento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.estacionamiento.estacionamiento.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}
