package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masp.entity.Exposicao;

public class ExposicaoDAOImpl implements ExposicaoDAO{

	@Override
	public void adicionar(Exposicao ex) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO exposicao (id, titulo, dtInicio, dtFim, tema, descricao) " +
					 " VALUES (?, ?, ?, ?, ?, ?) ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, ex.getId() );
			st.setString(2, ex.getTitulo() );
			java.sql.Date d = new java.sql.Date( ex.getDtInicio().getTime() );
			st.setDate( 3, d );
			d = new java.sql.Date( ex.getDtFim().getTime() );
			st.setDate( 4, d );
			st.setString( 5,  ex.getTema() );
			st.setString( 6, ex.getDescricao() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public Exposicao pesquisar(String nome) {
		Exposicao ing = new Exposicao();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT * FROM exposicao WHERE nome like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, "%" + nome + "%" );
			ResultSet rs = st.executeQuery();
			ing.setId(  rs.getLong("id")  );
			ing.setTitulo(  rs.getString("titulo")  );
			ing.setDtInicio( rs.getDate("dtInicio") );
			ing.setDtFim( rs.getDate("dtFim") );
			ing.setDescricao( rs.getString("descricao") );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return ing;
	}

	@Override
	public void remover(String nome) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "DELETE FROM exposicao WHERE nome = ?";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, nome );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public void atualizar(Exposicao oldE, Exposicao newE) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "UPDATE categoria SET (?, ?, ?, ?, ?, ?) WHERE " +
					 "nome = ?";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, newE.getId() );
			st.setString( 2, newE.getTitulo() );
			java.sql.Date d = new java.sql.Date( newE.getDtInicio().getTime() );
			st.setDate( 3, d );
			d = new java.sql.Date( newE.getDtFim().getTime() );
			st.setDate( 4, d );
			st.setString( 5, newE.getDescricao() );
			st.setString( 6, oldE.getTitulo() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

}
