package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class ComandanteFactory implements MortifagoFactory{

	public Mortifago crearMortifago(String nombre, GestorBatalla batalla) {
		return new Comandante(nombre, batalla);
	}
	
}
