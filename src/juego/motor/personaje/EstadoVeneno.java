package juego.motor.personaje;

public class EstadoVeneno extends EstadoNormal implements EfectosDurables{
	public static final double DMG_BASE_VENENO = 4;
	private final double dmg_veneno;
	
	public EstadoVeneno(Personaje personaje) {
		super(personaje);
		this.duracionTurnos = EfectoEstado.DURACION_BASE_TURNOS + personaje.nivelMagia;
		this.dmg_veneno = EstadoVeneno.DMG_BASE_VENENO * personaje.nivelMagia;
	}
	
	public void actualizar() {
		this.recibirDaño(this.dmg_veneno);
		super.actualizar();
	}
}
