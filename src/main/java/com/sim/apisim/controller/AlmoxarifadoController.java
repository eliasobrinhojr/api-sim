package com.sim.apisim.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Endpoints para cidades
 *
 * @author Elias Araujo - elias.dvlpr@gmail.com
 * @since 2019.05.02
 */

import com.sim.apisim.model.Almoxarifado;
import com.sim.apisim.service.impl.AlmoxarifadoService;

@Api(value = "Almoxarifado Controller", description = "Endpoints para almoxarifados.")
@RestController
@RequestMapping(path = "/api/almoxarifado", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlmoxarifadoController {
	
	private final AlmoxarifadoService service;
	
	@Autowired
    public AlmoxarifadoController(AlmoxarifadoService service) {
        this.service = service;
    }
	
	 /**
     * List all almoxarifados from Database
     *
     * @return A list of almoxarifados
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    @ApiOperation("Get all almoxarifados.")
    public List<Almoxarifado> getAllAlmoxarifados() {
        return service.getAll();
    }
    
    
}
