package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.masp.control.IngressoControl;
import com.masp.entity.Exposicao;
import com.masp.entity.Ingresso;

public class ExposicaoForm implements ActionListener, ListSelectionListener{
	private JFrame janela = new JFrame();
	private JTextField txtId = new JTextField();
	private JTextField txtTitulo = new JTextField();
	private JTextField txtDtInicio = new JTextField();
	private JTextField txtDtFim = new JTextField();
	private JTextField txtTema = new JTextField();
	private JTextArea txtaDescricao = new JTextArea();
	private JTable tabelaObras;
	private ExposicaoControl controle;
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnGravar = new JButton("Gravar");
	
	public ExposicaoForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JScrollPane panTable = new JScrollPane();
		JPanel panFormulario = new JPanel( new GridLayout(5, 3) );
		JPanel panBotoes = new JPanel();
		
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
		panFormulario.add( panBotoes );
		panBotoes.add( btnAdicionar );
		panBotoes.add( btnPesquisar );
		panBotoes.add( btnExcluir );
		panFormulario.add( btnGravar );
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		btnExcluir.addActionListener( this );
		btnGravar.addActionListener( this );
		
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
	
	public void exposicaoToForm(Exposicao i){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtId.setText( Long.toString( i.getId() ) );
		txtTitulo.setText( sdf.format( i.getTitulo() ) );
		txtDtInicio.setText( sdf.format( i.getDtInicio() ));
		txtDtFim.setText( sdf.format( i.getDtFim() ));
		
	}
	
	public Exposicao formToExposicao(){
		return null;
		//pegar cada linha da tabela
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		controle = new ExposicaoControl();
		if("Adicionar".equals( cmd )){
			controle.adicionar( formToExposicao() );
			tabelaObras.invalidate();
			tabelaObras.revalidate();
		} else if("Pesquisar".equals( cmd )){
			
		} else if("Excluir".equals( cmd )){
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linha = tabelaObras.getSelectedRow();
		Exposicao ex = controle.getLista().get( linha );
		exposicaoToForm( ex );
		System.out.println(" Linha selecionada " + linha);
	}
	
}
