package com.masp.entity;

import java.util.Date;

public class Exposicao {
	private Long id;
	private String titulo;
	private Date dtInicio;
	private Date dtFim;
	private String tema;
	private String descricao;
	private Obra[] obras;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Obra[] getObras() {
		return obras;
	}
	public void setObras(Obra[] obras) {
		this.obras = obras;
	}
}
