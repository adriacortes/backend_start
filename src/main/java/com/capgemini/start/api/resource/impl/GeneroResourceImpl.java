package com.capgemini.start.api.resource.impl;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.start.api.dto.input.GeneroInputDTO;
import com.capgemini.start.api.dto.output.GeneroDTO;
import com.capgemini.start.api.mapper.GeneroMapper;
import com.capgemini.start.api.resource.GeneroResorce;
import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.service.GeneroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api/generos")
@RequiredArgsConstructor
public class GeneroResourceImpl implements GeneroResorce{
	
	private final GeneroService service;
	
	
	@Autowired
	private GeneroMapper mapper;
	
	/*INSERINDO DADOS*/
	@Override
	public ResponseEntity<GeneroDTO> insert(@RequestBody @Valid GeneroInputDTO generoInputDto) {
		Genero entity = mapper.toEntity(generoInputDto);
		Genero createdEntity = this.service.insert(entity);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntity.getId())
                .toUri();
	
		return ResponseEntity.status(HttpStatus.CREATED)
				.header(HttpHeaders.LOCATION, location.toString())
				.body(mapper.toDTO(createdEntity));
	}
	
	/*BUSCAR TODOS OS DADOS*/
	@Override
	public ResponseEntity<List<GeneroDTO>> findAll() {
		return ResponseEntity.ok(
				this.service.findAll()
				.stream()
				.map(genero -> mapper.toDTO(genero))
				.collect(Collectors.toList())
			);		
			
	}
	
	/* BUSCAR DADOS POR ID*/
    @Override
    public ResponseEntity<GeneroDTO> findById(Long id) {
    	Genero genero = this.service.findById(id);
    	GeneroDTO generoDto = mapper.toDTO(genero);
    	return ResponseEntity.ok(generoDto);
    }
    
    @Override
    public ResponseEntity<GeneroDTO> update(Long id, @Valid GeneroInputDTO genero) {
    	
    	Genero toUpdate = this.service.findById(id);/*busca a entidade para alterar*/
    	toUpdate.setDescricao(genero.getDescricao()); /*seta a descrição alterada na entidade encontrada*/
    	
    	Genero update = this.service.update(toUpdate);/*chama a função para alterar no banco de dados e retorna a entidade*/
    	
    	return  ResponseEntity.ok(mapper.toDTO(update));
    }

	@Override
	public ResponseEntity<Void> delete(Long id) {
		this.service.delete(id);
		return ResponseEntity.ok().build();
	}
    
    
    
	
	
	

}