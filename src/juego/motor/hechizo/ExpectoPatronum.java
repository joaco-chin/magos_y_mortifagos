package juego.motor.hechizo;

import juego.motor.personaje.Personaje;
import juego.motor.personaje.EstadoCongelado;

public class ExpectoPatronum implements Hechizo {	
	public void ejecutar(Personaje personaje) {
		personaje.cambiarEstado(new EstadoCongelado(personaje));
	}
	
}