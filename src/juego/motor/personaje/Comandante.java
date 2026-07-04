package juego.motor.personaje;

import java.util.List;

import juego.motor.batalla.*;
import juego.motor.hechizo.Hechizo;

public class Comandante extends Mortifago implements BatallaObserver{
	
	private boolean furia;
	
	public Comandante(String nombre, GestorBatalla batalla, List<Hechizo> hechizosConocidos,
			int nivelMagia, double maxPuntosVida) {
		super(nombre, batalla);
		this.hechizosConocidos = hechizosConocidos;
		this.nivelMagia = nivelMagia;
		this.maxPuntosVida = maxPuntosVida;
		this.puntosVida = this.maxPuntosVida;
		this.furia = false;
		batalla.agregarObserver(this);
	}
	
	@Override
    public void onPersonajeDerrotado(Personaje p) {
        if (this.esDelMismoBando(p) && p != this && this.getPuntosVida() > 0) {
            System.out.println(this.nombre + " entra en modo Furia al ver caer a un aliado!!!");
            this.furia = true;
        }
    }

	@Override
	public void onHechizoLanzado(Personaje lanzador, Hechizo hechizo, Personaje objetivo) {
	}
	
	@Override
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
	    super.lanzarHechizo(hechizo, objetivo);
	    if (this.furia) {
	        System.out.println(this.nombre + " descarga su Furia acumulada!");
	        objetivo.recibirDaño(40);
	        this.furia = false;
	    }
	}
	
}
