package juego.motor.personaje;

import juego.motor.batalla.GestorBatalla;

public class Reclutador {
	
	public static Mago crearMago(String tipo, GestorBatalla batalla) 
			throws IllegalArgumentException{
		MagoFactory creadorMago;
		creadorMago = ClasesMagos.valueOf(tipo.toUpperCase().trim()).getFactory();
		return creadorMago.crearMago(batalla);
	}
	
	public static Mortifago crearMortifago(String tipo, GestorBatalla batalla) 
			throws IllegalArgumentException{
		MortifagoFactory creadorMortifago;
		creadorMortifago = ClasesMortifagos.valueOf(tipo.toUpperCase().trim()).getFactory();
		return creadorMortifago.crearMortifago(batalla);
	}
	
}
