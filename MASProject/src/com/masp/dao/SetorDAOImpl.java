package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Setor;

public class SetorDAOImpl implements SetorDAO{

	@Override
	public void adicionar(Setor s) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO setor (id, nome, andar) " +
					 " VALUES (?, ?, ?) ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, s.getId() );
			st.setString( 2, s.getNome() );
			st.setString( 3, s.getAndar() );
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Setor> pesquisar(String nomeSetor) {
		List<Setor> lista = new ArrayList<Setor>();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT nome FROM setor WHERE nome like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, "%" + nomeSetor + "%" );
			ResultSet rs = st.executeQuery();
			while ( rs.next() )  { 
				Setor s = new Setor();
				s.setId(  rs.getLong("id")  );
				s.setNome(  rs.getString("nome")  );
				s.setAndar(  rs.getString("andar")  );
				lista.add( s );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return lista;
	}
}
