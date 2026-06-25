package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class SeguidorComun extends Mortifago{

	public SeguidorComun(String nombre, GestorBatalla batalla) {
		super(nombre, batalla);
	}

	@Override
	protected void notificarDerrota() {
		// TODO Auto-generated method stub
	}
}
