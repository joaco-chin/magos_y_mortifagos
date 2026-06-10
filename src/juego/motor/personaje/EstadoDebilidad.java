package juego.motor.personaje;

public class EstadoDebilidad extends EstadoNormal implements EfectosDurables{
	
	public static final int FACTOR_AUMENTO_DMG = 2;
	public static final double FACTOR_DECREMENTO_MAGIA = 0.1;	// 10%
	private final double aumento;
	
	public EstadoDebilidad(Personaje personaje) {
		super(personaje);
		this.aumento = EstadoDebilidad.FACTOR_AUMENTO_DMG 
				+ personaje.nivelMagia * EstadoDebilidad.FACTOR_DECREMENTO_MAGIA;
		this.duracionTurnos = EfectoEstado.DURACION_BASE_TURNOS;
	}
	
	@Override
	public void recibirDaño(double cantidad) {
		super.recibirDaño(cantidad * this.aumento);
	}
}
