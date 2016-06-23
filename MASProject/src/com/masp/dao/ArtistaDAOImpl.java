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
		String sql = "INSERT INTO artista ( nome, localNasc, anoNasc, anoMorte) " +
					 " VALUES (?, ?, ?, ?) ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, a.getNome() );
			st.setString( 2, a.getLocalNasc() );
			java.sql.Date d = new java.sql.Date ( a.getAnoNasc().getTime() );
			st.setDate(3, d );
			d = new java.sql.Date ( a.getAnoMorte().getTime() );
			st.setDate(4, d );
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Artista> pesquisarPorNome(String nome) {
		List<Artista> lista = new ArrayList<Artista>();
		Artista a = new Artista();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT DISTINCT * FROM artista WHERE nome like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, "%" + nome + "%" );
			ResultSet rs = st.executeQuery();
			while( rs.next() ) {
				a.setId(  rs.getLong("id")  );
				a.setNome(  rs.getString("nome")  );
				a.setLocalNasc(  rs.getString("localNasc")  );
				a.setAnoMorte( rs.getDate("anoNasc") );
				a.setAnoMorte(  rs.getDate("anoMorte") );
				lista.add( a );
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return lista;
	}

	@Override
	public Artista pesquisarPorId(Long id) {
		Artista a = new Artista();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT * FROM artista WHERE id = ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				a.setId(  rs.getLong("id")  );
				a.setNome(  rs.getString("nome")  );
				a.setLocalNasc(  rs.getString("localNasc")  );
				a.setAnoMorte( rs.getDate("anoNasc") );
				a.setAnoMorte(  rs.getDate("anoMorte") );
			}
				st.close();
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return a;
	}
	@Override
	public void remover(String nome) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "DELETE FROM artista WHERE nome = ?";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, nome );
			st.executeUpdate();
			st.close();
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
