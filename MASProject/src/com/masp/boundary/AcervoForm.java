package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AcervoForm implements ActionListener{

	private JFrame janela;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtAno;
	private JComboBox<String> cbMaterial;
	private JComboBox<String> cbCategoria;
	private JComboBox<String> cbSetor;
	private JComboBox<String> cbStatus;
	private JButton btnPesquisarImagem;
	private JButton btnExcluirImagem;
	private JButton btnPesquisaArtista;
	private JButton btnNovoArtista;
	private JButton btnEditarArtista;
	private JButton btnNovaCategoria;
	private JButton btnEditarCategoria;
	private JButton btnNovoMaterial;
	private JButton btnNovoSetor;
	private JButton btnEditarSetor;
	private JButton btnGravar;
	
	public AcervoForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(10, 3) );
		janela = new JFrame("ACERVO");
		janela.setContentPane(panPrincipal);
		panPrincipal.add(panForm, BorderLayout.NORTH);
		panForm.add( new JLabel("ID: ") );
		txtId = new JTextField();
		panForm.add( txtId );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Nome da Obra: ") );
		txtNome = new JTextField();
		panForm.add( txtNome );
		panForm.add( new JLabel("Ano da Obra: ") );
		txtAno = new JTextField();
		panForm.add( txtAno );
		btnPesquisaArtista = new JButton("Pesquisar Artista");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
