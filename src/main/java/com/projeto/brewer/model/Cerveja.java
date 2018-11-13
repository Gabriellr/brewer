package com.projeto.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	@NotBlank(message= "SKU e obrigatorio")
	private String sku;
	
	
	@NotBlank(message= "Nome e obrigatorio")
	private String nome;
	
	@Size(min = 1, max=50, message = "o tamanho da descricao deve esta entre 1 e 50")
	private String descricao;
	
	
	private BigDecimal valor;
	
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAcoolico;
	
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	

}
