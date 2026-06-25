package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class SeguidorComunFactory implements MortifagoFactory{
	
	public Mortifago crearMortifago(String nombre, GestorBatalla batalla) {
		return new SeguidorComun(nombre, batalla);
	}
}
