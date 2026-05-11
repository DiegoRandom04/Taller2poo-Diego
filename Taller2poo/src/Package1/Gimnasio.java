package Package1;
import java.util.ArrayList;
public class Gimnasio {
	private int id;
	private Personaje lider;
	private int cantPokemon;
	private String estado;
	private Boolean habilitado;
	private ArrayList <String> listaPokemon; // note que es un string ya que solo aparecen string
	public Gimnasio(int id, Personaje lider, int cantPokemon, ArrayList<String> listaPokemon) {
		super();
		this.id = id;
		this.lider = lider;
		this.cantPokemon = cantPokemon;
		this.listaPokemon = listaPokemon;
		this.habilitado = false;
	}
	
	
	public void retarGimnasio(Jugador jugador) {
		if (habilitado == true) {
			// si esta habilitado para retar que se ejecute todo el codigo para retar
			
		}
		else if (habilitado == false) {
			System.out.println("No se puede retar a este gimnasio sin haber retado al anterior!");
		}
	}
}
