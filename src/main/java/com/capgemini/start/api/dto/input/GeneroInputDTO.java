package com.capgemini.start.api.dto.input;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(name = "GeneroInput", description = "Objeto de entrada para inclusão e alteração da entidade Genero")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneroInputDTO {
	
	@NotBlank(message="O campo não pode ser em branco!")
	@Length(max=100)
	private String descricao;

}
