package juego.motor.personaje;

import juego.motor.hechizo.Hechizo;

public class EstadoDerrotado extends EfectoEstado{
	public EstadoDerrotado(Personaje personaje) {
		super(personaje);
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
	}
	
	
	public void recibirDaño(double cantidad) {
	}
	
	public void curarse(double cantidad) {
	}
}
