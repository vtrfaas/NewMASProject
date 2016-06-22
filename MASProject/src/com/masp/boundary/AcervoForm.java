package com.masp.boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.masp.entity.Acervo;

public class AcervoForm implements ActionListener {

	private JFrame janela;

	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtAno = new JTextField();
	private JTextField txtDescricao = new JTextField();
	private JTextField txtValor = new JTextField();

	private JComboBox<String> cbMaterial = new JComboBox<>();
	private JComboBox<String> cbCategoria = new JComboBox<>();
	private JComboBox<String> cbSetor = new JComboBox<>();
	private JComboBox<String> cbStatus = new JComboBox<>();
	private JComboBox<String> cbArtista = new JComboBox<>();

	private JButton btnPesquisarImagem = new JButton("LUPA");
	private JButton btnExcluirImagem = new JButton("XIS");
	private JButton btnNovoArtista = new JButton("Novo");
	private JButton btnNovaCategoria = new JButton("Novo");
	private JButton btnNovoMaterial = new JButton("Novo");
	private JButton btnNovoSetor = new JButton("Novo");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnAtualizar = new JButton("Atualizar");
	private JButton btnExcluir = new JButton("Excluir");

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private JLabel lblImg;

	public AcervoForm() {
		JPanel panPrincipal = new JPanel(new BorderLayout());
		JPanel panForm = new JPanel(new GridLayout(10, 3));
		JPanel panImg = new JPanel(new BorderLayout());
		JPanel panBtn = new JPanel(new GridLayout(1, 3));
		JPanel panBtnImg = new JPanel(new GridLayout(1, 2));
		janela = new JFrame("ACERVO");

		janela.setContentPane(panPrincipal);

		cbArtista.setEditable(true);

		panPrincipal.add(panForm, BorderLayout.WEST);
		panPrincipal.add(panImg, BorderLayout.EAST);
		panPrincipal.add(panBtn, BorderLayout.SOUTH);

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

		panForm.add(new JLabel("Descrição: "));
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

		panImg.add(lblImg = new JLabel("IBAGEM AQUI"), BorderLayout.CENTER);// adicionar
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

		// btnPesquisarImagem.addActionListener(this);
		// btnExcluirImagem.addActionListener(this);
		// btnNovoArtista.addActionListener(this);
		// btnNovaCategoria.addActionListener(this);
		// btnNovoMaterial.addActionListener(this);
		// btnNovoSetor.addActionListener(this);
		btnGravar.addActionListener(this);
		btnAtualizar.addActionListener(this);
		btnExcluir.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Gravar".equals(cmd)) {

		} else if ("Atualizar".equals(cmd)) {

		} else if ("Excluir".equals(cmd)) {

		}
	}

	public void acervoToForm(Acervo a) {
		// txtAnoNasc.setText( sdf.format( a.getAnoNasc() ) );
		txtId.setText(Integer.toString(a.getId()));
		txtNome.setText(a.getNomeObra());
		txtAno.setText(sdf.format(a.getDtComposicao()));
		txtDescricao.setText(a.getDescricao());
		txtValor.setText(Float.toString(a.getValor()));
		// TODO chama metodos pesquisar pelo id e retorna para combos
	}

	public Acervo formToAcervo() {
		// a.setAnoNasc( sdf.parse( txtAnoNasc.getText() ) );
		Acervo a = new Acervo();
//		a.setIdArtista(idArtista);
//		a.setIdCategoria(idCategoria);
//		a.setIdMaterial(idMaterial);
//		a.setNomeObra(nomeObra);
//		a.setValor(valor);
//		a.setDtComposicao(dtComposicao);
//		a.setDescricao(descricao);
//		a.setCaminhoImagem(caminhoImagem);
//		a.setId(id);
		return null;
	}

	public static void main(String[] args) {
		AcervoForm aF = new AcervoForm();
	}
}