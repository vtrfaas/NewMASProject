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
	
	public List<Artista> pesquisarPorNome(String nome){
		return aDAO.pesquisarPorNome(nome);
	}
	
	public void remover(String nome){
		aDAO.remover(nome);
	}
	
	public void atualizar(Artista newA){
		aDAO.atualizar(newA);
	}
	
	public Artista pesquisarPorId(Long id){
		return aDAO.pesquisarPorId(id);
	}
	
	
}
