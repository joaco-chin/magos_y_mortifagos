package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;

public class Auror extends Mago{

	public Auror(String nombre, GestorBatalla batalla, List<Hechizo> hechizosConocidos,
			int nivelMagia, double maxPuntosVida) {
		super(nombre, batalla);
		this.hechizosConocidos = hechizosConocidos;
		this.nivelMagia = nivelMagia;
		this.maxPuntosVida = maxPuntosVida;
		this.puntosVida = this.maxPuntosVida;
	}
	
}
