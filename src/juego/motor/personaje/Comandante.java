package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;

public class Comandante extends Mortifago{
	
	public Comandante(String nombre, GestorBatalla batalla, List<Hechizo> hechizosConocidos) {
		super(nombre, batalla);
	}

	@Override
	protected void notificarDerrota() {
		
	}

}
