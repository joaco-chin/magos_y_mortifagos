package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;

public class SeguidorComunFactory implements MortifagoFactory{
	
	public Mortifago crearMortifago(String nombre, GestorBatalla batalla, List<Hechizo> hechizosConocidos) {
		return new SeguidorComun(nombre, batalla, hechizosConocidos);
	}
}
