package juego.motor.hechizo;

import juego.motor.personaje.Personaje;

public class Expelliarmus implements Hechizo {
	private double puntosDaño;
	
	public Expelliarmus(double nivel) {
		this.puntosDaño = 50 * nivel;
	}
	
	@Override
	public void ejecutar(Personaje enemigo) {
		enemigo.recibirDaño(puntosDaño);
	}
	
}