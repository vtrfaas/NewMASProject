package com.masp.dao;

import java.util.List;

import com.masp.entity.Material;


public interface MaterialDAO {
	public void adicionar(Material m);

	public List<Material> pesquisar(Long id);
	
	public List<String> pesquisarTudo();

	public void remover(Material m);

	public void atualizar(Material m);
}
