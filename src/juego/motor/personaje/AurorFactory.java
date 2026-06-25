package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class AurorFactory implements MagoFactory{
	public Mago crearMago(String nombre, GestorBatalla batalla) {
		return new Auror(nombre, batalla);
	}
}
