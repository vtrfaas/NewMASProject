package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

import com.masp.control.CategoriaControl;
import com.masp.control.ExposicaoControl;
import com.masp.control.IngressoControl;
import com.masp.entity.Categoria;
import com.masp.entity.Exposicao;
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
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	private ExposicaoControl eControle = new ExposicaoControl();
	private List<Exposicao> lista = new ArrayList<Exposicao>();
	
	public IngressoForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JScrollPane panTable = new JScrollPane();
		JPanel panFormulario = new JPanel( new GridLayout(8, 3) );
		JPanel panBotoes = new JPanel();
		cbExposicao = new JComboBox<String>();
		cbTipoIngresso = new JComboBox<String>();
		preencherComboExposicao();
		cbTipoIngresso.addItem("Inteira");
		cbTipoIngresso.addItem("Meia");
		cbTipoIngresso.addItem("Especial");
		panFormulario.add( new JLabel("Id: ") );
		txtId.setEditable(false);
		panFormulario.add( txtId );
		panFormulario.add( new JLabel() );
		panFormulario.add( new JLabel("Data: ") );
		panFormulario.add( txtData );
		panFormulario.add( new JLabel() );
		//Capturar a data do sistema e na txtData
		Date data= new Date();
		long time = System.currentTimeMillis();
		System.out.println(""+time);
		
		panFormulario.add( new JLabel("Exposição: ") );
		panFormulario.add( cbExposicao );
		panFormulario.add( new JLabel() );
		panFormulario.add( new JLabel("Tipo de Ingresso: ") );
		panFormulario.add( cbTipoIngresso );
		panFormulario.add( new JLabel() );
		panFormulario.add( new JLabel("Quantidade: ") );
		panFormulario.add( txtQtde );
		panFormulario.add( new JLabel() );
		txtValor.setEditable(false);
		panFormulario.add( new JLabel("Valor: ") );
		panFormulario.add( txtValor );
		panFormulario.add( new JLabel() );
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
		
		janela.setSize(850, 500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
	}
	
	public void ingressoToForm(Ingresso i){
		ExposicaoControl eControl = new ExposicaoControl();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtId.setText( Long.toString( i.getId() ) );
		txtData.setText( sdf.format( i.getData() ) );
		cbExposicao.setSelectedItem( eControl.pesquisarId(i.getExposicao()).getTitulo());
		cbTipoIngresso.setSelectedItem( i.getTipoIngresso() );
		
	}
	
	private void preencherComboExposicao(){
		ExposicaoControl eCont = new ExposicaoControl();
		lista = eCont.pesquisarTudo();
		if( lista.size() > 0 ){
			for(int i = 0; i < lista.size(); i++){
				cbExposicao.addItem(lista.get(i).getTitulo());
			}
		}
	}
	
	private long escolherExposicao() {
		long id = 0;
		for(int i = 0; i < lista.size(); i++){
			if( lista.get(i).getTitulo().equals( cbExposicao.getSelectedItem().toString() )){
				id = lista.get(i).getId();
				i = lista.size();
			}
		}
		return id;
	}

	
	public Ingresso formToIngresso(){
		Ingresso ing = new Ingresso();
		try {
			ing.setData( sdf.parse( txtData.getText() ) );
			long id = escolherExposicao();
			ing.setExposicao( id );
			ing.setTipoIngresso( cbTipoIngresso.getSelectedItem().toString() );
			ing.setQtde( Integer.parseInt( txtQtde.getText() ) );
			ing.setValor( Float.parseFloat( txtValor.getText() ) );
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ing;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		controle = new IngressoControl();
		if("Adicionar".equals( cmd )){
			
			controle.adicionar( formToIngresso() );
			tabela.invalidate();
			tabela.revalidate();
		} else if("Pesquisar".equals( cmd )){
			
		} else if("Excluir".equals( cmd )){
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linha = tabela.getSelectedRow();
		Ingresso i = controle.getLista().get( linha );
		ingressoToForm( i );
		System.out.println(" Linha selecionada " + linha);
	}
}
