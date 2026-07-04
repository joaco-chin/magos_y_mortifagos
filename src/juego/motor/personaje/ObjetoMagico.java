package juego.motor.personaje;

public abstract class ObjetoMagico extends Personaje {
    protected Personaje personajeDecorado;

    public ObjetoMagico(Personaje p) {
        super(p.getNombre(), p.getGestorBatalla()); 
        this.personajeDecorado = p;
    }
    
    @Override
    public void recibirDaño(double cantidad) {
        personajeDecorado.recibirDaño(cantidad);
    }
}