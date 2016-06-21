package com.masp.control;

import com.masp.dao.CategoriaDAO;
import com.masp.dao.CategoriaDAOImpl;
import com.masp.entity.Categoria;

public class CategoriaControl {
	private CategoriaDAO cDAO = new CategoriaDAOImpl();
	
	public void adicionar(Categoria c){
		cDAO.adicionar(c);
	}
	public Categoria pesquisar(String nome){
		return cDAO.pesquisar(nome);
	}
}
