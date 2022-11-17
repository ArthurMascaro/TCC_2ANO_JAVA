package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import bean.Pokemon;
import bean.Treina;
import bean.Treinador;

public class TreinaDAO {

	private static Connection connection = new FabricaConexoes().getConnection();
	
	public static int inserir(Treina t) {
		int inseriu = 0;
		String sql = "INSERT INTO treina(IdPokemon, NumeroPokedexPokemon, IdTreinador, dataHora) values (?, ?, ?, now());";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, t.getPokemon().getId());
			stmt.setInt(2, t.getPokemon().getNumeroPokedex());
			stmt.setInt(3, t.getTreinador().getId());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public static int remover(Treina t) {
		int removeu = 0;
		String sql = "DELETE FROM treina where IdPokemon=? and NumeroPokedexPokemon=? and IdTreinador=? and dataHora=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement)connection.prepareStatement(sql);
			stmt.setInt(1, t.getPokemon().getId());
			stmt.setInt(2, t.getPokemon().getNumeroPokedex());
			stmt.setInt(3, t.getTreinador().getId());
			stmt.setTimestamp(4, t.getData_hora());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public static int alterar(Treina t, Treina t2) {
		int alterou = 0;
		String sql = "UPDATE treina set IdPokemon=?, NumeroPokedexPokemon=?, IdTreinador=?, dataHora=now() where IdPokemon=? and NumeroPokedexPokemon=? and IdTreinador=? and dataHora=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, t2.getPokemon().getId());
			stmt.setInt(2, t2.getPokemon().getNumeroPokedex());
			stmt.setInt(3, t2.getTreinador().getId());
			stmt.setInt(4, t.getPokemon().getId());
			stmt.setInt(5, t.getPokemon().getNumeroPokedex());
			stmt.setInt(6, t.getTreinador().getId());
			stmt.setTimestamp(7, t.getData_hora());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
	
	public static ArrayList<Treina> getTreinos(){
		ArrayList<Treina> treinadores = new ArrayList<>();
		String sql = "SELECT * FROM treina;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Treinador tr = new Treinador(rs.getInt("IdTreinador"));
				Pokemon p = new Pokemon(rs.getInt("IdPokemon"), rs.getInt("NumeroPokedexPokemon"));
				Treina t = new Treina(tr, p, rs.getTimestamp("DataHora"));
				treinadores.add(t);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treinadores;
	}
	
	public static ArrayList<Timestamp> getDatasTreino(Treina t){
		ArrayList<Timestamp> datas = new ArrayList<>();
		String sql = "SELECT dataHora FROM treina WHERE IdPokemon=? and NumeroPokedexPokemon=? and IdTreinador=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, t.getPokemon().getId());
			stmt.setInt(2, t.getPokemon().getNumeroPokedex());
			stmt.setInt(3, t.getTreinador().getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				datas.add(rs.getTimestamp("DataHora"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public static ArrayList<Integer> getIdsPorNDex(int ndex){
		ArrayList<Integer> ids = new ArrayList<>();
		String sql = "SELECT DISTINCT IdPokemon FROM treina WHERE NumeroPokedexPokemon = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, ndex);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt("IdPokemon"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	public static ArrayList<Integer> getTreinadoresPorPokemon(Pokemon p){
		ArrayList<Integer> ids = new ArrayList<>();
		String sql = "SELECT DISTINCT idTreinador FROM treina WHERE IdPokemon = ? AND NumeroPokedexPokemon = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, p.getId());
			stmt.setInt(2, p.getNumeroPokedex());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt("idTreinador"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	public static ArrayList<Pokemon> getPokemonsPorTreinador(Treinador t){
		ArrayList<Pokemon> pokemons = new ArrayList<>();
		String sql = "SELECT IdPokemon, NumeroPokedexPokemon FROM treina where IdTreinador=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, t.getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				pokemons.add(new Pokemon(rs.getInt("IdPokemon"), rs.getInt("NumeroPokedexPokemon")));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pokemons;
	}
	
	public static int removerPorPoke(Pokemon p) {
		int removeu = 0;
		String sql = "DELETE FROM treina where IdPokemon=? and NumeroPokedexPokemon=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement)connection.prepareStatement(sql);
			stmt.setInt(1, p.getId());
			stmt.setInt(2, p.getNumeroPokedex());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public static int removerPorTreina(Treinador t) {
		int removeu = 0;
		String sql = "DELETE FROM treina where IdTreinador=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement)connection.prepareStatement(sql);
			stmt.setInt(1, t.getId());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public static Boolean existeRelacaoTreinador(Treinador t) {
		Boolean existe = false;
		String sql = "SELECT COUNT(*) as cont FROM treina where IdTreinador=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement)connection.prepareStatement(sql);
			stmt.setInt(1, t.getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int cont = rs.getInt("cont");
				if (cont > 0) {
					existe = true;
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}
	
	public static Boolean existeRelacaoPokemon(Pokemon p) {
		Boolean existe = false;
		String sql = "SELECT COUNT(*) as cont FROM treina where IdPokemon=? and NumeroPokedexPokemon=?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement)connection.prepareStatement(sql);
			stmt.setInt(1, p.getId());
			stmt.setInt(2, p.getNumeroPokedex());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int cont = rs.getInt("cont");
				if (cont > 0) {
					existe = true;
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}
}
