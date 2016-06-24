package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.masp.control.CategoriaControl;
import com.masp.control.MaterialControl;
import com.masp.entity.Material;

public class MaterialForm implements ActionListener{
	private JFrame janela = new JFrame();
	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private MaterialControl controle;
	private JComboBox<String> cbCategoria;
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	
	public MaterialForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(4, 3) );
		cbCategoria = new JComboBox<String>();
		janela.setContentPane( panPrincipal );
		panPrincipal.add(panForm, BorderLayout.CENTER);
		panForm.add( new JLabel("ID: ") );
		panForm.add( txtId );
		panForm.add( new JLabel() );
		panForm.add( new JLabel("Nome: ") );
		panForm.add( txtNome );
		panForm.add( btnPesquisar );
		panForm.add( new JLabel("Categoria: ") );
		panForm.add( cbCategoria );
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
	
	public void materialToForm(Material m) { 
		CategoriaControl cCont = new CategoriaControl();
		txtId.setText( Long.toString( m.getId() ) );
		txtNome.setText( m.getNome() );
		cbCategoria.setSelectedItem(cCont.pesquisarPorId(m.getCategoria()));
	}
	
	public Material formToMaterial() { 
		CategoriaControl cCont = new CategoriaControl();
		Material m = new Material();
		
		long idCategoria = cCont.pesquisarPorNome(cbCategoria.getSelectedItem().toString()).getId();
		
		try {
			m.setId( Long.parseLong( txtId.getText() ) );
			m.setNome( txtNome.getText() );				
			m.setCategoria( idCategoria );
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		controle = new MaterialControl();
		if("Gravar".equals( cmd )){
			controle.adicionar( formToMaterial() );
		} else if("Limpar".equals( cmd )){
			limpar();
		} else if("Pesquisar".equals( cmd )){
			List<Material> lista = controle.pesquisarPorNome( txtNome.getText() );
			if(lista.size() > 0){
				materialToForm(lista.get( 0 ));
			}
		}
	}
	
	private void limpar(){
		txtId.setText("");
		txtNome.setText("");
	}
}
