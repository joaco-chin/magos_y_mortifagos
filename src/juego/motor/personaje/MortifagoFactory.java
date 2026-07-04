package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public interface MortifagoFactory {
	public Mortifago crearMortifago(String nombre, GestorBatalla batalla);
}
