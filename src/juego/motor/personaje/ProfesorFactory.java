package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class ProfesorFactory implements MagoFactory{
	public Mago crearMago(String nombre, GestorBatalla batalla) {
		return new Profesor(nombre, batalla);
	}
	
}
