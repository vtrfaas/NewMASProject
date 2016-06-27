package com.masp.dao;

import java.util.List;

import com.masp.entity.Exposicao;

public interface ExposicaoDAO {
	public void adicionar(Exposicao ex);
	public Exposicao pesquisar(String nome);
	public void remover(String nome);
	public void atualizar(Exposicao newE);
	public Exposicao pesquisarId(Long id);
	public List<Exposicao> pesquisarTudo();
}
