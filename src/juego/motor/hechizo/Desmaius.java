package juego.motor.hechizo;

import juego.motor.personaje.Personaje;
import juego.motor.personaje.EstadoDebilidad;

public class Desmaius implements Hechizo {	
	
	@Override
	public void ejecutar(Personaje personaje) {
		personaje.cambiarEstado(new EstadoDebilidad(personaje));
	}
	
}