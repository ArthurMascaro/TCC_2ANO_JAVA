package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Treinador;

public class TreinadorDAO {
	
	private static Connection connection = new FabricaConexoes().getConnection();

	public static int inserir(Treinador treinador) {
		int inseriu = 0;
		String sql = "INSERT INTO treinador(Nome, RegistroPokedex, Sexo) VALUES (?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, treinador.getNome());
			stmt.setInt(2, treinador.getRegistroPokedex());
			stmt.setString(3, treinador.getSexo());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public static int remover(int id) {
		int removeu = 0;
		String sql = "DELETE FROM treinador WHERE Id=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public static int alterar(Treinador treinador) {
		int alterou = 0;
		String sql = "UPDATE treinador SET Nome=?, RegistroPokedex=?, Sexo=? where Id=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, treinador.getNome());
			stmt.setInt(2, treinador.getRegistroPokedex());
			stmt.setString(3, treinador.getSexo());
			stmt.setInt(4, treinador.getId());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}

	public static ArrayList<Integer> getListaId() {
		ArrayList<Integer> ids = new ArrayList<>();
		String sql = "SELECT id FROM treinador;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt("id"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	public static Treinador getTreinador(int id) {
		Treinador t = null;
		String sql = "SELECT * FROM treinador WHERE id=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				t = new Treinador(id, rs.getString("Nome"), rs.getInt("RegistroPokedex"), rs.getString("Sexo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static ArrayList<Treinador> treinadores(){
		ArrayList<Treinador> treinadores = new ArrayList<>();
		String sql = "SELECT * FROM treinador";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Treinador t = new Treinador(rs.getInt("Id"), rs.getString("Nome"), rs.getInt("RegistroPokedex"), rs.getString("Sexo"));
				treinadores.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treinadores;
	}
}
