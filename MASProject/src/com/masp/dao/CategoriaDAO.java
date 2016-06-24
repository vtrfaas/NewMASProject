package com.masp.dao;

import java.util.List;

import com.masp.entity.Categoria;

public interface CategoriaDAO {
	public void adicionar(Categoria c);
	public Categoria pesquisarPorNome(String nome);
	public Categoria pesquisarPorId(Long id);
	public List<Categoria> pesquisarTudo();
	public void remover(String nome);
	public void atualizar(Categoria newC);
}
