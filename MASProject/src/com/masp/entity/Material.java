package com.masp.entity;

public class Material {
	private long id;
	private long idCategoria;
	private String nome;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCategoria() {
		return idCategoria;
	}
	public void setCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
