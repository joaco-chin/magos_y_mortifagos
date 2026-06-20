package juego.motor.hechizo;

public class HechizoFactory {
	public Hechizo crearHechizo(String tipo) {
		
		if(tipo.equals("Expelliarmus")) {
			return new Expelliarmus();
		}
		else if(tipo.equals("Protego")) {
			return new Protego();
		}
		else if(tipo.equals("AvadaKedavra")) {
			return new AvadaKedavra();
		}
		else {
			return new ExpectoPatronum();
		}
	}
}
