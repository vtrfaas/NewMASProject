package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.masp.control.CategoriaControl;
import com.masp.entity.Artista;
import com.masp.entity.Categoria;

public class CategoriaForm implements ActionListener {

	private JFrame janela = new JFrame("CADASTRO DE CATEGORIA");
	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextArea txtADescricao = new JTextArea();
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private CategoriaControl controle;
	
	public CategoriaForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(4, 3) );
		janela.setContentPane(panPrincipal);
		panPrincipal.add(panForm, BorderLayout.CENTER);
		panForm.add( new JLabel("ID: ") );
		panForm.add( txtId );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Nome: ") );
		panForm.add( txtNome );
		panForm.add( btnPesquisar );
		panForm.add( new JLabel("Descri��o: ") );
		panForm.add(txtADescricao);
		panForm.add( new JLabel() );
		panForm.add( btnLimpar );
		panForm.add( new JLabel() );
		panForm.add( btnGravar );
		
		btnPesquisar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnGravar.addActionListener(this);
		
		janela.setSize(400, 300);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	public void categoriaToForm(Categoria c) { 
		txtId.setText( Long.toString( c.getId() ) );
		txtNome.setText( c.getNome() );
		txtADescricao.setText( c.getDescricao() );
	}
	
	public Categoria formToCategoria() { 
		Categoria c = new Categoria();
		try {
			c.setId( Long.parseLong( txtId.getText() ) );
			c.setNome( txtNome.getText() );				
			c.setDescricao( txtADescricao.getText() );
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("Pesquisar".equals( cmd )){
			controle = new CategoriaControl();
			Categoria c = controle.pesquisar( txtNome.getText() );
			categoriaToForm(c);
		} else if("Limpar".equals( cmd )){
			limparCampos();
		} else if("Gravar".equals( cmd )){
			controle = new CategoriaControl();
			controle.adicionar( formToCategoria() );
		}
	}
	
	private void limparCampos(){
		txtId.setText("");
		txtNome.setText("");
		txtADescricao.setText("");
	}

}
