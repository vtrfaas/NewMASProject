package com.masp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masp.entity.Categoria;
import com.masp.entity.Material;

public class MaterialDAOImpl implements MaterialDAO {
	

	@Override
	public void adicionar(Material m) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "INSERT INTO material (nome, id_categoria) VALUES (?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getNome());
			ps.setLong(2, m.getCategoria());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}

	@Override
	public List<Material> pesquisarNome(String nome) {
		Connection con = DBUtil.getInstancia().openConnection();
		List<Material> materiais = new ArrayList<Material>();
		String sql = "SELECT * FROM material WHERE nome like ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Material m = new Material();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				m.setCategoria(rs.getLong("id_categoria"));
				materiais.add(m);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
		return materiais;
	}

		
	@Override
	public Material pesquisarId(Long id) {
		Material m = new Material();
		Categoria ca = new Categoria();
		Connection con = DBUtil.getInstancia().openConnection();
		
		try {
			String sql = "SELECT * FROM material WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				ca.setId(rs.getLong("id_categoria"));
				m.setCategoria(ca.getId());
			}
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
		
		return m;
	}

	@Override
	public List<Material> pesquisarTudo() {
		Connection con = DBUtil.getInstancia().openConnection();
		List<Material> materiais = new ArrayList<Material>();
		String sql = "SELECT * FROM material";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Material m = new Material();
				Categoria ca = new Categoria();
				m.setId( rs.getLong("id") );
				m.setNome( rs.getString("nome") );
				ca.setId(rs.getLong("id_categoria"));
				m.setCategoria(ca.getId());
				materiais.add( m );
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
		return materiais;
	}

	@Override
	public void remover(String nome) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "DELETE FROM material WHERE nome = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Material newM) {
		Connection con = DBUtil.getInstancia().openConnection();
		String sql = "UPDATE material SET nome = ?, id_categoria = ? WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newM.getNome());
			ps.setLong( 2, newM.getCategoria() );
			ps.setLong( 3, newM.getId() );
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.getInstancia().closeConnection();
	}
}
