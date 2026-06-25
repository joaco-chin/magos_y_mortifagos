package juego.motor.hechizo;

public abstract class HechizoFactory {
	public static Hechizo crearHechizo(String tipo, double nivel) {
		
		if(tipo.equals("Expelliarmus")) {
			return new Expelliarmus(nivel);
		}
		else if(tipo.equals("Protego")) {
			return new Protego();
		}
		else if(tipo.equals("AvadaKedavra")) {
			return new AvadaKedavra();
		}
		else if(tipo.equals("Desmaius")) {
			return new Desmaius();
		}
		else if(tipo.equals("PetrificusTotalus")) {
			return new PetrificusTotalus();
		}
		else {
			return new ExpectoPatronum(nivel);
		}
	}
}
