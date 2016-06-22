package com.masp.control;

import java.util.List;

import com.masp.dao.SetorDAO;
import com.masp.dao.SetorDAOImpl;
import com.masp.entity.Setor;

public class SetorControl {
	
	private SetorDAO sDAO = new SetorDAOImpl();
	
	public void adicionar(Setor s){
		sDAO.adicionar(s);
	}
	public List<Setor> pesquisar(String nomeSetor){
		return sDAO.pesquisar(nomeSetor);
	}
	
	public void remover(String numero){
		sDAO.excluir(numero);
	}
	
	public void atualizar(Setor oldS, Setor newS){
		
	}
}
