package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class Profesor extends Mago{

	public Profesor(GestorBatalla batalla) {
		super(batalla);
//		this.hechizosConocidos.add(new crearHechizo("Protego"));
	}

	@Override
	protected void notificarDerrota() {
		// TODO Auto-generated method stub
	}

}
