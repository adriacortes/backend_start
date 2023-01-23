package com.capgemini.start.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.start.domain.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

    boolean existsByDescricaoIgnoreCase(String descricao);
	
	boolean existsByIdNotAndDescricaoIgnoreCase(Integer id, String descricao);
	
}
