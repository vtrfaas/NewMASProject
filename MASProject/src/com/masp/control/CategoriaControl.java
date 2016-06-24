package com.masp.control;

import java.util.List;

import com.masp.dao.CategoriaDAO;
import com.masp.dao.CategoriaDAOImpl;
import com.masp.entity.Categoria;

public class CategoriaControl implements CategoriaDAO{
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
	@Override
	public List<Categoria> pesquisarTudo() {
		return cDAO.pesquisarTudo();
	}
	@Override
	public void remover(String nome) {
		cDAO.remover(nome);
	}
	@Override
	public void atualizar(Categoria newC) {
		cDAO.atualizar(newC);
	}
	
	
}
