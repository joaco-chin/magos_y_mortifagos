package juego.motor.personaje;
import juego.motor.batalla.GestorBatalla;

public class Reclutador {
	public static Mago crearMago(String nombre, String tipo, GestorBatalla batalla) throws IllegalArgumentException{
		MagoFactory creadorMago = ClasesMagos.valueOf(tipo.toUpperCase().trim()).getFactory();
		return creadorMago.crearMago(nombre, batalla);
	}
	
	public static Mortifago crearMortifago(String nombre, String tipo, GestorBatalla batalla) throws IllegalArgumentException{
		MortifagoFactory creadorMortifago = ClasesMortifagos.valueOf(tipo.toUpperCase().trim()).getFactory();
		return creadorMortifago.crearMortifago(nombre, batalla);
	}
}