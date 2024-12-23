package com.sim.apisim.service;

import javassist.NotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IGenericService<T, ID> {

  	T saveOrUpdate(T entity);
    List<T> getAll();
    List<T> search(Example<T> entity);
    Page<T> getAllPaginated(int page, int count, Sort.Direction direction, String sortProperty);
    T get(ID id) throws NotFoundException;
    T add(T entity);
    T update(ID id, T entity) throws NotFoundException;
    T addOrUpdate(T entity);
    void remove(T entity);
    void removeById(ID id) throws NotFoundException;
    
}
