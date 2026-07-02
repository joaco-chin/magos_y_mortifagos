package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.BatallaObserver;
import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;
import juego.motor.item.Item;

public abstract class Personaje {
	public static final int PUNTOS_DERROTA = 0;
	
	protected String nombre;
	protected int nivelMagia;
	protected double puntosVida;
	protected double maxPuntosVida;
	protected List<Hechizo> hechizosConocidos;
	protected EfectoEstado estado;
	protected BatallaObserver observer;
	protected final GestorBatalla batalla;
	
	public Personaje(String nombre, GestorBatalla batalla) {
		this.nombre = nombre;
		this.estado = new EstadoNormal(this);
		this.batalla = batalla;
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
		this.estado.lanzarHechizo(hechizo, objetivo);
	}
	
	public void usarItem(Item item, Personaje objetivo) {
		this.estado.usarItem(item, objetivo);
	}
	
	public void recibirDaño(double cantidad) {
		this.estado.recibirDaño(cantidad);
	}
	
	public void curarse(double cantidad) {
		this.estado.curarse(cantidad);
	}
	
	public void cambiarEstado(EfectoEstado estado) {
		this.estado = estado;
	}
	
	public String getNombre() {
		return nombre;
	}

	public List<Hechizo> getHechizosConocidos() {
		return hechizosConocidos;
	}

	public double getPuntosVida() {
		return puntosVida;
	}

	protected abstract void notificarDerrota();
	
	public void aplicarEfectosDeTurno() {
	    if (this.estado != null) {
	        this.estado.actualizar();
	    }
	}
}
