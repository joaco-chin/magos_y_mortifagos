package juego.motor.personaje;

public enum ClasesMagos {
	ESTUDIANTE("Estudiante"){
		@Override
		public MagoFactory getFactory() {
			return new EstudianteFactory();
		}
	},
	PROFESOR("Profesor"){
		@Override
		public MagoFactory getFactory() {
			return new ProfesorFactory();
		}
	},
	AUROR("Auror"){
		@Override
		public MagoFactory getFactory() {
			return new AurorFactory();
		}
	};
	
	private final String nombreClase;
	
	private ClasesMagos(final String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	public String getNombre() {
		return this.nombreClase;
	}
	
	public abstract MagoFactory getFactory();
}
