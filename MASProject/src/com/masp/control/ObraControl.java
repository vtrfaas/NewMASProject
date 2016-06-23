package com.masp.control;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.masp.dao.ArtistaDAOImpl;
import com.masp.dao.CategoriaDAOImpl;
import com.masp.dao.ObraDAOImpl;
import com.masp.dao.SetorDAOImpl;
import com.masp.entity.Artista;
import com.masp.entity.Categoria;
import com.masp.entity.Obra;
import com.masp.entity.Setor;

public class ObraControl {
	private ObraDAOImpl oDAO = new ObraDAOImpl();
	private JComboBox<String> cbArtista;
	private JComboBox<String> cbCategoria;
	private JComboBox<String> cbMaterial;
	private JComboBox<String> cbSetor;
	
	public ObraControl(JComboBox<String> cbArtista,
					   JComboBox<String> cbCategoria,
					   JComboBox<String> cbMaterial,
					   JComboBox<String> cbSetor){
		this.cbArtista = cbArtista;
		this.cbCategoria = cbCategoria;
		this.cbMaterial = cbMaterial;
		this.cbSetor = cbSetor;
	}
	
	public ObraControl(){}

	public void adicionar(Obra obra) {
		oDAO.adicionar(obra);
	}

	public void atualizar(Obra obra) {
		oDAO.atualizar(obra);
	}

	public void excluir(Obra obra) {
		oDAO.remover(obra);
	}

	public String adicionarImagem() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(
				"Arquivos de imagem (jpg, png, gif)", "jpg", "png","gif");
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File(diretorioBase);

		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		String caminhoArquivo = "";

		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			
		}
		return caminhoArquivo;
		
	}
	
	public void preencherArtista(String nome){
		ArtistaDAOImpl aDAO = new ArtistaDAOImpl();
		List<Artista> artistas = new ArrayList<Artista>();
		artistas = aDAO.pesquisar(nome);
		for (int i = 0; i < artistas.size(); i++) {
			cbArtista.addItem(artistas.get(i).getNome());
		}
			
	}
	
	public void preencherCategoria(){
		CategoriaDAOImpl cDAO = new CategoriaDAOImpl();
		List<Categoria> categorias = new ArrayList<Categoria>();
//		TODO Criar um pesquisar tudo 
//		categorias = cDAO.pesquisar(nome);
//		for (int i = 0; i < categorias.size(); i++) {
//			
//			cbCategoria.addItem(categorias.get(i).getNome());
//		}
	}
	
	public void preencherMaterial(){
//		TODO Aguardando criação do MaterialDAO
	}
	
	public void preencherSetor(){
		SetorDAOImpl sDAO = new SetorDAOImpl();
		List<Setor> setores = new ArrayList<Setor>();
//	TODO criar pesquisar tudo
	}
	
}
