package juego.motor.hechizo;

import juego.motor.personaje.Personaje;
import juego.motor.personaje.EstadoCongelado;

public class ExpectoPatronum implements Hechizo {
	
	private double curacion;
	
	public ExpectoPatronum(double nivel) {
		this.curacion = 30 * nivel;
	}
	
	@Override
	public void ejecutar(Personaje personaje) {
		personaje.curarse(curacion);;
	}
	
}