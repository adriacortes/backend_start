package com.capgemini.start.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.capgemini.start.domain.entity.Genero;
import com.capgemini.start.domain.repository.GeneroRepository;
import com.capgemini.start.domain.service.exceptions.ObjectAlreadyExistsException;
import com.capgemini.start.domain.service.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GeneroService extends AbstractService<Genero,Integer> {
	
	
	private final GeneroRepository repository;

	@Override
	protected JpaRepository<Genero, Integer> getRepository() {
		return this.repository;
	}
	
   @Override
	public Genero insert(Genero entity) {
	    entity.setDataCriacao(new Date());
		if(this.repository.existsByDescricaoIgnoreCase(entity.getDescricao())) {
			throw new ObjectAlreadyExistsException("Genero já cadastrado!");
		}
		return this.repository.save(entity);
	}
   
	@Override
	public List<Genero> findAll() {
		return repository.findAll();
	}
   
   @Override
   public Genero findById(Integer id) {
	   return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Gereno não encontrado!"));
	
   }
   
   @Override
   public Genero update(Genero entity) {
	   if(this.repository.existsByIdNotAndDescricaoIgnoreCase(entity.getId(),entity.getDescricao())) {
			throw new ObjectAlreadyExistsException("Já existe um genero com este mesmo nome!");
	    }
		entity.setDataAlteracao(new Date());
		return this.repository.save(entity);
   }
	
}
