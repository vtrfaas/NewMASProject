package com.masp.dao;

import java.util.List;

import com.masp.entity.Setor;

public interface SetorDAO {
	public void adicionar(Setor s);
	public List<Setor> pesquisar(String nomeSetor);
}