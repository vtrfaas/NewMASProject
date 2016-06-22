package com.masp.dao;

import java.util.List;

import com.masp.entity.Obra;

public interface ObraDAO {
	
	public void adicionar(Obra o);

	public List<Obra> pesquisar(String nome);

	public void remover(Obra o);

	public void atualizar(Obra o);

}
