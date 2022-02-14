package com.apioscar.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calcado")
public class Calcado {

	private Long idCalcado;
	private String tamanhoCalcado;
	private String categoriaCalcado;
	private String corCalcado;
	private BigDecimal precoCalcado;
	private String marcaCalcado;
	private LocalDate dataCadCalcado;
	private Integer quantidadeEstoqueCalcado;
	private String descricaoCalcado;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdCalcado() 
	{
		return idCalcado;
	}
	
	public void setIdCalcado(Long idCalcado) 
	{
		this.idCalcado = idCalcado;
	}
	
	public String getTamanhoCalcado() 
	{
		return tamanhoCalcado;
	}
	
	public void setTamanhoCalcado(String tamanhoCalcado)
	{
		this.tamanhoCalcado = tamanhoCalcado;
	}
	
	public String getCategoriaCalcado()
	{
		return categoriaCalcado;
	}
	
	public void setCategoriaCalcado(String categoriaCalcado) 
	{
		this.categoriaCalcado = categoriaCalcado;
	}
	
	public String getCorCalcado() 
	{
		return corCalcado;
	}
	
	public void setCorCalcado(String corCalcado) 
	{
		this.corCalcado = corCalcado;
	}
	
	public BigDecimal getPrecoCalcado()
	{
		return precoCalcado;
	}
	
	public void setPrecoCalcado(BigDecimal precoCalcado)
	{
		this.precoCalcado = precoCalcado;
	}
	
	public String getMarcaCalcado() 
	{
		return marcaCalcado;
	}
	
	public void setMarcaCalcado(String marcaCalcado) 
	{
		this.marcaCalcado = marcaCalcado;
	}
	
	public LocalDate getDataCadCalcado()
	{
		return dataCadCalcado;
	}
	
	public void setDataCadCalcado(LocalDate dataCadCalcado) 
	{
		this.dataCadCalcado = dataCadCalcado;
	}
	
	public Integer getQuantidadeEstoqueCalcado()
	{
		return quantidadeEstoqueCalcado;
	}
	
	public void setQuantidadeEstoqueCalcado(Integer qtdEstoqueCalcado) 
	{
		this.quantidadeEstoqueCalcado = qtdEstoqueCalcado;
	}
	
	public String getDescricaoCalcado()
	{
		return descricaoCalcado;
	}
	
	public void setDescricaoCalcado(String descricaoCalcado)
	{
		this.descricaoCalcado = descricaoCalcado;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriaCalcado == null) ? 0 : categoriaCalcado.hashCode());
		result = prime * result + ((idCalcado == null) ? 0 : idCalcado.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calcado other = (Calcado) obj;
		if (categoriaCalcado == null) {
			if (other.categoriaCalcado != null)
				return false;
		} else if (!categoriaCalcado.equals(other.categoriaCalcado))
			return false;
		if (idCalcado == null) {
			if (other.idCalcado != null)
				return false;
		} else if (!idCalcado.equals(other.idCalcado))
			return false;
		return true;
	}
	
}
