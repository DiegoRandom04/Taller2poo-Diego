package Package1;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;
public class Habitat {
	private String habitat;
	private ArrayList<Pokemon> listaPokemon;
	public Habitat(String habitat) {
		/*Este constuye el habitat, los datos se extraen del archivo
		 * 
		 */
		super();
		this.habitat = habitat;
		this.listaPokemon = new ArrayList<Pokemon>();
	}
	
	public ArrayList<Pokemon> getListaPokemon() {
		return listaPokemon;
	}

	public void setListaPokemon(ArrayList<Pokemon> listaPokemon) {
		this.listaPokemon = listaPokemon;
	}

	public Pokemon crearPokemon(){
		ArrayList<Pokemon> sorteoPokemon = new ArrayList<Pokemon>();
		for (int i = 0; i< this.listaPokemon.size();i++) {
			int probAparicion = (int)this.listaPokemon.get(i).getPorcentajeAparicion();
			for (int a = 0; a < probAparicion +1; a++) {
				sorteoPokemon.add(this.listaPokemon.get(i));
			}
		}
		
		int tamanoArraySorteo = sorteoPokemon.size();
		Random random = new Random();
		int pokemonAparecido = 0;
		try {
			pokemonAparecido = random.nextInt(tamanoArraySorteo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pokemon pokemonAparecido1 = sorteoPokemon.get(pokemonAparecido);
		return pokemonAparecido1;
	}
	public void addPokemon(Pokemon pokemon) {
		this.listaPokemon.add(pokemon);
	}

	public String getHabitat() {
		return habitat;
	}
}
