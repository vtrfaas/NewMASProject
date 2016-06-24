package com.masp.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.masp.dao.IngressoDAO;
import com.masp.dao.IngressoDAOImpl;
import com.masp.entity.Ingresso;

public class IngressoControl implements TableModel, IngressoDAO {
	
	private IngressoDAO iDAO = new IngressoDAOImpl();
	private List<Ingresso> lista = new ArrayList<Ingresso>();
	
	public void adicionar(Ingresso ing){
		iDAO.adicionar(ing);
	}
	
	public List<Ingresso> pesquisar(String exposicao){
		return iDAO.pesquisar(exposicao);
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String [] nomes = {"Id", "Exposi��o", "Tipo Ingresso", "Data", "Valor"};
		return nomes[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> [] classes = {Long.class, String.class, 
				String.class, Date.class, Float.class };
		return classes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Ingresso ing = lista.get(rowIndex);
		switch( columnIndex ) { 
			case 0 : return ing.getId();
			case 1 : return ing.getExposicao();
			case 2 : return ing.getTipoIngresso();
			case 3 : return ing.getData();
			case 4 : return ing.getValor();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Ingresso ing = lista.get(rowIndex);
		switch( columnIndex ) { 
			case 0 : ing.setId( (Long) aValue  );
			case 1 : ing.setExposicao((String) aValue);
			case 2 : ing.setTipoIngresso((String) aValue);
			case 3 : ing.setData((Date) aValue);
			case 4 : ing.setValor((Float) aValue);
		}
	}
	
	public void setLista(List<Ingresso> lista) {
		this.lista = lista;
	}
	public List<Ingresso> getLista() {
		return lista;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
}
