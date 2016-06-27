package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Ingresso;

public class IngressoDAOImpl implements IngressoDAO{

	@Override
	public void adicionar(Ingresso ing) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO ingresso (id, data, valor, qtde, nomeExposicao) " +
					 " VALUES (?, ?, ?, ?, ?) ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, ing.getId() );
			java.sql.Date d = new java.sql.Date( ing.getData().getTime() );
			st.setDate( 2, d );
			st.setFloat( 3, ing.getValor() );
			st.setInt( 4,  ing.getQtde() );
			st.setLong(5, ing.getExposicao() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Ingresso> pesquisar(String nome) {
		List<Ingresso> lista = new ArrayList<Ingresso>();
		Ingresso ing = new Ingresso();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT * FROM ingresso WHERE exposicao like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, "%" + nome + "%" );
			ResultSet rs = st.executeQuery();
			ing.setId(  rs.getLong("id")  );
			ing.setData(  rs.getDate("data")  );
			ing.setValor( rs.getFloat("valor") );
			ing.setQtde( rs.getInt("qtde") );
			ing.setExposicao( rs.getLong("exposicao") );
			lista.add( ing );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return lista;
	}

	@Override
	public List<Ingresso> pesquisarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
