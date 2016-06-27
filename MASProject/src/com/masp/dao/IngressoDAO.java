package com.masp.dao;

import java.util.List;

import com.masp.entity.Ingresso;
import com.masp.entity.Material;

public interface IngressoDAO {
	public void adicionar(Ingresso ing);
	public List<Ingresso> pesquisar(String nome);
	public List<Ingresso> pesquisarId(Long id);
}
