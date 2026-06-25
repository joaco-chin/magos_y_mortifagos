package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class Estudiante extends Mago{
	public static final int NIVEL_MAGIA_ESTUDIANTE = 1;
	public static final double MAX_VIDA_ESTUDIANTE = 95.5;
	
	public Estudiante(String nombre, GestorBatalla batalla) {
		super(nombre, batalla);
		this.nivelMagia = NIVEL_MAGIA_ESTUDIANTE;
		this.maxPuntosVida = MAX_VIDA_ESTUDIANTE;
		this.puntosVida = this.maxPuntosVida; // El personaje comienza con la vida llena
	}

	@Override
	protected void notificarDerrota() {
		
	}
}
