package juego.motor.personaje;

public class PiedraFilosofal {
	
	public PiedraFilosofal (Personaje p) {
		
	}
	
    public void usar(Personaje usuario, Personaje aliadoCaido) {
        if (usuario.esDelMismoBando(aliadoCaido) && aliadoCaido.getPuntosVida() <= 0) {
            System.out.println("¡" + usuario.getNombre() + " usa la Piedra Filosofal!");
            aliadoCaido.curarse(aliadoCaido.maxPuntosVida * 0.5);
            aliadoCaido.getBando().reincorporar(aliadoCaido);
        }
    }
}