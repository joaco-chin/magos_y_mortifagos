package juego.motor.personaje;

import java.util.LinkedList;
import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.config.ConfigPersonajes;
import juego.motor.hechizo.Hechizo;
import juego.motor.hechizo.HechizoFactory;

public class ProfesorFactory implements MagoFactory{
	public Mago crearMago(String nombre, GestorBatalla batalla) {
		List<Hechizo> hechizosConocidos = new LinkedList<>();
		
		for(String nombreHechizo : ConfigPersonajes.PROFESOR_HECHIZOS) {
			Hechizo nuevoHechizo = HechizoFactory.crearHechizo(nombreHechizo, 
					ConfigPersonajes.PROFESOR_NIVEL_MAGIA);
			hechizosConocidos.add(nuevoHechizo);
		}
		
		return new Profesor(nombre, 
				batalla, hechizosConocidos, 
				ConfigPersonajes.PROFESOR_NIVEL_MAGIA, 
				ConfigPersonajes.PROFESOR_MAX_VIDA);
	}
}
