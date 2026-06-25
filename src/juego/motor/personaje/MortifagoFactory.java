package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;

public interface MortifagoFactory {
	public Mortifago crearMortifago(String nombre, GestorBatalla batalla, List<Hechizo> hechizosConocidos);
}
