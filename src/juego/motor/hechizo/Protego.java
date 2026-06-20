package juego.motor.hechizo;

import juego.motor.personaje.Personaje;
import juego.motor.personaje.EstadoResistencia;

public class Protego implements Hechizo {	
	public void ejecutar(Personaje personaje) {
		personaje.cambiarEstado(new EstadoResistencia(personaje));
	}
	
}