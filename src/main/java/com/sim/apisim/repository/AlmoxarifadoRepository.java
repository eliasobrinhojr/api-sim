package com.sim.apisim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sim.apisim.model.Almoxarifado;

@Repository
public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {

}
