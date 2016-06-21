package com.masp.entity;

import java.util.Date;

public class Artista {
	private long id;
	private String nome;
	private String localNasc;
	private Date anoNasc;
	private Date anoMorte;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalNasc() {
		return localNasc;
	}
	public void setLocalNasc(String localNasc) {
		this.localNasc = localNasc;
	}
	public Date getAnoNasc() {
		return anoNasc;
	}
	public void setAnoNasc(Date anoNasc) {
		this.anoNasc = anoNasc;
	}
	public Date getAnoMorte() {
		return anoMorte;
	}
	public void setAnoMorte(Date anoMorte) {
		this.anoMorte = anoMorte;
	}
}
