package Package1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	ArrayList<Habitat> listaHabitat;

	public Menu(ArrayList<Habitat> listaHabitat) {
		super();
		this.listaHabitat = listaHabitat;
	}
	public void salirACapturar(Jugador jugador) {
		
		/*Lo que hace este metodo es que al salir a capturar, se explora por habitat y se procede a crear un pokemon
		 * este pokemon tiene la opcion el jugador de capturar o no capturar, dependiendo de lo que quiera hacer
		 * 
		 * entonces cuenta con unos filtros de errores para evitar algun dato erroneo distinto a los habitats disponibles
		 * 
		 */
		
		Scanner sc = new Scanner (System.in);
		String userInput;
		int opcion= 0;
		do {
		for (int i = 0; i<listaHabitat.size();i++) {
			System.out.println(i+1 + ") " + listaHabitat.get(i).getHabitat() );

		}
		userInput = sc.nextLine();
		try {
			opcion = Integer.parseInt(userInput);
		}catch(Exception e) {
			opcion = -1;
		}
		} while(opcion > listaHabitat.size() || opcion < 1);
		
		Pokemon pokemon = listaHabitat.get(opcion-1).crearPokemon();
		
		System.out.println("Ha aparecido un " + pokemon.getNombre() + "!");
		do {
			
		System.out.println();
		System.out.println("1) Capturar Pokemon");
		System.out.println("2) huir");
		userInput = sc.nextLine();

		try {
			opcion = Integer.parseInt(userInput);
		}catch(Exception e) {
			opcion = -1;
		}
		
		}while(opcion < 1 && opcion  > 2);
		
		if(opcion == 1) {
			jugador.addPokemon(pokemon);
		}
		else if (opcion == 2) {
			System.out.println("Ha huido exitosamente");
		}
	
		
	}
	public void revisarEquipo(Jugador jugador) {
		jugador.revisarEquipo();
	}
	public void accesoAlPC(Jugador jugador) {
		jugador.accesoAlPC();
	}
	
	
}
