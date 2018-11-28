package com.projeto.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.projeto.brewer.validation.SKU;


@Entity
@Table(name = "cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	@SKU
	@NotBlank(message= "SKU e obrigatorio")
	private String sku;
	
	
	@NotBlank(message= "Nome e obrigatorio")
	private String nome;
	
	@NotNull(message = "Obriatorio digita uma descricao")
	@Size(min = 1, max=50, message = "o tamanho da descricao deve esta entre 1 e 50")
	private String descricao;
	
	@NotNull(message = "Valor e obrigatorio")
	@DecimalMin("0.01")
	@DecimalMax(value = "99999.99", message = "O valor da cerveja nao pode ser maior que 99999.99")
	private BigDecimal valor;
    
	@NotNull(message = "Obriagatorio digitar um valor TeorAlcoolico")
	@Column(name = "teor_alcoolico")
	@DecimalMax(value = "99.9", message = "O valor do teor Acoolico nao deve ser maior que 99,9")
	private BigDecimal teorAlcoolico;
	
	@NotNull(message = "Obrigatorio valor na comissao")
	@DecimalMax(value = "100.0", message ="O valor da comissão nao deve ser maior que 100")
	private BigDecimal comissao;
	
	@NotNull(message = "Obrigatorio quantidade de estoque")
	@Max(value = 9999, message = "A quantidade em estoque nao deve ser maior 9.999")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@NotNull(message ="A origem e obrigatorio")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull(message="O Sabor e obrigatorio")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@NotNull(message="O estilo e obrigatorio")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;
	
	
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
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}
	public void setTeorAlcoolico(BigDecimal teorAcoolico) {
		this.teorAlcoolico = teorAcoolico;
	}
	public BigDecimal getComissao() {
		return comissao;
	}
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Origem getOrigem() {
		return origem;
	}
	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
	public Sabor getSabor() {
		return sabor;
	}
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
		
		
	}
		
	
	

}
