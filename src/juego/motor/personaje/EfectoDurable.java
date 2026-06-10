package juego.motor.personaje;

public abstract class EfectoDurable extends EstadoNormal{

	public static final int DURACION_BASE_TURNOS = 1;
	protected int duracionTurnos;
	
	public EfectoDurable(Personaje personaje) {
		super(personaje);
		this.personaje.batalla.agregarObserver(this);
	}
	
	public void actualizar() {
		this.duracionTurnos--;
		if(this.duracionTurnos == 0) {
			this.personaje.batalla.eliminarObserver(this);
			this.personaje.cambiarEstado(new EstadoNormal(this.personaje));
		}
	}
}
