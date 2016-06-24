package com.masp.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.masp.dao.ExposicaoDAO;
import com.masp.entity.Exposicao;
import com.masp.entity.Ingresso;

public class ExposicaoControl implements TableModel, ExposicaoDAO {

	private List<Exposicao> lista = new ArrayList<Exposicao>();
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionar(Exposicao ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Exposicao pesquisar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String nome) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Exposicao oldE, Exposicao newE) {
		// TODO Auto-generated method stub
		
	}

	public void setLista(List<Exposicao> lista) {
		this.lista = lista;
	}
	public List<Exposicao> getLista() {
		return lista;
	}
}
