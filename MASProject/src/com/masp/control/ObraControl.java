package com.masp.control;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.masp.dao.ArtistaDAOImpl;
import com.masp.dao.CategoriaDAOImpl;
import com.masp.dao.MaterialDAOImpl;
import com.masp.dao.ObraDAOImpl;
import com.masp.dao.SetorDAOImpl;
import com.masp.entity.Artista;
import com.masp.entity.Obra;

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
		List<String> categorias = new ArrayList<String>();
		
		categorias = cDAO.pesquisarTudo();
		
		for (int i = 0; i < categorias.size(); i++) {
			cbCategoria.addItem(categorias.get(i));
		}
	}
	
	public void preencherMaterial(){
		MaterialDAOImpl mDAO = new MaterialDAOImpl();
		List<String> materiais = new ArrayList<String>();
		
		materiais = mDAO.pesquisarTudo();
		
		for (int i = 0; i < materiais.size(); i++) {
			cbMaterial.addItem(materiais.get(i));
		}
	}
	
	public void preencherSetor(){
		SetorDAOImpl sDAO = new SetorDAOImpl();
		List<String> setores = new ArrayList<String>();
		
		setores = sDAO.pesquisarTudo();
		
		for (int i = 0; i < setores.size(); i++) {
			cbSetor.addItem(setores.get(i));
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
