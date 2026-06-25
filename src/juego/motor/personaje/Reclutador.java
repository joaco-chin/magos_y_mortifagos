package juego.motor.personaje;

import java.util.LinkedList;
import java.util.List;

import juego.motor.batalla.GestorBatalla;
import juego.motor.config.ConfigPersonajes;
import juego.motor.hechizo.*;

public class Reclutador {
	MortifagoFactory creadorMortifago;
	
	public static Mago crearMago(String clase, GestorBatalla batalla) {
		MagoFactory creadorMago;
		
		if(clase == "Estudiante") {
			creadorMago = new EstudianteFactory();
		}
		
		else if(clase == "Profesor") {
			creadorMago = new ProfesorFactory();
		}
		else if(clase == "Auror") {
			creadorMago = new AurorFactory();
		}
		
		return creadorMago.crearMago(batalla);
	}
}
