package juego.motor.personaje;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juego.motor.batalla.Batallon;
import juego.motor.batalla.GestorBatalla;
import juego.motor.batalla.LogBatalla;
import juego.motor.hechizo.Hechizo;
import juego.motor.hechizo.HechizoFactory;

class EfectoEstadoTest {
	
	private GestorBatalla batalla;
    private Personaje estudiante;
    private Personaje comandante;

    @BeforeEach
    public void setUp() {
        Batallon magos = new Batallon();
        Batallon mortifagos = new Batallon();
        LogBatalla log = new LogBatalla();
        batalla = new GestorBatalla(magos, mortifagos, log);

        estudiante = Reclutador.crearMago("Harry", "Estudiante", batalla);
        comandante = Reclutador.crearMortifago("Lucius", "Comandante", batalla);
    }

	@Test
	public void lanzarHechizoEnEstadoNormalCuandoEsConocido() {
		estudiante.getHechizosConocidos().clear();
        Hechizo hechizo = HechizoFactory.crearHechizo("Expelliarmus", 1.0);
        estudiante.getHechizosConocidos().add(hechizo);
        
        double vidaInicialObjetivo = comandante.getPuntosVida();

        estudiante.estado.lanzarHechizo(hechizo, comandante);

        assertTrue(comandante.getPuntosVida() < vidaInicialObjetivo, 
            "El hechizo debió ejecutarse reduciendo la vida del objetivo.");
	}
	
	@Test
	public void LanzarHechizoCuandoNOEsConocido() {
        Hechizo hechizoDesconocido = HechizoFactory.crearHechizo("AvadaKedavra", 1.0);
        
        estudiante.getHechizosConocidos().clear();
        
        double vidaInicialObjetivo = comandante.getPuntosVida();

        estudiante.estado.lanzarHechizo(hechizoDesconocido, comandante);

        assertEquals(vidaInicialObjetivo, comandante.getPuntosVida(), 
            "La vida no debió cambiar porque el personaje no conoce el hechizo.");
	}
	
	@Test
	public void recibirDañoEnEstadoNormal() {
		double vidaInicial = estudiante.getPuntosVida();
		double dañoAAplicar = 1.0;

		estudiante.estado.recibirDaño(dañoAAplicar);

		assertEquals(vidaInicial - dañoAAplicar, estudiante.getPuntosVida()); 				
	}
	
	@Test
	public void recibirDañoMortalEnEstadoNormalCambiaAEstadoDerrotado() {
		double dañoMortal = estudiante.getPuntosVida() + 50.0;

		estudiante.estado.recibirDaño(dañoMortal);

		assertEquals(Personaje.PUNTOS_DERROTA, estudiante.getPuntosVida());
		
		assertEquals(EstadoDerrotado.class, estudiante.estado.getClass(),
			"El personaje debió cambiar su estado a EstadoDerrotado tras recibir daño mortal.");
	}
	
	@Test
	public void curarseEnEstadoNormalCuandoNoSuperaElMaximo() {
		estudiante.estado.recibirDaño(10.0);
		double vidaLuegoDelDaño = estudiante.getPuntosVida();
		double curacionParcial = 5.0; 

		estudiante.estado.curarse(curacionParcial);

		assertEquals(vidaLuegoDelDaño + curacionParcial, estudiante.getPuntosVida(),
			"La vida debió aumentar sumando exactamente la cantidad curada.");
	}
	
	@Test
	public void curarseEnEstadoNormalCuandoExcedeElMaximo() {
		estudiante.estado.recibirDaño(30.0);
		
		double curacionExcesiva = 500.0; 

		estudiante.estado.curarse(curacionExcesiva);

		assertEquals(estudiante.maxPuntosVida, estudiante.getPuntosVida(),
			"La vida debió recuperar su valor máximo sin excederse.");
	}
	
	@Test
	public void lanzarHechizoEnEstadoDerrotado() {
		Hechizo hechizo = HechizoFactory.crearHechizo("Expelliarmus", 1.0);
		estudiante.getHechizosConocidos().clear();
		estudiante.getHechizosConocidos().add(hechizo);
				
		estudiante.recibirDaño(estudiante.getPuntosVida() + 100.0); 
		
		double vidaInicialObjetivo = comandante.getPuntosVida();

		estudiante.estado.lanzarHechizo(hechizo, comandante);

		assertEquals(vidaInicialObjetivo, comandante.getPuntosVida(), 
			"El hechizo no debió ejecutarse porque el lanzador está derrotado.");
	}
	
	@Test
	public void recibirDañoEnEstadoDerrotado() {
		estudiante.recibirDaño(estudiante.getPuntosVida() + 100.0);
		
		double vidaEnDerrota = estudiante.getPuntosVida();

		estudiante.estado.recibirDaño(50.0);

		assertEquals(vidaEnDerrota, estudiante.getPuntosVida(), 
			"La vida no debería cambiar ya que el personaje se encuentra derrotado.");
	}
	
	@Test
	public void curarseEnEstadoDerrotado() {
		estudiante.recibirDaño(estudiante.getPuntosVida() + 100.0);
		double vidaEnDerrota = estudiante.getPuntosVida();

		estudiante.estado.curarse(50.0);

		assertEquals(vidaEnDerrota, estudiante.getPuntosVida(), 
			"El personaje derrotado no debería poder curarse.");
	}

}
