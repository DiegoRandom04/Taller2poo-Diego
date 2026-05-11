package Package1;

import java.util.ArrayList;
import java.util.Scanner;
public class Jugador {
	private String nombre;
	private ArrayList<Pokemon> listaPokemon;
	private ArrayList<Pokemon> listaEquipoPokemon;
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		this.listaPokemon = new ArrayList<Pokemon>();
		this.listaEquipoPokemon = new ArrayList<Pokemon>();

	}
	
	public void addPokemon(Pokemon pokemon) {
		// cuando se capture un pokemon se anadira un pokemon aqui adentro, la logica de aparicion de  se encuentra en habitat
		boolean pokemonEncontrado = false;
		
		for (int i = 0; i< listaPokemon.size();i++) {
			if (pokemon.getNombre().equals(listaPokemon.get(i).getNombre())) {
				//si se encuentra  nombre del pokemon en la listaPokemon, no se agregara ya que ha sido encontrado
				pokemonEncontrado = true;
				System.out.println("Ya tienes al pokemon " + pokemon.getNombre() + "!");
			}
		}
		if (pokemonEncontrado == false) {
			this.listaPokemon.add(pokemon);
			System.out.println("Has capturado al " + pokemon.getNombre()+"!");
			if (listaEquipoPokemon.size() <= 6 && listaPokemon.size() > 0) {
				for (int i = 0; i < 6 && i < listaPokemon.size(); i++) {
					//Si i (iterador) es menor a 6 (maximo de equipo) y es menor a al tamano de listapokemon (para evitar que se salga de rango) que agregue los primeros 6 para formar el equipo
				try {
					listaEquipoPokemon.set(i,listaPokemon.get(i));
				}catch(Exception e) {
					// en caso que se genere una exception por el hecho de ser indice 0(osea que sea un arreglo vacio) se anade para empezar el arreglo, en casi de que se lleguen a llenar los 6 pokemons, se iran reemplazando por los mismo solo para que exista la logica y no se muevan sin querer los pokemons ya existentes en el equipo
					listaEquipoPokemon.add(pokemon);
				}
				}
			
				}
			}
	}

	public String getNombre() {
		//solo retorna el nombre, nada fuera de lo esperado
		return nombre;
	}
	
	public void revisarEquipo() {
		//esto imprime todos los pokemon que existen en el quipo, que pueden ir desde 0 hasta maximo de 6 pokemons
		for (int i = 0; i < listaEquipoPokemon.size();i++) {
			System.out.println(listaEquipoPokemon.get(i).getNombre() + " | Puntos: " + listaEquipoPokemon.get(i).getSumaPuntos());
			
		}
		if (this.listaEquipoPokemon.size() == 0) {
			System.out.println("No hay pokemons En el equipo!");
		}
 	}

	public void accesoAlPC() {
		Scanner userEntry = new Scanner(System.in);
		System.out.println("Pokemons del equipo:");
		boolean funciona = true;
		do {
	
			try {	
			for (int i = 0; i < listaEquipoPokemon.size();i++) {
				System.out.println(i+1+")" + listaEquipoPokemon.get(i).getNombre() + " | Puntos: " + listaEquipoPokemon.get(i).getSumaPuntos());
			}
			
			System.out.println("==========================");
			
			System.out.println("Pokemons totales del jugador:");
			for (int i = 0; i < listaPokemon.size();i++) {
				System.out.println(i+1+")" + listaPokemon.get(i).getNombre() + " | Puntos: " + listaEquipoPokemon.get(i).getSumaPuntos());
				
			}
			System.out.println("Ingrese el primer pokemon del equipo que quiere intercambiar:");
			int indicePokemonReemplazar = Integer.parseInt(userEntry.nextLine());
			System.out.println("Ingrese el segundo Pokemon a reemplazar");
			int indicePokemonReemplazar2 = Integer.parseInt(userEntry.nextLine());
	
			Pokemon auxPokemon = listaEquipoPokemon.get(indicePokemonReemplazar);
			listaPokemon.set(indicePokemonReemplazar, listaPokemon.get(indicePokemonReemplazar2));
			listaPokemon.set(indicePokemonReemplazar2, auxPokemon);	//												  ||		
			//																											      ||
			// este algoritmo es para actualiza el equipo, por lo que he de reutilizarlo por que lo necesito tal cual \/ 
			for (int i = 0; i < 6 && i < listaPokemon.size(); i++) {
				//Si i (iterador) es menor a 6 (maximo de equipo) y es menor a al tamano de listapokemon (para evitar que se salga de rango) que agregue los primeros 6 para formar el equipo
			try {
				listaEquipoPokemon.set(i,listaPokemon.get(i));
			}catch(Exception e) {
			}
			}
			funciona = true; // en este punto se sabe que ya ha funcionado todo
		}catch(Exception e) {
			System.out.println("Asegurese de que los datos solicitados sean correspondientes a los mostrados. Intente nuevamente...");
		funciona =false;
		}
		}while(funciona == false);
	}
}
