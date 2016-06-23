package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.masp.control.CategoriaControl;
import com.masp.control.MaterialControl;
import com.masp.control.ObraControl;
import com.masp.control.SetorControl;
import com.masp.entity.Obra;

public class ObraForm implements ActionListener {

	private JFrame janela;

	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtAno = new JTextField();
	private JTextField txtDescricao = new JTextField();
	private JTextField txtValor = new JTextField();

	private JComboBox<String> cbMaterial = new JComboBox<String>();
	private JComboBox<String> cbCategoria = new JComboBox<String>();
	private JComboBox<String> cbSetor = new JComboBox<String>();
	private JComboBox<String> cbStatus = new JComboBox<String>();
	private JComboBox<String> cbArtista = new JComboBox<String>();

	private JButton btnPesquisarImagem = new JButton("+");
	private JButton btnExcluirImagem = new JButton("X");
	private JButton btnNovoArtista = new JButton("Novo Artista");
	private JButton btnNovaCategoria = new JButton("Nova Categoria");
	private JButton btnNovoMaterial = new JButton("Novo Material");
	private JButton btnNovoSetor = new JButton("Novo Setor");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnAtualizar = new JButton("Atualizar");
	private JButton btnExcluir = new JButton("Excluir");

	private JTabbedPane tabDono = new JTabbedPane(JTabbedPane.TOP);

	private JPanel panPrincipal;
	private JPanel panForm;
	private JPanel panImg;
	private JPanel panBtn;
	private JPanel panBtnImg;
	// private JPanel panProp;
	// private JPanel panEmpr;
	// private JPanel panTab;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private JLabel lblImg;
	
	private static String caminhoImagem;

	public ObraForm() {
		panPrincipal = new JPanel(new BorderLayout());
		panForm = new JPanel(new GridLayout(10, 3));
		panImg = new JPanel(new BorderLayout());
		panBtn = new JPanel(new GridLayout(1, 3));
		panBtnImg = new JPanel(new GridLayout(1, 2));

		// tabDono.addTab("ProprietÃ¡rio", null, panProp, null);
		// tabDono.addTab("EmprÃ©stimo", null, panEmpr, null);
		// panTab.add(tabDono, BorderLayout.CENTER);
		// panTab.add(panBtn, BorderLayout.SOUTH);

		janela = new JFrame("ACERVO");

		janela.setContentPane(panPrincipal);

		cbArtista.setEditable(true);
		
		panPrincipal.add(panForm, BorderLayout.WEST);
		panPrincipal.add(panImg, BorderLayout.EAST);
		panPrincipal.add(panBtn, BorderLayout.SOUTH);
		// panPrincipal.add(panTab, BorderLayout.SOUTH);

		panForm.add(new JLabel("ID: "));
		panForm.add(txtId);
		panForm.add(new JLabel());

		panForm.add(new JLabel("Nome da Obra: "));
		panForm.add(txtNome);
		panForm.add(new JLabel());

		panForm.add(new JLabel("Artista: "));
		panForm.add(cbArtista);
		panForm.add(btnNovoArtista);

		panForm.add(new JLabel("Ano da Obra: "));
		panForm.add(txtAno);
		panForm.add(new JLabel());

		panForm.add(new JLabel("Categoria: "));
		panForm.add(cbCategoria);
		panForm.add(btnNovaCategoria);

		panForm.add(new JLabel("Material: "));
		panForm.add(cbMaterial);
		panForm.add(btnNovoMaterial);

		panForm.add(new JLabel("Descricao: "));
		panForm.add(txtDescricao);
		panForm.add(new JLabel());

		panForm.add(new JLabel("Setor: "));
		panForm.add(cbSetor);
		panForm.add(btnNovoSetor);

		panForm.add(new JLabel("Status: "));
		panForm.add(cbStatus);
		panForm.add(new JLabel());

		panForm.add(new JLabel("Valor: "));
		panForm.add(txtValor);
		panForm.add(new JLabel());
		
		txtId.setEditable(false);
		
		cbStatus.addItem("Emprestado");
		cbStatus.addItem("Em Manutenção");
		cbStatus.addItem("Em Exposição");
		
		panImg.add(lblImg = new JLabel(), BorderLayout.CENTER);// adicionar
																			// icone
																			// inicial
																			// aqui
		panImg.add(panBtnImg, BorderLayout.SOUTH);
		panBtnImg.add(btnPesquisarImagem);
		panBtnImg.add(btnExcluirImagem);

		panBtn.add(btnGravar);
		panBtn.add(btnAtualizar);
		panBtn.add(btnExcluir);

		janela.setSize(570, 350);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		
		ObraControl oCont = new ObraControl(cbArtista, cbCategoria, cbMaterial, cbSetor);

		btnPesquisarImagem.addActionListener(this);
		btnExcluirImagem.addActionListener(this);
		btnNovoArtista.addActionListener(this);
		btnNovaCategoria.addActionListener(this);
		btnNovoMaterial.addActionListener(this);
		btnNovoSetor.addActionListener(this);
		btnGravar.addActionListener(this);
		btnAtualizar.addActionListener(this);
		btnExcluir.addActionListener(this);
		cbArtista.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		ObraControl oCont = new ObraControl();
		
		if ("Gravar".equals(cmd)) {
			
			oCont.adicionar(formToObra());
			
		} else if ("Atualizar".equals(cmd)) {
			
			oCont.atualizar(formToObra());
			
		} else if ("Excluir".equals(cmd)) { 
			
			oCont.excluir(formToObra());
			
		} else if ("Novo Setor".equals(cmd)) {
			SetorForm sForm = new SetorForm();

		} else if ("Nova Categoria".equals(cmd)) {
			CategoriaForm cForm = new CategoriaForm();

		} else if ("Novo Material".equals(cmd)) {
			MaterialForm mForm = new MaterialForm();

		} else if ("Novo Artista".equals(cmd)) {
			ArtistaForm aForm = new ArtistaForm();

		} else if (e.getSource().equals(btnPesquisarImagem)) {
			
			insereImagem();
			

		} else if (e.getSource().equals(btnExcluirImagem)) {

		}else if(e.getSource().equals(cbArtista)){
			oCont.preencherArtista(cbArtista.getEditor().getItem().toString());
		}
	}

