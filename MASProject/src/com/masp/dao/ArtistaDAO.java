package com.masp.dao;

import java.util.List;

import com.masp.entity.Artista;

public interface ArtistaDAO {
	public void adicionar(Artista a);
	public List<Artista> pesquisarPorNome(String nome);
	public Artista pesquisarPorId(Long id);
	public void remover(String nome);
	public void atualizar(Artista oldA, Artista newA);
}
