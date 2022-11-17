package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bean.Pokemon;
import bean.Treina;
import bean.Treinador;
import dao.PokemonDAO;
import dao.TreinaDAO;
import dao.TreinadorDAO;

class Testes {

	@Test
	void teste_um() {
		Pokemon p = new Pokemon(11, 8, "PokemonDoTESTE", "FOGO", 1, 1, 1, 1, new Treinador(4), new Treinador(4));
		int inseriu = PokemonDAO.inserir(p);
		assertEquals(1, inseriu);
	}

	@Test
	void teste_dois() {
		Treinador t = new Treinador(8, "Arthur", 0, "M");
		int inseriu = TreinadorDAO.inserir(t);
		assertEquals(1, inseriu);
	}
	
	@Test
	void teste_tres() {
		assertEquals(Treinador.class, TreinadorDAO.getTreinador(3).getClass());
	}
	
	@Test
	void teste_quatro() {
		assertEquals(Pokemon.class, PokemonDAO.getPokemon(1, 1).getClass());
	}
}
