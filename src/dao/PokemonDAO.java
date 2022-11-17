package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Pokemon;
import bean.Treinador;

public class PokemonDAO {

	private static Connection connection = new FabricaConexoes().getConnection();
	
	public static int inserir(Pokemon pokemon) {
		int inseriu = 0;
		String sql = "INSERT INTO pokemon(NumeroPokedex, Nome, Elemento, Geracao, Experiencia, Situacao, Hp, IdTreinador, IdTreinadorCapturador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, pokemon.getNumeroPokedex());
			stmt.setString(2, pokemon.getNome());
			stmt.setString(3, pokemon.getElemento());
			stmt.setInt(4, pokemon.getGeracao());
			stmt.setInt(5, pokemon.getExperiencia());
			stmt.setDouble(6, pokemon.getSituacao());
			stmt.setInt(7, pokemon.getHp());
			if (pokemon.getTreinador() != null) {
				stmt.setInt(8, pokemon.getTreinador().getId());
			} else {
				stmt.setNull(8, 0);
			}
			if (pokemon.getTreinadorCapturador() != null) {
				stmt.setInt(9, pokemon.getTreinadorCapturador().getId());
			} else {
				stmt.setNull(9, 0);
			}
			
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public static int remover(int id, int numeroPokedex) {
		int removeu = 0;
		String sql = "DELETE FROM pokemon WHERE Id=? and NumeroPokedex=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, numeroPokedex);
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public static int alterar(Pokemon pokemon, int id, int numeroPokedex) {
		int alterou = 0;
		String sql = "UPDATE pokemon SET Nome=?, Elemento=?, Geracao=?, Experiencia=?, Situacao=?, Hp=?, IdTreinador=?, IdTreinadorCapturador=? WHERE Id=? and NumeroPokedex=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, pokemon.getNome());
			stmt.setString(2, pokemon.getElemento());
			stmt.setInt(3, pokemon.getGeracao());
			stmt.setInt(4, pokemon.getExperiencia());
			stmt.setDouble(5, pokemon.getSituacao());
			stmt.setInt(6, pokemon.getHp());
			if (pokemon.getTreinador() != null) {
				stmt.setInt(7, pokemon.getTreinador().getId());
			} else {
				stmt.setNull(7, 0);
			}
			if (pokemon.getTreinadorCapturador() != null) {
				stmt.setInt(8, pokemon.getTreinadorCapturador().getId());
			} else {
				stmt.setNull(8, 0);
			}
			stmt.setInt(9, id);
			stmt.setInt(10, numeroPokedex);
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public static ArrayList<Integer> getIds(int ndex){
		ArrayList<Integer> ids = new ArrayList();
		String sql = "SELECT DISTINCT id FROM pokemon where numeroPokedex=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, ndex);
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
	
	public static Pokemon getPokemon(int id, int ndex){
		Pokemon pokemon = null;
		String sql = "SELECT Nome, Elemento, Geracao, Experiencia, Situacao, Hp, IdTreinador FROM pokemon WHERE Id=? AND NumeroPokedex=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, ndex);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("Nome");
				String elemento = rs.getString("Elemento");
				int geracao = rs.getInt("Geracao");
				int experiencia = rs.getInt("Experiencia");
				double situacao = rs.getDouble("Situacao");
				int hp = rs.getInt("Hp");
				Treinador treinador = TreinadorDAO.getTreinador(rs.getInt("IdTreinador"));
				pokemon = new Pokemon(nome, elemento, geracao,
						experiencia, situacao, hp, treinador);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemon;
	}
	
	public static ArrayList<Pokemon> getPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<>();
		String sql = "SELECT * FROM pokemon ORDER BY NumeroPokedex";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int Ndex = rs.getInt("NumeroPokedex");
				int id = rs.getInt("Id");
				String nome = rs.getString("Nome");
				String elemento = rs.getString("Elemento");
				int geracao = rs.getInt("Geracao");
				int experiencia = rs.getInt("Experiencia");
				double situacao = rs.getDouble("Situacao");
				int hp = rs.getInt("Hp");
				Treinador treinador = TreinadorDAO.getTreinador(rs.getInt("IdTreinador"));
				Pokemon p = new Pokemon(id, Ndex, nome, elemento, geracao,
						experiencia, situacao, hp, treinador, treinador);
				pokemons.add(p);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemons;
	}
}
