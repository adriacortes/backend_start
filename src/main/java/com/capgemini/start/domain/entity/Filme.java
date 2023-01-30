package com.capgemini.start.domain.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name="tb_filme")
public class Filme {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_filme",nullable = false)
	private Integer Id;
	
/*	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name="id_genero"))
	@Column(name="id_generofilme",nullable = false)
	private Integer IdGenero;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name="id_tipo"))
	@JoinColumn(referencedColumnName = "tb_tipo")
	@Column(name="id_tipofilme",nullable = false)
	private Integer IdTipo; */
	
	@Column(name = "ds_filme",nullable = false)
	private String descricao;
	
	@Column(name="dt_criacao",nullable = false)
	private Date dataCriacao;
	
	@Column(name="dt_alteracao")
	private Date dataAlteracao;
	
	
	
}
