package com.masp.control;

import com.masp.dao.CategoriaDAO;
import com.masp.dao.CategoriaDAOImpl;
import com.masp.entity.Categoria;

public class CategoriaControl {
	private CategoriaDAO cDAO = new CategoriaDAOImpl();
	
	public void adicionar(Categoria c){
		cDAO.adicionar(c);
	}
	public Categoria pesquisarPorNome(String nome){
		return cDAO.pesquisarPorNome(nome);
	}
	
	public Categoria pesquisarPorId(Long idCategoria) {
		return cDAO.pesquisarPorId(idCategoria);
	}
}
