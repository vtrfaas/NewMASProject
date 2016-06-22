package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.masp.control.ArtistaControl;
import com.masp.entity.Artista;

public class ArtistaForm implements ActionListener {

	private JFrame janela = new JFrame("ARTISTAS");
	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtLocalNasc = new JTextField();
	private JTextField txtAnoNasc = new JTextField();
	private JTextField txtAnoMorte = new JTextField();
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnExcluir = new JButton("Excluir");
	private ArtistaControl controle;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTable tabela;
	
	public ArtistaForm(){
		//Adicionar uma tabela ao form
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(6, 3) );
		janela.setContentPane(panPrincipal);
		panPrincipal.add( panForm, BorderLayout.CENTER );
		panForm.add( new JLabel("ID: ") );
		panForm.add( txtId );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Nome: ") );
		panForm.add( txtNome );
		panForm.add( btnPesquisar );
		panForm.add( new JLabel("Local Nascimento: ") );
		panForm.add( txtLocalNasc );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Ano Nascimento: ") );
		panForm.add( txtAnoNasc );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Ano Morte: ") );
		panForm.add( txtAnoMorte );
		panForm.add( new JLabel() );
		panForm.add( btnExcluir );
		panForm.add( btnLimpar );
		panForm.add( btnGravar );
		
		btnPesquisar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnGravar.addActionListener(this);
		btnExcluir.addActionListener(this);
		
		janela.setSize(500, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
	}
	
	public void artistaToForm(Artista a) { 
		txtId.setText( Long.toString( a.getId() ) );
		txtNome.setText( a.getNome() );
		txtLocalNasc.setText( a.getLocalNasc() );
		txtAnoNasc.setText( sdf.format( a.getAnoNasc() ) );
		txtAnoMorte.setText( sdf.format( a.getAnoMorte() ) );
	}
	
	public Artista formToArtista() { 
		Artista a = new Artista();
		try {
			a.setId( Long.parseLong( txtId.getText() ) );
			a.setNome( txtNome.getText() );				
			a.setLocalNasc( txtLocalNasc.getText() );
			a.setAnoNasc( sdf.parse( txtAnoNasc.getText() ) );
			a.setAnoMorte( sdf.parse( txtAnoMorte.getText() ) );
		} catch (ParseException e ){
			e.printStackTrace();
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		return a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		controle = new ArtistaControl();
		if("Pesquisar".equals( cmd )){
			controle = new ArtistaControl();
			List<Artista> a = controle.pesquisar( txtNome.getText() );
			artistaToForm(a.get(0));
		} else if("Limpar".equals( cmd )){
			limparCampos();
		} else if("Gravar".equals( cmd )){
			controle = new ArtistaControl();
			controle.adicionar( formToArtista() );
		} else if("Excluir".equals( cmd )){
			//todo
		}
	}
	
	private void limparCampos(){
		txtId.setText("");
		txtNome.setText("");
		txtLocalNasc.setText("");
		txtAnoNasc.setText("");
		txtAnoMorte.setText("");
	}
}
