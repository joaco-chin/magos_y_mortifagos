package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;

public class ProfesorFactory implements MagoFactory{
	public Mago crearMago(String nombre, GestorBatalla batalla, List<Hechizo> hechizosConocidos) {
		return new Profesor(nombre, batalla, hechizosConocidos);
	}
}
