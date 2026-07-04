package juego.motor.personaje;
import juego.motor.hechizo.Hechizo;

public class EstadoNormal extends EfectoEstado{
	
	public EstadoNormal(Personaje personaje) {
		super(personaje);
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo){
		if(this.personaje.hechizosConocidos.contains(hechizo)) {
			hechizo.ejecutar(objetivo);
		}
	}
	
	public void recibirDaño(double cantidad) {	
		double nuevosPuntosVida = this.personaje.puntosVida - cantidad;
		if(nuevosPuntosVida > Personaje.PUNTOS_DERROTA) {
			this.personaje.puntosVida = nuevosPuntosVida;
		} else {
			this.personaje.puntosVida = Personaje.PUNTOS_DERROTA;
			this.personaje.cambiarEstado(new EstadoDerrotado(personaje));
		}
	}
	
	public void curarse(double cantidad) {
		double nuevosPuntosVida = this.personaje.puntosVida + cantidad;
		if(nuevosPuntosVida < this.personaje.maxPuntosVida) {
			this.personaje.puntosVida = nuevosPuntosVida;
		} else {
			this.personaje.puntosVida = personaje.maxPuntosVida;
		}
	}
}