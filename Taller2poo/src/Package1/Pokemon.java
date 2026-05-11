package Package1;

public class Pokemon {
 private String nombre;
 private float maxVida;
 private float vida;
 private float ataque;
 private float ataqueEspecial;
 private float defensa;
 private float defensaEspecial;
 private float velocidad;
 private String tipo;
 private boolean estadoVivo;
 private float porcentajeAparicion;
 private String habitat;
 private float sumaPuntos;
 private float maxPuntos;
 public float getPorcentajeAparicion() {
	return porcentajeAparicion;
}

 public void setPorcentajeAparicion(float porcentajeAparicion) {
	this.porcentajeAparicion = porcentajeAparicion;
 }

 public Pokemon(String nombre,String habitat,float porcentajeAparicion, float vida, float ataque, float defensa, float ataqueEspecial, float defensaEspecial, float velocidad, String tipo) {
	 //Este es el constructor, el cual construye el objeto Pokemon y para ello en la lactura como aparecen todos los datos iniciales, se requieren como entrada para crear pokemon
	 this.nombre = nombre;
	this.vida = vida;
	this.ataque = ataque;
	this.ataqueEspecial = ataqueEspecial;
	this.defensa = defensa;
	this.defensaEspecial = defensaEspecial;
	this.velocidad = velocidad;
	this.estadoVivo = true;
	this.habitat = habitat;
	this.tipo = tipo;
	this.porcentajeAparicion = (porcentajeAparicion)*100; // para que sea en numeros de 1 a 100 internamente, se usara en la logija de crear pokemon en clase Habitat
	this.sumaPuntos = vida + ataque + ataqueEspecial + defensa + defensaEspecial + velocidad; this.maxPuntos = sumaPuntos;
 }

 public String getHabitat() {
	return habitat;
}
  
 public void atacar(Pokemon oponentePokemon, Float [][] tablaTipos) {
	 /*Aqui se ataca al pokemon, cuando el jugador decida atacar a un oponente
	  * este tendra en cuenta los valores de tabla tipos para efectividad del ataque, el cual
	  * es requisito tenerlo como parametro, dependiendo de eso se cambia la vidaa
	  * del pokemon del oponente
	  */
	 String [] filaTablatipos = new String [18];
	 // esta esla fila de tabla tipos
	 filaTablatipos[0] = "Normal";
	 filaTablatipos[1] = "Fuego"; 
	 filaTablatipos[2] = "Agua"; 
	 filaTablatipos[3] = "Planta"; 
	 filaTablatipos[4] = "Electrico"; 
	 filaTablatipos[5] = "Hielo"; 
	 filaTablatipos[6] = "Lucha"; 
	 filaTablatipos[7] = "Veneno"; 
	 filaTablatipos[8] = "Tierra"; 
	 filaTablatipos[9] = "Volador"; 
	 filaTablatipos[10] = "Psiquico"; 
	 filaTablatipos[11] = "Bicho"; 
	 filaTablatipos[12] = "Roca"; 
	 filaTablatipos[13] = "Fantasma"; 
	 filaTablatipos[14] = "Dragon"; 
	 filaTablatipos[15] = "Acero"; 
	 filaTablatipos[16] = "Siniestro"; 
	 filaTablatipos[17] = "Hada"; 

	 String [] columnaTablatipos = new String [18];
	 // esta esla columna de tabla tipos
	 columnaTablatipos[0] = "Normal";
	 columnaTablatipos[1] = "Fuego"; 
	 columnaTablatipos[2] = "Agua"; 
	 columnaTablatipos[3] = "Planta"; 
	 columnaTablatipos[4] = "Electrico"; 
	 columnaTablatipos[5] = "Hielo"; 
	 columnaTablatipos[6] = "Lucha"; 
	 columnaTablatipos[7] = "Veneno"; 
	 columnaTablatipos[8] = "Tierra"; 
	 columnaTablatipos[9] = "Volador"; 
	 columnaTablatipos[10] = "Psiquico"; 
	 columnaTablatipos[11] = "Bicho"; 
	 columnaTablatipos[12] = "Roca"; 
	 columnaTablatipos[13] = "Fantasma"; 
	 columnaTablatipos[14] = "Dragon"; 
	 columnaTablatipos[15] = "Acero"; 
	 columnaTablatipos[16] = "Siniestro"; 
	 columnaTablatipos[17] = "Hada"; 
	 
	 /*Primero se busca en el indice de cada vector fila y columna siendo
	  * que el fila es para el pokemon actual y el columna para el oponente
	  * una vez encontrados se extrae el multiplicador de dano
	  * y eso se multiplica por el ataque para posteriormente cambiar la vida
	  * del oponente y asi lograr danarlo.
	  * 
	  * no hay que olvidar que en cada ataque este pokemon propio del jugador tambien
	  * recivira dano, asique se aplica a ambos
	  * 
	  */
	 
	 int indiceEstePokemon = busquedaLineal(filaTablatipos,this.tipo);
	 int indiceOponentePokemon = busquedaLineal(columnaTablatipos,oponentePokemon.getTipo());
	 
	 float multiplicadorDamage = tablaTipos[indiceEstePokemon][indiceOponentePokemon];
	 
	 oponentePokemon.setSumaPuntos(this.ataque*multiplicadorDamage);
	 setSumaPuntos(oponentePokemon.getAtaque()*multiplicadorDamage);
	 
	 System.out.println(this.nombre + " -> " + sumaPuntos + " puntos." );
	 System.out.println(oponentePokemon.getNombre() + " -> " + oponentePokemon.getSumaPuntos() + " puntos." );
	 if (this.vida <=0) {
		 setEstadoVivo(false);
	 }
	 
	 if (oponentePokemon.getSumaPuntos() <= 0) {
		 oponentePokemon.setEstadoVivo(false);
	 }
 }
 
 public void curar() {
	 // esto es tan simple como curar el pokemon cuando el usuario selecciona le opcion del menu;
	 sumaPuntos = maxPuntos;
 }
 public float getSumaPuntos() {
	return sumaPuntos;
}

 public void setSumaPuntos(float sumaPuntos) {
	this.sumaPuntos = sumaPuntos;
 }

 public float getMaxPuntos() {
	return maxPuntos;
 }

 public String getTipo() {
	return tipo;
}
 
 

 public String getNombre() {
	return nombre;
}

 public float getAtaque() {
	return ataque;
 }

 public boolean isEstadoVivo() {
	return estadoVivo;
}

 public void setEstadoVivo(boolean estadoVivo) {
	this.estadoVivo = estadoVivo;
 }

 private int busquedaLineal(String[] arreglo, String elemento) {
	   for (int i = 0; i < arreglo.length; i++) {
	      if (arreglo[i].equals(elemento)) {
	         return i;
	      }
	   }
	   return -1;
 }
}//fin clase pokemon
