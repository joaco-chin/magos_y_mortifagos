package juego.motor.personaje;

import java.util.LinkedList;
import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;
import juego.motor.hechizo.HechizoFactory;
import juego.motor.config.ConfigPersonajes;

public class EstudianteFactory implements MagoFactory{
	public Mago crearMago(String nombre, GestorBatalla batalla) {
		List<Hechizo> hechizosConocidos = new LinkedList<>();
		
		for(String nombreHechizo : ConfigPersonajes.ESTUDIANTE_HECHIZOS) {
			Hechizo nuevoHechizo = HechizoFactory.crearHechizo(nombreHechizo, 
					ConfigPersonajes.ESTUDIANTE_NIVEL_MAGIA);
			hechizosConocidos.add(nuevoHechizo);
		}
		
		return new Estudiante(nombre, 
				batalla, hechizosConocidos, 
				ConfigPersonajes.ESTUDIANTE_NIVEL_MAGIA, 
				ConfigPersonajes.ESTUDIANTE_MAX_VIDA);
	}
}
