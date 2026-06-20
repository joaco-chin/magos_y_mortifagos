package juego.motor.hechizo;

import juego.motor.personaje.Personaje;
import juego.motor.personaje.EstadoCongelado;

public class PetrificusTotalus implements Hechizo {	
	
	@Override
	public void ejecutar(Personaje personaje) {
		personaje.cambiarEstado(new EstadoCongelado(personaje));
	}
	
}