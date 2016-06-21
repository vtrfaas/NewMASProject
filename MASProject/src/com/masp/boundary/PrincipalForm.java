package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.masp.control.PrincipalControl;

public class PrincipalForm implements ActionListener {

	private JFrame janela = new JFrame("MENU PRINCIPAL");
	private JButton btnSetor = new JButton("Setor");
	private JButton btnAcervo = new JButton("Acervo");
	private JButton btnCategoria = new JButton("Categoria");
	private JButton btnArtista = new JButton("Artista");
	private JButton btnEmprestimo = new JButton("Emprestimo");
	private JButton btnIngresso = new JButton("Ingresso");
	private PrincipalControl controle;
	
	public PrincipalForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(3, 3) );
		JPanel panScreen = new JPanel();
		janela.setContentPane(panPrincipal);
		panPrincipal.add(panForm, BorderLayout.CENTER);
		panForm.add(btnIngresso);
		panForm.add(btnAcervo);
		panForm.add(btnEmprestimo);
		panForm.add( new JLabel() );
		panForm.add( new JLabel() );
		panForm.add( new JLabel() );
		panForm.add(btnArtista);
		panForm.add(btnSetor);
		panForm.add(btnCategoria);
		
		btnIngresso.addActionListener(this);
		btnAcervo.addActionListener(this);
		btnEmprestimo.addActionListener(this);
		btnArtista.addActionListener(this);
		btnSetor.addActionListener(this);
		btnCategoria.addActionListener(this);
		
//		int inset = 50;
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        janela.setBounds(inset, inset,
//                  screenSize.width  - inset*2,
//                  screenSize.height - inset*2);
		janela.setSize(400, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("Setor".equals( cmd )){
			SetorForm sForm = new SetorForm();
		}
	}
	
	public static void main(String[] args) {
		new PrincipalForm();
	}	
}