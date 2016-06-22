package com.masp.dao;

import java.util.List;

import com.masp.entity.Emprestimo;

public interface EmprestimoDAO {
	public void adicionar(Emprestimo e);
	public List<Emprestimo> pesquisar(String museu);
	public void atualizar(Emprestimo oldM, Emprestimo newM);
}
