package com.masp.control;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.masp.dao.ArtistaDAO;
import com.masp.dao.ArtistaDAOImpl;
import com.masp.dao.CategoriaDAO;
import com.masp.dao.CategoriaDAOImpl;
import com.masp.dao.MaterialDAO;
import com.masp.dao.MaterialDAOImpl;
import com.masp.dao.ObraDAOImpl;
import com.masp.dao.SetorDAO;
import com.masp.dao.SetorDAOImpl;
import com.masp.entity.Artista;
import com.masp.entity.Categoria;
import com.masp.entity.Material;
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
		preencherCategoria();
		preencherMaterial();
		preencherSetor();
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
	
	public void preencherArtista(String nome){
		ArtistaDAO aDAO = new ArtistaDAOImpl();
		List<Artista> artistas = new ArrayList<Artista>();
		
		artistas = aDAO.pesquisar(nome);
		
		for (int i = 0; i < artistas.size(); i++) {
			cbArtista.addItem(artistas.get(i).getNome());
		}
			
	}
	
	public void preencherCategoria(){
		CategoriaDAO cDAO = new CategoriaDAOImpl();
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		categorias = cDAO.pesquisarTudo();
		
		for (int i = 0; i < categorias.size(); i++) {
			cbCategoria.addItem(categorias.get(i).getNome());
		}
	}
	
	public void preencherMaterial(){
		MaterialDAO mDAO = new MaterialDAOImpl();
		List<Material> materiais = new ArrayList<Material>();
		
		materiais = mDAO.pesquisarTudo();
		
		for (int i = 0; i < materiais.size(); i++) {
			cbMaterial.addItem(materiais.get(i).getNome());
		}
	}
	
	public void preencherSetor(){
		SetorDAO sDAO = new SetorDAOImpl();
		List<Setor> setores = new ArrayList<Setor>();
		
		setores = sDAO.pesquisarTudo();
		
		for (int i = 0; i < setores.size(); i++) {
			cbSetor.addItem(setores.get(i).getNome());
		}
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
	
}
