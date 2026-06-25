package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class Auror extends Mago{

	public Auror(String nombre, GestorBatalla batalla) {
		super(nombre, batalla);
	}

	@Override
	protected void notificarDerrota() {
		// TODO Auto-generated method stub
	}
	
}
