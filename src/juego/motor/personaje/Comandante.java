package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class Comandante extends Mortifago{
	
	public Comandante(String nombre, GestorBatalla batalla) {
		super(nombre, batalla);
	}

	@Override
	protected void notificarDerrota() {
		
	}

}
