package com.masp.dao;

import java.util.List;

import com.masp.entity.Artista;

public interface ArtistaDAO {
	public void adicionar(Artista a);
	public List<Artista> pesquisar(String nome);
	public void remover(Artista a);
	public void atualizar(Artista a);
}
