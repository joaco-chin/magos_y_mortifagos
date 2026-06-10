package juego.motor.personaje;

import juego.motor.hechizo.Hechizo;
import juego.motor.item.Item;

public class EstadoDerrotado extends EfectoEstado{	// Revisar
	public EstadoDerrotado(Personaje personaje) {
		super(personaje);
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
	}
	
	public void usarItem(Item item, Personaje objetivo) {
	}
	
	public void recibirDaño(double cantidad) {
	}
	
	public void curarse(double cantidad) {
	}
}
