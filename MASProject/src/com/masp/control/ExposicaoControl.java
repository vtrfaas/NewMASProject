package com.masp.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.masp.dao.ExposicaoDAO;
import com.masp.dao.ExposicaoDAOImpl;
import com.masp.entity.Exposicao;
import com.masp.entity.Obra;

public class ExposicaoControl implements TableModel, ExposicaoDAO {

	private List<Obra> lista = new ArrayList<Obra>();
	private ExposicaoDAO eDAO = new ExposicaoDAOImpl();
	private JFrame janela = new JFrame();
	
	public ExposicaoControl() {}
	
	public ExposicaoControl(JFrame janela){
		this.janela = janela;
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}
	
	public void adicionaObraLista(Obra o){
		lista.add(o);
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String [] nomes = {"Id", "Obra", "Descricao"};
		return nomes[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> [] classes = {Long.class, String.class, 
				String.class};
		return classes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch( columnIndex ) { 
			case 0 : return o.getId();
			case 1 : return o.getNomeObra();
			case 2 : return o.getDescricao();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch( columnIndex ) { 
			case 0 : o.setId( (Long) aValue  );
			case 1 : o.setNomeObra((String) aValue);
			case 2 : o.setDescricao((String) aValue);
		}
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
		for(int i = 0; i < ex.getObras().size(); i++){
			Obra o = ex.getObras().get( i );
			lista.add( o );
		}
		eDAO.adicionar(ex);
	}

	@Override
	public Exposicao pesquisar(String nome) {
		return eDAO.pesquisar(nome);
	}

	@Override
	public void remover(String nome) {
		eDAO.remover(nome);
	}

	@Override
	public void atualizar(Exposicao newE) {
		eDAO.atualizar(newE);
	}

	public void setLista(List<Obra> lista) {
		this.lista = lista;
	}
	public List<Obra> getLista() {
		return lista;
	}

	@Override
	public Exposicao pesquisarId(Long id) {
		return eDAO.pesquisarId(id);
	}

	@Override
	public List<Exposicao> pesquisarTudo() {
		return eDAO.pesquisarTudo();
	}
	
	public String pesquisarObra() { // ABRE UM JOptionPane COM UMA ComboBox - VITOR
		ObraControl oControl = new ObraControl();
		List<Obra> listaObra = oControl.pesquisarTudo();
		Object[] possibilities = new Object[ listaObra.size() ];
		for(int i = 0; i < listaObra.size(); i++){
		   possibilities[ i ] = listaObra.get( i ).getNomeObra();
		}
		if(possibilities.length > 0){
			String s = (String) JOptionPane.showInputDialog(janela, "Escolha a obra:\n", "Pesquisar obra",
					JOptionPane.INFORMATION_MESSAGE, null, possibilities, possibilities[0]);
			if (s != null && s.length() > 0) {
				return s;
			}
		}
		return "";
	}
}
