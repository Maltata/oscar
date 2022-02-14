package com.apioscar.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiltroBuscaDto {

	private String tamanhoCalcado;
    private String categoriaCalcado;
    private String corCalcado;
    private BigDecimal precoCalcado;
    private String marcaCalcado;
    private Date dataCadCalcado;
    private String descricaoCalcado;
    
    @JsonProperty("tamanho_calcado")
	public String getTamanhoCalcado()
	{
		return tamanhoCalcado;
	}
	
	public void setTamanhoCalcado(String tamanhoCalcado)
	{
		this.tamanhoCalcado = tamanhoCalcado;
	}
	
	@JsonProperty("categoria_calcado")
	public String getCategoriaCalcado()
	{
		return categoriaCalcado;
	}
	
	public void setCategoriaCalcado(String categoriaCalcado)
	{
		this.categoriaCalcado = categoriaCalcado;
	}
	
	@JsonProperty("cor_calcado")
	public String getCorCalcado()
	{
		return corCalcado;
	}
	
	public void setCorCalcado(String corCalcado)
	{
		this.corCalcado = corCalcado;
	}
	
	@JsonProperty("preco_calcado")
	public BigDecimal getPrecoCalcado()
	{
		return precoCalcado;
	}
	
	public void setPrecoCalcado(BigDecimal precoCalcado)
	{
		this.precoCalcado = precoCalcado;
	}
	
	@JsonProperty("marca_calcado")
	public String getMarcaCalcado()
	{
		return marcaCalcado;
	}
	
	public void setMarcaCalcado(String marcaCalcado)
	{
		this.marcaCalcado = marcaCalcado;
	}
	
	@JsonProperty("data_cad_calcado")
	public Date getDataCadastroCalcado()
	{
		return dataCadCalcado;
	}
	
	public void setDataCadastroCalcado(Date dataCadCalcado)
	{
		this.dataCadCalcado = dataCadCalcado;
	}
	
	@JsonProperty("descricao_calcado")
	public String getDescricaoCalcado()
	{
		return descricaoCalcado;
	}
	
	public void setDescricaoCalcado(String descricaoCalcado)
	{
		this.descricaoCalcado = descricaoCalcado;
	}

}
