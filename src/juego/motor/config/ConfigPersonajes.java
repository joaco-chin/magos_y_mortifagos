package juego.motor.config;

public abstract class ConfigPersonajes {
	public static final int ESTUDIANTE_NIVEL_MAGIA = 1;
	public static final double ESTUDIANTE_MAX_VIDA = 95.5;
	public static final String[] ESTUDIANTE_HECHIZOS = 
	{"Expelliarmus", "ExpectoPatronum"};
	
	public static final int PROFESOR_NIVEL_MAGIA = 2;
	public static final double PROFESOR_MAX_VIDA = 95.5 * 2;
	public static final String[] PROFESOR_HECHIZOS = 
	{"Protego"};
	
	public static final int AUROR_NIVEL_MAGIA = 3;
	public static final double AUROR_MAX_VIDA = 95.5 * 3;
	public static final String[] AUROR_HECHIZOS = 
	{"PetrificusTotalus"};
	
	public static final int SEGUIDOR_COMUN_NIVEL_MAGIA = 1;
	public static final double SEGUIDOR_COMUN_MAX_VIDA = 95.5;
	public static final String[] SEGUIDOR_COMUN_HECHIZOS = 
	{"Expelliarmus", "Desmaius"};
	
	public static final int COMANDANTE_NIVEL_MAGIA = 2;
	public static final double COMANDANTE_MAX_VIDA = 95.5 * 2;
	public static final String[] COMANDANTE_HECHIZOS = 
	{"AvadaKedavra"};
}
