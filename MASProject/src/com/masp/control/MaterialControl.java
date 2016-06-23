package com.masp.control;

import java.util.List;

import com.masp.dao.MaterialDAOImpl;
import com.masp.entity.Material;

public class MaterialControl {

	MaterialDAOImpl mDAO = new MaterialDAOImpl();

	public String pesquisarPorId(Long idMaterial) {
		return mDAO.pesquisarId(idMaterial).getNome();
	}

	public void adicionar(Material m) {
		mDAO.adicionar(m);
	}

	public List<Material> pesquisarPorNome(String nome) {
		return mDAO.pesquisarNome(nome);
	}

	public List<Material> pesquisarTudo() {
		return mDAO.pesquisarTudo();
	}

	public void remover(Material m) {
		mDAO.remover(m);
	}

	public void atualizar(Material m) {
		mDAO.atualizar(m);
	}

}
