package juego.motor.personaje;

import juego.motor.hechizo.Hechizo;
import juego.motor.item.Item;

public abstract class EfectoEstado {
	protected Personaje personaje;
	
	public EfectoEstado(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public abstract void lanzarHechizo(Hechizo hechizo, Personaje objetivo);
	
	public abstract void usarItem(Item item, Personaje objetivo);
	
	public abstract void recibirDaño(double cantidad);
	
	public abstract void curarse(double cantidad);
	
	public void actualizar() {};
}
