package juego.motor.personaje;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juego.motor.batalla.Batallon;
import juego.motor.batalla.GestorBatalla;
import juego.motor.batalla.LogBatalla;
import juego.motor.hechizo.Hechizo;
import juego.motor.hechizo.HechizoFactory;

class EfectoDurableTest {
	
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
	public void petrificusTotalusCambiaElEstadoDelObjetivoACongelado() {
		comandante.getHechizosConocidos().clear();
        Hechizo hechizo = HechizoFactory.crearHechizo("PetrificusTotalus", 1.0);
        comandante.getHechizosConocidos().add(hechizo);
        
        comandante.estado.lanzarHechizo(hechizo, estudiante);

        assertEquals(EstadoCongelado.class, estudiante.estado.getClass(),
    			"Al recibir un Petrificus Totalus, el personaje debe quedar congelado.");
	}
    
    @Test
    public void lanzarHechizoEnEstadoCongelado() {
    	comandante.getHechizosConocidos().clear();
        Hechizo petrificus = HechizoFactory.crearHechizo("PetrificusTotalus", 1.0);
        comandante.getHechizosConocidos().add(petrificus);

        estudiante.getHechizosConocidos().clear();
        Hechizo expelliarmus = HechizoFactory.crearHechizo("Expelliarmus", 1.0);
        estudiante.getHechizosConocidos().add(expelliarmus);
        
        comandante.estado.lanzarHechizo(petrificus, estudiante);
        
        double vidaInicialObjetivo = comandante.getPuntosVida();

        estudiante.estado.lanzarHechizo(expelliarmus, comandante);

        assertEquals(vidaInicialObjetivo, comandante.getPuntosVida(),
            "El hechizo no debió hacer daño porque el lanzador se encuentra congelado.");
	}
    
    @Test
    public void avadaKedavraCambiaElEstadoDelObjetivoAEstadoVeneno() {
        comandante.getHechizosConocidos().clear();
        Hechizo avada = HechizoFactory.crearHechizo("AvadaKedavra", 1.0);
        comandante.getHechizosConocidos().add(avada);
        
        comandante.estado.lanzarHechizo(avada, estudiante);

        assertEquals(EstadoVeneno.class, estudiante.estado.getClass(),
            "Al recibir Avada Kedavra, el personaje debe quedar en EstadoVeneno.");
    }
    
    @Test
    public void actualizarEnEstadoVeneno() {
        estudiante.cambiarEstado(new EstadoVeneno(estudiante));
        double vidaInicial = estudiante.getPuntosVida();
        
        ((EfectoDurable) estudiante.estado).actualizar();

        assertEquals(vidaInicial - 4.0, estudiante.getPuntosVida(),
            "El veneno debió restar 4 puntos de vida de forma automática al actualizar el turno.");
    }
    
    @Test
    public void desmaiusCambiaElEstadoDelObjetivoAEstadoDebilidad() {
        comandante.getHechizosConocidos().clear();
        Hechizo desmaius = HechizoFactory.crearHechizo("Desmaius", 1.0);
        comandante.getHechizosConocidos().add(desmaius);
        
        comandante.estado.lanzarHechizo(desmaius, estudiante);

        assertEquals(EstadoDebilidad.class, estudiante.estado.getClass(),
            "Al recibir un Desmaius, el personaje debe quedar en EstadoDebilidad.");
    }
    
    @Test
    public void recibirDañoEnEstadoDebilidadAumentaElDañoRecibido() {
        estudiante.cambiarEstado(new EstadoDebilidad(estudiante));
        double vidaInicial = estudiante.getPuntosVida();
        
        double dañoBase = 10.0; 
        double dañoEsperado = dañoBase * 2.1; 

        estudiante.estado.recibirDaño(dañoBase);

        assertEquals(vidaInicial - dañoEsperado, estudiante.getPuntosVida(),
            "El daño recibido debió multiplicarse por el factor de debilidad (2.1).");
    }
    
    @Test
    public void protegoCambiaElEstadoDelObjetivoAEstadoResistencia() {
        comandante.getHechizosConocidos().clear();
        Hechizo protego = HechizoFactory.crearHechizo("Protego", 1.0);
        comandante.getHechizosConocidos().add(protego);
        
        comandante.estado.lanzarHechizo(protego, estudiante);

        assertEquals(EstadoResistencia.class, estudiante.estado.getClass(),
            "Al recibir un Protego, el personaje debe quedar en EstadoResistencia.");
    }
    
    @Test
    public void recibirDañoEnEstadoResistenciaReduceElDañoRecibido() {
        estudiante.cambiarEstado(new EstadoResistencia(estudiante));
        double vidaInicial = estudiante.getPuntosVida();
        
        double dañoBase = 21.0; 
        double dañoMitigadoEsperado = 10.0; 

        estudiante.estado.recibirDaño(dañoBase);

        assertEquals(vidaInicial - dañoMitigadoEsperado, estudiante.getPuntosVida(),
            "El daño recibido debió dividirse por el factor de resistencia (2.1).");
    }

}
