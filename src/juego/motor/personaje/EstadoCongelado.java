package juego.motor.personaje;

import juego.motor.hechizo.Hechizo;
import juego.motor.item.Item;

public class EstadoCongelado extends EfectoDurable{

	public EstadoCongelado(Personaje personaje) {
		super(personaje);
		this.duracionTurnos = EfectoDurable.DURACION_BASE_TURNOS;
	}
	
	@Override
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
		// al estar congelado, el personaje no puede lanzar hechizos
	}
	
	@Override
	public void usarItem(Item item, Personaje objetivo) {
		// al estar congelado, el personaje no puede utilizar items
	}
}
