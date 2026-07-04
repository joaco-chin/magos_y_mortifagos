package juego.motor.personaje;

public abstract class EfectoDurable extends EstadoNormal{
	public static final int DURACION_BASE_TURNOS = 1;
	protected int duracionTurnos;
	
	public EfectoDurable(Personaje personaje) {
		super(personaje);
	}
	
	public void actualizar() {
		this.duracionTurnos--;
		if(this.duracionTurnos == 0) {
			this.personaje.cambiarEstado(new EstadoNormal(this.personaje));
		}
	}
}