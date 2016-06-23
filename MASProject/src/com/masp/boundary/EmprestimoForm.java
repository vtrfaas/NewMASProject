package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.masp.control.ExposicaoControl;
import com.masp.entity.Exposicao;
import com.masp.entity.Obra;

public class EmprestimoForm {
	private JFrame janela = new JFrame("EXPOSIÇÃO");
	private JTextField txtId = new JTextField();
	private JTextField txtTitulo = new JTextField();
	private JTextField txtDtInicio = new JTextField();
	private JTextField txtDtFinal = new JTextField();
	private JTextField txtTema = new JTextField();
	private JTextField txtDescricao = new JTextField();
	private JTextField txtMuseu = new JTextField();
	private JTextField txtResponsavel = new JTextField();
	private JTable tabela;
	private Obra[] obra;
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnGravar = new JButton("Gravar"); 
	private ExposicaoControl controle;
	
	public EmprestimoForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(9, 3) );
		JScrollPane panTable = new JScrollPane();
		controle = new ExposicaoControl();
		tabela = new JTable( controle );
		panTable.add(tabela);
		janela.setContentPane(panPrincipal);
		panPrincipal.add(panForm, BorderLayout.NORTH);
		panForm.add( new JLabel("ID: ") );
		panForm.add( txtId );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Título: ") );
		panForm.add( txtTitulo );
		panForm.add( btnPesquisar );
		panForm.add( new JLabel("Data Inicio: ") );
		panForm.add( txtDtInicio );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Data Final: ") );
		panForm.add( txtDtFinal );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Tema: ") );
		panForm.add( txtTema );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Descrição: ") );
		panForm.add( txtDescricao );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Museu: ") );
		panForm.add( txtMuseu );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Responsável: ") );
		panForm.add( txtResponsavel );
		panForm.add( new JLabel() );
		
		janela.setSize(600, 300);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void emprestimoToForm(Exposicao e){
		
	}
	
	public Exposicao formToEmprestimo(){
		return null;
	}
}
