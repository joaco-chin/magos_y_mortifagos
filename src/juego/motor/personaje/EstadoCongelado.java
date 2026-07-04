package juego.motor.personaje;

import juego.motor.hechizo.Hechizo;

public class EstadoCongelado extends EfectoDurable{

	public EstadoCongelado(Personaje personaje) {
		super(personaje);
		this.duracionTurnos = EfectoDurable.DURACION_BASE_TURNOS + 1;
	}
	
	@Override
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
		// al estar congelado, el personaje no puede lanzar hechizos
	}
	
}
