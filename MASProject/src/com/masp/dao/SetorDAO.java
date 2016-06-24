package com.masp.dao;

import java.util.List;

import com.masp.entity.Setor;

public interface SetorDAO {
	public void adicionar(Setor s);
	public List<Setor> pesquisarPorNome(String nomeSetor);
	public Setor pesquisarPorId(Long id);
	public List<Setor> pesquisarTudo();
	public void atualizar(Setor newS);
	public void excluir(String numero);
}
