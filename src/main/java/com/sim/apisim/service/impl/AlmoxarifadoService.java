package com.sim.apisim.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.apisim.model.Almoxarifado;
import com.sim.apisim.repository.AlmoxarifadoRepository;
import com.sim.apisim.service.IAlmoxarifadoService;

@Service("AlmoxarifadoService")
public class AlmoxarifadoService extends GenericService<Almoxarifado, Long> implements IAlmoxarifadoService {

	@Autowired
	private AlmoxarifadoRepository repository;

	

	@Override
	public List<Almoxarifado> getAll() {
		return repository.findAll();
	}



	@Override
	public Almoxarifado get(Long id) {
		return repository.getOne(id);
	}

	@Override
	public Almoxarifado add(Almoxarifado entity) {
		return repository.save(entity);
	}

	@Override
	public Almoxarifado update(Long id, Almoxarifado entity) throws EntityNotFoundException {
		return super.update(id, entity);
	}

	@Override
	public Almoxarifado addOrUpdate(Almoxarifado entity) {
		return super.addOrUpdate(entity);
	}

	@Override
	public void remove(Almoxarifado entity) {
		super.remove(entity);
	}

	@Override
	public void removeById(Long id) throws EntityNotFoundException {
		super.removeById(id);
	}
	
	
}
