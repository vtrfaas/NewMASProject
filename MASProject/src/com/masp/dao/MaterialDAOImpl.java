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
	
	private Connection c;

	public MaterialDAOImpl() {
		c = DBUtil.getInstancia().openConnection();
	}

	@Override
	public void adicionar(Material m) {
		String sql = "INSERT INTO material (nome, id_categoria) VALUES (?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, m.getNome());
			ps.setLong(2, m.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Material> pesquisar(Long id) {
		List<Material> materiais = new ArrayList<Material>();
		String sql = "SELECT * FROM material WHERE id like ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Material m = new Material();
				Categoria c = new Categoria();
				m.setId(rs.getLong("id"));
				m.setNome(rs.getString("nome"));
				c.setId(rs.getLong("id_categoria"));
				m.setCategoria(c);
				materiais.add(m);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return materiais;
	}

	@Override
	public List<String> pesquisarTudo() {
		List<String> materiais = new ArrayList<String>();
		String sql = "SELECT nome FROM material";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				materiais.add(rs.getString("nome"));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return materiais;
	}

	@Override
	public void remover(Material m) {
		String sql = "DELETE FROM material WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setLong(1, m.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Material m) {
		String sql = "UPDATE material SET nome = ?, id_categoria = ? WHERE id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, m.getNome());
			Categoria c = new Categoria();
			c = m.getCategoria();
			ps.setLong(2, c.getId());
			ps.setLong(3, m.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
