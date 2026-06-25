package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public interface MagoFactory {
	public Mago crearMago(GestorBatalla batalla);
}
