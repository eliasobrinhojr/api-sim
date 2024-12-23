package com.sim.apisim.service.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import com.sim.apisim.exception.EntityInvalidException;
import com.sim.apisim.service.IGenericService;

public class GenericService<T, ID extends Serializable> implements IGenericService<T, ID> {
	@Autowired
	private JpaRepository<T, ID> repository;

	@Override
	public T saveOrUpdate(T entity) {
		try {
			return repository.save(entity);
		} catch (ConstraintViolationException e) {
			// TODO: handle exception
			throw new EntityInvalidException(e.getMessage());
		}
	}

	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public List<T> search(Example<T> entity) {
		return repository.findAll(entity);
	}

	@Override
	public Page<T> getAllPaginated(int page, int count, Sort.Direction direction, String sortProperty) {
		return repository.findAll(PageRequest.of(page, count, new Sort(direction, sortProperty)));
	}

	@Override
	public T get(ID id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada."));
	}

	@Override
	public T add(T entity) {
		return repository.save(entity);
	}

	@Override
	public T update(ID id, T entity) throws EntityNotFoundException {
		this.checkEntity(repository.findById(id));
		return repository.save(entity);
	}

	@Override
	public T addOrUpdate(T entity) {
		return repository.save(entity);
	}

	@Override
	public void remove(T entity) {
		repository.delete(entity);
	}

	@Override
	public void removeById(ID id) throws EntityNotFoundException {
		this.checkEntity(repository.findById(id));
		repository.deleteById(id);
	}

	private void checkEntity(Optional<T> inDb) throws EntityNotFoundException {
		if (!inDb.isPresent())
			throw new EntityNotFoundException("Não encontrado.");
	}
}
