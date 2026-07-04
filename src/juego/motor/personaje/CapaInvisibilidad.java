package juego.motor.personaje;

public class CapaInvisibilidad extends ObjetoMagico {
    
    public CapaInvisibilidad(Personaje p) {
        super(p);
    }

    @Override
    public void recibirDaño(double cantidad) {
        if (Math.random() < 0.5) { 
            System.out.println(getNombre() + " esquivó el ataque gracias a su capa!");
        } else {
            super.recibirDaño(cantidad);
        }
    }
}