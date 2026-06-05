package juego.motor.personaje;

import juego.motor.hechizo.Hechizo;
import java.util.List;

public abstract class Personaje {
	protected String nombre;
	protected int maxPuntosVida;
	protected int puntosVida;
	protected int puntosMagia;
	protected List<Hechizo> listaHechizos;
	
	abstract public void lanzarAtaque(Personaje otro);
	
	abstract public void lanzarDefensa(Personaje otro);
}
