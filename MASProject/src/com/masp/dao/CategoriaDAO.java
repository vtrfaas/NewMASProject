package com.masp.dao;

import com.masp.entity.Categoria;

public interface CategoriaDAO {
	public void adicionar(Categoria c);
	public Categoria pesquisar(String nome);
	public void remover(Long numero);
	public void atualizar(Categoria c);
}
