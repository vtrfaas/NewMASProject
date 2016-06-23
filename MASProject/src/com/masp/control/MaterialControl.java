package com.masp.control;

import com.masp.dao.MaterialDAOImpl;
import com.masp.entity.Material;

public class MaterialControl {
	
	MaterialDAOImpl mDAO = new MaterialDAOImpl();

	//Este metodo serve SÓ para auto-selecionar um item da combo
	public String pesquisarSelecionado(Long idMaterial) {
		Material m = new Material();
		m = mDAO.pesquisar(idMaterial).get(0);
		return m.getNome();
	}

}
