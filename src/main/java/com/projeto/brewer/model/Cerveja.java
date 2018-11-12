package com.projeto.brewer.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cerveja {
	
	
	@NotBlank(message= "SKU e obrigatorio")
	private String sku;
	
	
	@NotBlank(message= "Nome e obrigatorio")
	private String nome;
	
	@Size(min = 1, max=50, message = "o tamanho da descricao deve esta entre 1 e 50")
	private String descricao;
	
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
