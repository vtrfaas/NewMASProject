package com.masp.dao;

import java.util.List;

import com.masp.entity.Material;


public interface MaterialDAO {
	public void adicionar(Material m);

	public List<Material> pesquisarNome(String nome);
	
	public Material pesquisarId(Long id);
	
	public List<Material> pesquisarTudo();

	public void remover(Material m);

	public void atualizar(Material m);
}
