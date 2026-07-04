package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public interface MagoFactory {
	public Mago crearMago(String nombre, GestorBatalla batalla);
}
