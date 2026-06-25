package juego.motor.config;

import java.util.Map;

public abstract class ConfigBatallon {
	public static final Map<String, Integer> BATALLON_MAGOS_PERSONAJES = 
	Map.of("Estudiante", 3, "Profesor", 1, "Auror", 1);
	
	public static final Map<String, Integer> BATALLON_MORTIFAGOS_PERSONAJES = 
	Map.of("SeguidorComun", 3, "Comandante", 2);
}
