package juego.motor.personaje;

public class EstadoResistencia extends EfectoDurable{

	public static final int FACTOR_REDUCCION_DMG = 2;
	public static final double FACTOR_DECREMENTO_MAGIA = 0.1;	// 10%
	private final double reduccion;
	
	public EstadoResistencia(Personaje personaje) {
		super(personaje);
		this.reduccion = EstadoResistencia.FACTOR_REDUCCION_DMG 
				+ personaje.nivelMagia * EstadoResistencia.FACTOR_DECREMENTO_MAGIA;
		this.duracionTurnos = EfectoDurable.DURACION_BASE_TURNOS;
	}
	
	@Override
	public void recibirDaño(double cantidad) {	// Completo
		super.recibirDaño(cantidad / reduccion);
	}
}
