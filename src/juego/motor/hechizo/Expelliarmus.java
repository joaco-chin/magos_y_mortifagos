package juego.motor.hechizo;

import juego.motor.personaje.Personaje;

public class Expelliarmus implements Hechizo {
	private int puntosDaño = 50;
	
	public void ejecutar(Personaje enemigo) {
		enemigo.recibirDaño(puntosDaño);
	}
	
}