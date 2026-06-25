package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;
//import juego.motor.hechizo.HechizoFactory;

public abstract class Mago extends Personaje{
	
	public Mago(String nombre, GestorBatalla batalla) {
		super(nombre, batalla);
	}
}
