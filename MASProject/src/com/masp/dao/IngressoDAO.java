package com.masp.dao;

import java.util.List;

import com.masp.entity.Ingresso;

public interface IngressoDAO {
	public void adicionar(Ingresso ing);
	public List<Ingresso> pesquisar(String nome);
}
