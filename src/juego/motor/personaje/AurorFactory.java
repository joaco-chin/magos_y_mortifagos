package juego.motor.personaje;

import java.util.LinkedList;
import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.config.ConfigPersonajes;
import juego.motor.hechizo.Hechizo;
import juego.motor.hechizo.HechizoFactory;

public class AurorFactory implements MagoFactory{
	public Mago crearMago(String nombre, GestorBatalla batalla) {
		List<Hechizo> hechizosConocidos = new LinkedList<>();
		
		for(String nombreHechizo : ConfigPersonajes.AUROR_HECHIZOS) {
			Hechizo nuevoHechizo = HechizoFactory.crearHechizo(nombreHechizo, 
					ConfigPersonajes.AUROR_NIVEL_MAGIA);
			hechizosConocidos.add(nuevoHechizo);
		}
		
		return new Auror(nombre, 
				batalla, hechizosConocidos, 
				ConfigPersonajes.AUROR_NIVEL_MAGIA, 
				ConfigPersonajes.AUROR_MAX_VIDA);
	}
}
