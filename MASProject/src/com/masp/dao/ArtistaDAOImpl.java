package com.masp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Artista;
import com.masp.entity.Categoria;

public class ArtistaDAOImpl implements ArtistaDAO{

	@Override
	public void adicionar(Artista a) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO artista (id, nome, localNasc, anoNasc, anoMorte) " +
					 " VALUES (?, ?, ?, ?, ?) ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, a.getId() );
			st.setString( 2, a.getNome() );
			st.setString( 3, a.getLocalNasc() );
			java.sql.Date d = new java.sql.Date ( a.getAnoNasc().getTime() );
			st.setDate(4, d );
			d = new java.sql.Date ( a.getAnoMorte().getTime() );
			st.setDate(5, d );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Artista> pesquisar(String nome) {
		List<Artista> lista = new ArrayList<Artista>();
		Artista a = new Artista();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT * FROM artista WHERE nome like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, "%" + nome + "%" );
			ResultSet rs = st.executeQuery();
			while( rs.next() ) {
				a.setId(  rs.getLong("id")  );
				a.setNome(  rs.getString("nome")  );
				a.setLocalNasc(  rs.getString("descricao")  );
				a.setAnoMorte( rs.getDate("anoNasc") );
				a.setAnoMorte(  rs.getDate("anoMorte") );
				lista.add( a );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return lista;
	}

	@Override
	public void remover(String nome) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "DELETE FROM artista WHERE nome = ?";
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
	public void atualizar(Artista oldA, Artista newA) {
		// TODO Auto-generated method stub
		
	}

}
