package com.capgemini.start.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.capgemini.start.api.dto.input.GeneroInputDTO;
import com.capgemini.start.api.dto.output.GeneroDTO;
import com.capgemini.start.domain.entity.Genero;
/* Mapeamento de objetos e transforamção de um objeto para outro Ex.: Entidade para DTO*/
@Component
@Mapper(componentModel = "spring")
public interface GeneroMapper {

	GeneroDTO toDTO(Genero genero);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAlteracao", ignore = true)
	Genero toEntity(GeneroInputDTO tipo);

}