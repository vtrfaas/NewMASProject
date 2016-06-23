package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public void adicionar(Categoria c) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO categoria (id, nome, descricao) " +
					 " VALUES (?, ?, ?) ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, c.getId() );
			st.setString( 2, c.getNome() );
			st.setString( 3, c.getDescricao() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public Categoria pesquisarPorNome(String nome) {
		Categoria c = new Categoria();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT nome FROM categoria WHERE nome like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, "%" + nome + "%" );
			ResultSet rs = st.executeQuery();
			c.setId(  rs.getLong("id")  );
			c.setNome(  rs.getString("nome")  );
			c.setDescricao(  rs.getString("descricao")  );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return c;
	}
	
	@Override
	public Categoria pesquisarPorId(Long id) {
		Categoria c = new Categoria();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT nome FROM categoria WHERE id = ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, id);
			ResultSet rs = st.executeQuery();
			c.setId(  rs.getLong("id")  );
			c.setNome(  rs.getString("nome")  );
			c.setDescricao(  rs.getString("descricao")  );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return c;
	}
	
	
	@Override
	public List<Categoria> pesquisarTudo() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT id, nome FROM categoria";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			ResultSet rs = st.executeQuery();
			while ( rs.next() )  { 
				Categoria c = new Categoria();
				c.setId( rs.getLong("id") );
				c.setNome( rs.getString("nome"));
				categorias.add( c );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return categorias;
	}

	@Override
	public void remover(Long numero) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "DELETE FROM categoria WHERE id = ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong(1, numero);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	//Testar
	@Override
	public void atualizar(Categoria oldC, Categoria newC) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "UPDATE categoria SET (?, ?, ?) WHERE " +
					 "id = ?";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, newC.getId() );
			st.setString( 2, newC.getNome() );
			st.setString( 3, newC.getDescricao() );
			st.setLong( 4, oldC.getId() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	

	
}
