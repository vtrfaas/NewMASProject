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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.masp.control.CategoriaControl;
import com.masp.control.MaterialControl;
import com.masp.entity.Artista;
import com.masp.entity.Categoria;
import com.masp.entity.Material;

public class MaterialForm implements ActionListener{
	private JFrame janela = new JFrame("MATERIAL");
	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private MaterialControl controle;
	private JComboBox<String> cbCategoria;
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private static boolean isPressed = false;
	private List<Categoria> lista;
	
	public MaterialForm(){
		JPanel panPrincipal = new JPanel( new BorderLayout() );
		JPanel panForm = new JPanel( new GridLayout(4, 3) );
		cbCategoria = new JComboBox<String>();
		preencherComboCategoria();
		janela.setContentPane( panPrincipal );
		panPrincipal.add(panForm, BorderLayout.CENTER);
		panForm.add( new JLabel("ID: ") );
		txtId.setEditable(false);
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
	
	private void preencherComboCategoria(){
		CategoriaControl cCont = new CategoriaControl();
		lista = cCont.pesquisarTudo();
		if( lista.size() > 0 ){
			for(int i = 0; i < lista.size(); i++){
				cbCategoria.addItem( lista.get( i ).getNome() );
			}
		}
	}
	
	public void materialToForm(Material m) { 
		CategoriaControl cCont = new CategoriaControl();
		txtId.setText( Long.toString( m.getId() ) );
		txtNome.setText( m.getNome() );
		cbCategoria.setSelectedItem(cCont.pesquisarPorId(m.getCategoria()).getNome());
	}
	
	public Material formToMaterial() { 
		Material m = new Material();
		long idCategoria = escolherMaterial();
		
		try {
			m.setNome( txtNome.getText() );				
			m.setCategoria( idCategoria );
		} catch (NumberFormatException e ){
			e.printStackTrace();
		}
		return m;
	}

	private long escolherMaterial() {
		long id = 0;
		for(int i = 0; i < lista.size(); i++){
			if( lista.get(i).getNome().equals( cbCategoria.getSelectedItem().toString() )){
				id = lista.get(i).getId();
				i = lista.size();
			}
		}
		return id;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		controle = new MaterialControl();
		if("Gravar".equals( cmd )){
			if(isPressed){
				Material newM = formToMaterial();
				newM.setId( Long.parseLong( txtId.getText() ));
				controle.atualizar(newM);
				isPressed = false;
				JOptionPane.showMessageDialog(janela, "Registro Atualizado com Sucesso");
				limparCampos();
			} else {
				controle.adicionar( formToMaterial() );
				JOptionPane.showMessageDialog(janela, "Registro Adicionado com Sucesso");
				limparCampos();
			}
		} else if("Limpar".equals( cmd )){
			limparCampos();
			isPressed = false;
		} else if("Pesquisar".equals( cmd )){
			List<Material> lista = controle.pesquisarPorNome( txtNome.getText() );
			if(lista.size() > 0){
				isPressed = true;
				materialToForm(lista.get( 0 ));
			}
		} else if("Excluir".equals( cmd )){
			if( txtNome.getText() != null | txtNome.getText() != ""){
				controle.remover( txtNome.getText() );
				JOptionPane.showMessageDialog(janela, "Registro Excluido com Sucesso");
			}
		}
	}
	
	private void limparCampos(){
		txtId.setText("");
		txtNome.setText("");
	}
}