	private void insereImagem() {
		ObraControl oCont = new ObraControl();
		caminhoImagem = oCont.adicionarImagem();
		ImageIcon img = new ImageIcon(caminhoImagem);
		Image newImg = img.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_DEFAULT);
		lblImg.setIcon(new ImageIcon(newImg));
		
	}

	public void obraToForm(Obra o) {
		MaterialControl mCont = new MaterialControl();
		CategoriaControl cCont = new CategoriaControl();
		txtId.setText(Long.toString(o.getId()));
		txtNome.setText(o.getNomeObra());
		txtAno.setText(sdf.format(o.getDtComposicao()));
		txtDescricao.setText(o.getDescricao());
		txtValor.setText(Float.toString(o.getValor()));
//		TODO cbArtista.setSelectedItem(o.getIdArtista());
		cbMaterial.setSelectedItem(mCont.pesquisarSelecionado(o.getIdMaterial()));
		cbStatus.setSelectedItem(o.getStatus()); //Esta linha pode repetir itens na Combo
		cbCategoria.setSelectedItem(cCont.pesquisarSelecionado(o.getIdCategoria()));
	
	}

	public Obra formToObra() {
		CategoriaControl cCont = new CategoriaControl();
		SetorControl sCont = new SetorControl();
		Obra o = new Obra();

		Long idCategoria = cCont.pesquisar(cbCategoria.getSelectedItem().toString()).getId();
		Long idSetor = sCont.pesquisar(cbSetor.getSelectedItem().toString()).get(0).getId();
		 o.setId(Long.parseLong(txtId.getText()));
		 o.setIdArtista(Long.parseLong(txtId.getText()));
		 o.setIdCategoria(Long.parseLong(idCategoria.toString()));
		 o.setIdSetor(Long.parseLong(idSetor.toString()));
         //		TODO  o.setIdMaterial(idMaterial); 
		 o.setNomeObra(txtNome.getText());
		 o.setValor(Float.parseFloat(txtValor.getText()));
		 o.setDescricao(txtDescricao.getText());
		 o.setCaminhoImagem(caminhoImagem);
		 
		 try {
			o.setDtComposicao(sdf.parse(txtAno.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 o.setStatus(cbStatus.getSelectedItem().toString());
		 //TODO Radio button no item abaixo
		 o.setProprietario(true);
		return o;
	}

	public static void main(String[] args) {
		ObraForm o = new ObraForm();
	}
}