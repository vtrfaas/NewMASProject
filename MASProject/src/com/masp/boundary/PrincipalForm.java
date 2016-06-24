package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
	private JButton btnExposicao = new JButton("Exposicao");
	private JButton btnMaterial = new JButton("Material");
	private PrincipalControl controle;
	
	public PrincipalForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(5, 3) );
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
		panForm.add( new JLabel() );
		panForm.add( new JLabel() );
		panForm.add( new JLabel() );
		panForm.add(btnExposicao);
		panForm.add( new JLabel() );
		panForm.add(btnMaterial);
		
		btnIngresso.addActionListener(this);
		btnAcervo.addActionListener(this);
		btnEmprestimo.addActionListener(this);
		btnArtista.addActionListener(this);
		btnSetor.addActionListener(this);
		btnCategoria.addActionListener(this);
		btnExposicao.addActionListener(this);
		btnMaterial.addActionListener(this);
		
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
		} else if("Ingresso".equals( cmd )){
			IngressoForm iForm = new IngressoForm();
		} else if("Acervo".equals( cmd )){
			ObraForm aForm = new ObraForm();
		} else if("Exposicao".equals( cmd )){
			ExposicaoForm eForm = new ExposicaoForm();
		} else if("Artista".equals( cmd )){
			ArtistaForm artForm = new ArtistaForm(); 
		} else if("Emprestimo".equals( cmd )){
			EmprestimoForm eForm = new EmprestimoForm();
		} else if("Categoria".equals( cmd )){
			CategoriaForm cForm = new CategoriaForm();
		} else if("Material".equals( cmd )){
			MaterialForm mForm = new MaterialForm();
		}
	}
	
	public static void main(String[] args) {
		new PrincipalForm();
	}	
}
