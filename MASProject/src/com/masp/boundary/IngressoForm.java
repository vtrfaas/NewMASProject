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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.masp.control.IngressoControl;
import com.masp.entity.Ingresso;

public class IngressoForm implements ActionListener, ListSelectionListener {

	private JFrame janela = new JFrame("VENDA INGRESSO");
	private JTextField txtId = new JTextField();
	private JTextField txtData = new JTextField();
	private JTextField txtValor = new JTextField();
	private JTextField txtQtde = new JTextField();
	private JComboBox<String> cbExposicao;
	private JComboBox<String> cbTipoIngresso;
	private JTable tabela;
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnExcluir = new JButton("Excluir");
	private IngressoControl controle;
//	private ExposicaoControl eControle = new ExposicaoControl();
	
	public IngressoForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JScrollPane panTable = new JScrollPane();
		JPanel panFormulario = new JPanel( new GridLayout(5, 3) );
		JPanel panBotoes = new JPanel();
		cbExposicao = new JComboBox<String>();
		cbTipoIngresso = new JComboBox<String>();
		cbTipoIngresso.addItem("Inteira");
		cbTipoIngresso.addItem("Meia");
		cbTipoIngresso.addItem("Especial");
		panFormulario.add( new JLabel("Id: ") );
		panFormulario.add( txtId );
		panFormulario.add( new JLabel("Data: ") );
		panFormulario.add( txtData );
		panFormulario.add( new JLabel("Exposição: ") );
		panFormulario.add( cbExposicao );
		panFormulario.add( new JLabel("Tipo de Ingresso: ") );
		panFormulario.add( cbTipoIngresso );
		panFormulario.add( panBotoes );
		panBotoes.add( btnAdicionar );
		panBotoes.add( btnPesquisar );
		panBotoes.add( btnExcluir );
		btnAdicionar.addActionListener( this );
		btnPesquisar.addActionListener( this );
		btnExcluir.addActionListener( this );
		
		panPrincipal.add(panFormulario, BorderLayout.NORTH);
		panPrincipal.add(panTable, BorderLayout.CENTER);
		
		tabela = new JTable( controle );
		tabela.getSelectionModel().addListSelectionListener( this );
		
		panTable.getViewport().add( tabela );
		
		janela.setContentPane( panPrincipal );
		
		janela.setSize(600, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
	}
	
	public void ingressoToForm(Ingresso i){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtId.setText( Long.toString( i.getId() ) );
		txtData.setText( sdf.format( i.getData() ) );
//		cbExposicao.setText( c.getDescricao() );
//		cbTipoIngresso.setSelectedIndex(anIndex);
		
	}
	
	public Ingresso formToIngresso(){
		return null;
		//pegar cada linha da tabela
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("Adicionar".equals( cmd )){
			
		} else if("Pesquisar".equals( cmd )){
			
		} else if("Excluir".equals( cmd )){
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
