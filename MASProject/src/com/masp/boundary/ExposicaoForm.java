package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.masp.control.ExposicaoControl;
import com.masp.control.ObraControl;
import com.masp.entity.Exposicao;
import com.masp.entity.Obra;


public class ExposicaoForm implements ActionListener, ListSelectionListener{
	private JFrame janela = new JFrame("EXPOSIÇÃO");
	private JTextField txtId = new JTextField();
	private JTextField txtTitulo = new JTextField();
	private JTextField txtDtInicio = new JTextField();
	private JTextField txtDtFim = new JTextField();
	private JTextField txtTema = new JTextField();
	private JTextArea txtaDescricao = new JTextArea();
	private JTextField txtValor = new JTextField();
	private JTable tabelaObras;
	private ExposicaoControl controle = new ExposicaoControl();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnGravar = new JButton("Gravar");
	
	public ExposicaoForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JScrollPane panTable = new JScrollPane();
		JPanel panFormulario = new JPanel( new GridLayout(9, 3) );
		JPanel panBotoes = new JPanel();
		
		txtId.setEditable(false);
		panFormulario.add( new JLabel("Id: ") );
		panFormulario.add( txtId );
		panFormulario.add( new JLabel() );
		
		panFormulario.add( new JLabel("Titulo: ") );
		panFormulario.add( txtTitulo );
		panFormulario.add( btnPesquisar );
		
		panFormulario.add( new JLabel("Data Inicio: ") );
		panFormulario.add( txtDtInicio );
		panFormulario.add( new JLabel() );
		
		panFormulario.add( new JLabel("Data Fim: ") );
		panFormulario.add( txtDtFim );
		panFormulario.add( new JLabel() );
		
		panFormulario.add( new JLabel("Tema: ") );
		panFormulario.add( txtTema );
		panFormulario.add( new JLabel() );
		
		panFormulario.add( new JLabel("Descrição: ") );
		panFormulario.add( txtaDescricao );
		panFormulario.add( new JLabel() );
		
		panFormulario.add( new JLabel("Valor do ingresso: ") );
		panFormulario.add( txtValor );
		panFormulario.add( new JLabel() );
		
		panFormulario.add( new JLabel() );
		panFormulario.add( new JLabel() );
		panFormulario.add( new JLabel() );
		
		panFormulario.add( btnAdicionar );
		panFormulario.add( new JLabel() );
		panFormulario.add( btnExcluir );
		
		panBotoes.add( btnGravar );
		
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		btnExcluir.addActionListener( this );
		btnGravar.addActionListener( this );
		
		panPrincipal.add( panBotoes, BorderLayout.SOUTH);
		panPrincipal.add(panFormulario, BorderLayout.NORTH);
		panPrincipal.add(panTable, BorderLayout.CENTER);
		
		tabelaObras = new JTable( controle );
		tabelaObras.getSelectionModel().addListSelectionListener( this );
		
		panTable.getViewport().add( tabelaObras );
		
		janela.setContentPane( panPrincipal );
		
		janela.setSize(600, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
	}
	
	public void exposicaoToForm(Exposicao i, List<Obra> obras){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int j = 0;
		txtId.setText( Long.toString( i.getId() ) );
		txtTitulo.setText( sdf.format( i.getTitulo() ) );
		txtDtInicio.setText( sdf.format( i.getDtInicio() ));
		txtDtFim.setText( sdf.format( i.getDtFim() ));
		txtaDescricao.setText( i.getDescricao() );
		txtTema.setText( i.getTema() );
		txtValor.setText( Float.toString( i.getValor() ) );
		while( j < obras.size() ){
			//preencher JTable
		}
	}
	
	public Exposicao formToExposicao(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ExposicaoControl eControl = new ExposicaoControl();
		Exposicao e = new Exposicao();
		List<Obra> obras = new ArrayList<Obra>();
		try {
			e.setTitulo( txtTitulo.getText() );
			e.setDtInicio( sdf.parse( txtDtInicio.getText() ));
			e.setDtFim( sdf.parse( txtDtFim.getText() ));
			e.setDescricao( txtaDescricao.getText() );
			e.setTema( txtTema.getText() );
			e.setValor( Float.parseFloat( txtValor.getText() ));
			obras = eControl.getLista(); //obras recebe o conteudo da Jtable
			e.setObras(obras);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("Gravar".equals( cmd )){
			controle.adicionar( formToExposicao() );
			tabelaObras.invalidate();
			tabelaObras.revalidate();
		} else if("Pesquisar".equals( cmd )){
			Exposicao ex = controle.pesquisar( txtTitulo.getText() );
			ObraControl oControl = new ObraControl();
			List<Obra> obras = new ArrayList<Obra>();
			int i = 0;
			while( i < ex.getObras().size() ){
				Obra o = oControl.pesquisarPorId( ex.getObras().get( i ).getId() );
				obras.add( o );
				i++;
			}
			exposicaoToForm(ex, obras);
			tabelaObras.invalidate();
			tabelaObras.revalidate();
		} else if("Excluir".equals( cmd )){
			controle.remover( txtTitulo.getText() );
			controle.pesquisar( "" ); //atualizar JTable
			tabelaObras.invalidate();
			tabelaObras.revalidate();
		} else if("Adicionar".equals( cmd )){
			ObraControl oControl = new ObraControl();
			String obra = controle.pesquisarObra();
			Obra o = oControl.pesquisar(obra);
			controle.adicionaObraLista(o);
			tabelaObras.invalidate();
			tabelaObras.revalidate();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linha = tabelaObras.getSelectedRow();
		Obra o = controle.getLista().get( linha );
		System.out.println(" Linha selecionada " + linha);
	}
	
}
