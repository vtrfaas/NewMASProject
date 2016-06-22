package com.masp.dao;

import com.masp.entity.Exposicao;

public interface ExposicaoDAO {
	public void adicionar(Exposicao ex);
	public Exposicao pesquisar(String nome);
	public void remover(String nome);
	public void atualizar(Exposicao oldE, Exposicao newE);
}
