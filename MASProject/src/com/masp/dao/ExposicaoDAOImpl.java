package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Exposicao;
import com.masp.entity.Obra;

public class ExposicaoDAOImpl implements ExposicaoDAO{

	@Override
	public void adicionar(Exposicao ex) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO exposicao (id, titulo, dtInicio, dtFim, tema, descricao, valor) " +
					 " VALUES (?, ?, ?, ?, ?, ?, ?) ";
		String sql2 = "INSERT INTO exposicao_obra (id_obra, id_exposicao) VALUES (?, ?)";
		int i = 0;
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
			st.setFloat( 7, ex.getValor() );
			st.executeUpdate();
			//testar
			while( i < ex.getObras().size() ){
				st = con.prepareStatement(sql2);
				st.setLong( 1, ex.getObras().get( i ).getId() );
				st.setLong( 2, ex.getId() );
				st.executeUpdate();
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public Exposicao pesquisar(String nome) {
		Exposicao ing = new Exposicao();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT * FROM exposicao WHERE titulo like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, nome);
			ResultSet rs = st.executeQuery();
			while( rs.next() ){
				ing.setId(  rs.getLong("id")  );
				ing.setTitulo(  rs.getString("titulo")  );
				ing.setDtInicio( rs.getDate("dtInicio") );
				ing.setDtFim( rs.getDate("dtFim") );
				ing.setDescricao( rs.getString("descricao") );
				ing.setTema( rs.getString("tema") );
				ing.setValor( rs.getFloat("valor") );
			}
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
	public void atualizar(Exposicao newE) {
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
			st.setString( 6, newE.getTitulo() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}


	@Override
	public Exposicao pesquisarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exposicao> pesquisarTudo() {
		Connection con = DBUtil.getInstancia().openConnection();
		List<Exposicao> exposicoes = new ArrayList<Exposicao>();
		String sql = "SELECT * FROM exposicao";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Exposicao e = new Exposicao();
				e.setId( rs.getLong("id") );
				e.setTitulo( rs.getString("titulo"));
				e.setDtInicio( rs.getDate("dtInicio"));
				e.setDtFim( rs.getDate("dtFim"));
				e.setTema( rs.getString("tema"));
				e.setDescricao( rs.getString("descricao"));
				exposicoes.add( e );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
		return exposicoes;
	}

}
