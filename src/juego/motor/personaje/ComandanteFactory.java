package juego.motor.personaje;

import java.util.LinkedList;
import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.config.ConfigPersonajes;
import juego.motor.hechizo.Hechizo;
import juego.motor.hechizo.HechizoFactory;

public class ComandanteFactory implements MortifagoFactory{

	public Mortifago crearMortifago(String nombre, GestorBatalla batalla) {
		List<Hechizo> hechizosConocidos = new LinkedList<>();
		
		for(String nombreHechizo : ConfigPersonajes.COMANDANTE_HECHIZOS) {
			Hechizo nuevoHechizo = HechizoFactory.crearHechizo(nombreHechizo, 
					ConfigPersonajes.COMANDANTE_NIVEL_MAGIA);
			hechizosConocidos.add(nuevoHechizo);
		}
		
		return new Comandante(nombre, 
				batalla, hechizosConocidos, 
				ConfigPersonajes.COMANDANTE_NIVEL_MAGIA, 
				ConfigPersonajes.COMANDANTE_MAX_VIDA);
	}
	
}
