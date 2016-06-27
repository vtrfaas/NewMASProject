package com.masp.entity;

import java.util.Date;

public class Ingresso {
	private Long id;
	private Date data;
	private Float valor;
	private int qtde;
	private long idExposicao;
	private String tipoIngresso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public long getExposicao() {
		return idExposicao;
	}
	public void setExposicao(long exposicao) {
		this.idExposicao = exposicao;
	}
	public String getTipoIngresso() {
		return tipoIngresso;
	}
	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}
}
