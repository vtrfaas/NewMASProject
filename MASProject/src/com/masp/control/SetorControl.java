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
	public List<Setor> pesquisarPorNome(String nomeSetor){
		return sDAO.pesquisarPorNome(nomeSetor);
	}
	
	public Setor pesquisarPorId(Long id){
		return sDAO.pesquisarPorId(id);
		
	}
	
	public void remover(String nome){
		sDAO.excluir(nome);
	}
	
	public void atualizar(Setor newS){
		sDAO.atualizar(newS);
	}
}
