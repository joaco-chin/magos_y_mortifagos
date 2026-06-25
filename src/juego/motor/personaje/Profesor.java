package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;

public class Profesor extends Mago{
	
	public Profesor(String nombre, GestorBatalla batalla, List<Hechizo> hechizosConocidos) {
		super(nombre, batalla);
		this.hechizosConocidos = hechizosConocidos;
	}

	@Override
	protected void notificarDerrota() {
		// TODO Auto-generated method stub
	}

}
