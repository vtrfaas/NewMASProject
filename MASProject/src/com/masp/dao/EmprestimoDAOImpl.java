package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Artista;
import com.masp.entity.Emprestimo;

public class EmprestimoDAOImpl implements EmprestimoDAO{

	@Override
	public void adicionar(Emprestimo e) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO emprestimo (id, id_obra, destino, " +
				 	"dataInicial, dateFinal, museu, custo) " +
					" VALUES (?, ?, ?, ?, ?, ?, ?) ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setLong( 1, e.getId() );
			st.setLong( 2, e.getObra().getId() );
			st.setString( 3, e.getDestino() );
			java.sql.Date d = new java.sql.Date ( e.getDataInicial().getTime() );
			st.setDate(4, d );
			d = new java.sql.Date ( e.getDataFinal().getTime() );
			st.setDate(5, d );
			st.setString( 6,  e.getMuseu() );
			st.setFloat( 7, e.getCusto() );
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Emprestimo> pesquisar(String museu) {
		List<Emprestimo> lista = new ArrayList<Emprestimo>();
		Emprestimo a = new Emprestimo();
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "SELECT * FROM artista WHERE nome like ? ";
		try {
			PreparedStatement st = con.prepareStatement( sql );
			st.setString( 1, "%" + museu + "%" );
			ResultSet rs = st.executeQuery();
			while( rs.next() ) {
				a.setId(  rs.getLong("id")  );
//				a.setObra( (  rs.getLong("id_obra")  );
				a.setDestino(  rs.getString("destino")  );
				a.setDataInicial( rs.getDate("dataInicial") );
				a.setDataFinal(  rs.getDate("dataFinal") );
				a.setMuseu( rs.getString("museu") );
				a.setCusto( rs.getFloat("custo") );
				lista.add( a );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();	
		return lista;
	}

	@Override
	public void atualizar(Emprestimo oldM, Emprestimo newM) {
		
	}
	
}
