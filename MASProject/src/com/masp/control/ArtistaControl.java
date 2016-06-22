package com.masp.control;
import java.util.List;

import com.masp.dao.ArtistaDAOImpl;
import com.masp.dao.ArtistaDAO;
import com.masp.entity.Artista;

public class ArtistaControl {
	
	private ArtistaDAO aDAO = new ArtistaDAOImpl();
	
	public void adicionar(Artista a){
		aDAO.adicionar(a);
	}
	
	public List<Artista> pesquisar(String nome){
		return aDAO.pesquisar(nome);
	}
	
	public void remover(String nome){
		aDAO.remover(nome);
	}
	
	public void atualizar(Artista oldA, Artista newA){
		aDAO.atualizar(oldA, newA);
	}
	
	
}
