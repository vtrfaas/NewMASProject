package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Obra;

public class ObraDAOImpl implements ObraDAO {



	@Override
	public void adicionar(Obra o) {
		String sql = "INSERT INTO obra (id_artista , nome," + "id_categoria, id_material, descricao,	"
				+ "imagem, dataComposicao, proprietario,	" + "status, id_setor, preco) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = DBUtil.getInstancia().openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, o.getIdArtista());
			ps.setString(2, o.getNomeObra());
			ps.setLong(3, o.getIdCategoria());
			ps.setLong(4, o.getIdMaterial());
			ps.setString(5, o.getDescricao());
			ps.setString(6, o.getCaminhoImagem());
			java.sql.Date d = new java.sql.Date( o.getDtComposicao().getTime() );
			ps.setDate(7, d);
			ps.setBoolean(8, o.isProprietario());
			ps.setString(9, o.getStatus());
			ps.setLong(10, o.getIdSetor());
			ps.setFloat(11, o.getValor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();

	}

	@Override
	public List<Obra> pesquisar(String nome) {
		List<Obra> obras = new ArrayList<Obra>();
		String sql = "SELECT * FROM obra WHERE nome like ?";
		Connection con = DBUtil.getInstancia().openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Obra o = new Obra();
				o.setId(rs.getLong("id"));
				o.setCaminhoImagem(rs.getString("imagem"));
				o.setDescricao(rs.getString("descricao"));
				o.setDtComposicao(rs.getDate("dataComposicao"));
				o.setIdArtista(rs.getLong("id_artista"));
				o.setIdCategoria(rs.getLong("id_artista"));
				o.setIdMaterial(rs.getLong("id_material"));
				o.setIdSetor(rs.getLong("id_setor"));
				o.setNomeObra(rs.getString("nome"));
				o.setProprietario(rs.getBoolean("proprietario"));
				o.setStatus(rs.getString("status"));
				o.setValor(rs.getFloat("preco"));
				obras.add(o);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
		return obras;
	}

	@Override
	public void remover(Obra o) {
		String sql = "DELETE FROM obra WHERE id = ?";
		Connection con = DBUtil.getInstancia().openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, o.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public void atualizar(Obra o) {
		String sql = "UPDATE obra SET id_artista = ? , nome = ?," + "id_categoria = ?, id_material = ?, descricao = ?,"
				+ "imagem = ?, dataComposicao = ?, proprietario = ?,"
				+ "status = ?, id_setor = ?, preco = ? WHERE id = ?";
		Connection con = DBUtil.getInstancia().openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, o.getIdArtista());
			ps.setString(2, o.getNomeObra());
			ps.setLong(3, o.getIdCategoria());
			ps.setLong(4, o.getIdMaterial());
			ps.setString(5, o.getDescricao());
			ps.setString(6, o.getCaminhoImagem());
			java.sql.Date d = new java.sql.Date( o.getDtComposicao().getTime() );
			ps.setDate(7, d);
			ps.setBoolean(8, o.isProprietario());
			ps.setString(9, o.getStatus());
			ps.setLong(10, o.getIdSetor());
			ps.setFloat(11, o.getValor());
			ps.setLong(12, o.getId());

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

}
