package com.masp.dao;

import java.util.List;

import com.masp.entity.Obra;

public interface ObraDAO {
	
	public void adicionar(Obra o);

	public List<Obra> pesquisar(String nome);

	public void remover(String nome);

	public void atualizar(Obra newO);
	
	public Obra pesquisarPorId(long id);
	
	public List<Obra> pesquisarTudo();

}
