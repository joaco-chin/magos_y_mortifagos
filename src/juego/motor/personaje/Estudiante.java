package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class Estudiante extends Mago{

	public Estudiante(GestorBatalla batalla) {
		super(batalla);
	}

	@Override
	protected void notificarDerrota() {
		
	}
}
