package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.masp.control.SetorControl;
import com.masp.entity.Categoria;
import com.masp.entity.Setor;

public class SetorForm implements ActionListener {
	
	private JFrame janela = new JFrame("SETOR");
	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtAndar = new JTextField();
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private SetorControl controle = new SetorControl();
	
	public SetorForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(4, 3) );
		janela.setContentPane( panPrincipal );
		panPrincipal.add(panForm, BorderLayout.CENTER);
		panForm.add( new JLabel("ID: ") );
		panForm.add( txtId );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Nome: ") );
		panForm.add( txtNome );
		panForm.add( btnPesquisar );
		panForm.add( new JLabel("Andar: ") );
		panForm.add( txtAndar );
		panForm.add( new JLabel() );
		panForm.add( btnLimpar );
		panForm.add( new JLabel() );
		panForm.add( btnGravar );
		
		btnGravar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		
		janela.setSize(500, 200);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		
	}
	
	public void setorToForm(Setor s) { 
		txtId.setText( Long.toString( s.getId() ) );
		txtNome.setText( s.getNome() );
		txtAndar.setText( s.getAndar() );
	}
	
	public Setor formToCategoria() { 
		Setor s = new Setor();
		try {
			s.setId( Long.parseLong( txtId.getText() ) );
			s.setNome( txtNome.getText() );				
			s.setAndar( txtAndar.getText() );
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if("Gravar".equals( cmd )){
			
		} else if("Limpar".equals( cmd )){
			limpar();
		}
	}
	
	private void limpar(){
		txtId.setText("");
		txtNome.setText("");
		txtAndar.setText("");
	}
	
}
