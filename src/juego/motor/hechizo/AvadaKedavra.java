package juego.motor.hechizo;

import juego.motor.personaje.Personaje;
import juego.motor.personaje.EstadoVeneno;

public class AvadaKedavra implements Hechizo {	
	public void ejecutar(Personaje personaje) {
		personaje.cambiarEstado(new EstadoVeneno(personaje));
	}
	
}