package juego.motor.personaje;

public enum ClasesMortifagos {
	SEGUIDOR_COMUN("SeguidorComun"){
		@Override
		public MortifagoFactory getFactory() {
			return new SeguidorComunFactory();
		}
	},
	COMANDANTE("Comandante"){
		@Override
		public MortifagoFactory getFactory() {
			return new ComandanteFactory();
		}
	};
	
	private final String nombreClase;
	
	private ClasesMortifagos(final String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	public String getNombre() {
		return this.nombreClase;
	}
	
	public abstract MortifagoFactory getFactory();
}
