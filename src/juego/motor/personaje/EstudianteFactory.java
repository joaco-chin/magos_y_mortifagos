package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class EstudianteFactory implements MagoFactory{
	public Mago crearMago(String nombre, GestorBatalla batalla) {
		return new Estudiante(nombre, batalla);
	}
}
