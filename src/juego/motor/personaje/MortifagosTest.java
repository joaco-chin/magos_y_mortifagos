package juego.motor.personaje;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import juego.motor.batalla.Batallon;
import juego.motor.batalla.GestorBatalla;
import juego.motor.batalla.LogBatalla;
import juego.motor.hechizo.Hechizo;

public class MortifagosTest {

    private GestorBatalla batallaDummy;
    private List<Hechizo> hechizosPrueba;

    @BeforeEach
    public void setUp() {
        // Configuramos el entorno mínimo de batalla para los constructores
        Batallon magosDummy = new Batallon();
        Batallon mortifagosDummy = new Batallon();
        LogBatalla logDummy = new LogBatalla();
        batallaDummy = new GestorBatalla(magosDummy, mortifagosDummy, logDummy);

        // Inicializamos una lista simulada de hechizos oscuros
        hechizosPrueba = new ArrayList<>();
    }

    @Test
    public void testConstructorComandanteAsignaAtributosCorrectamente() {
        // Configuración de parámetros de prueba
        String nombre = "Bellatrix";
        int nivelMagia = 7;
        double maxVida = 180.0;

        // Ejecución
        Comandante comandante = new Comandante(nombre, batallaDummy, hechizosPrueba, nivelMagia, maxVida);

        // Verificaciones
        assertEquals(nombre, comandante.getNombre(), "El nombre del Comandante no coincide.");
        assertEquals(nivelMagia, comandante.nivelMagia, "El nivel de magia del Comandante no se asignó correctamente.");
        assertEquals(maxVida, comandante.maxPuntosVida, "El máximo de puntos de vida del Comandante no coincide.");
        assertEquals(maxVida, comandante.getPuntosVida(), "La vida actual del Comandante debería iniciar al máximo (puntosVida = maxPuntosVida).");
        assertSame(hechizosPrueba, comandante.getHechizosConocidos(), "La lista de hechizos conocidos debe ser la misma referencia provista.");
    }

    @Test
    public void testConstructorSeguidorComunAsignaAtributosCorrectamente() {
        // Configuración de parámetros de prueba
        String nombre = "Crabbe";
        int nivelMagia = 2;
        double maxVida = 90.0;

        // Ejecución
        SeguidorComun seguidor = new SeguidorComun(nombre, batallaDummy, hechizosPrueba, nivelMagia, maxVida);

        // Verificaciones
        assertEquals(nombre, seguidor.getNombre(), "El nombre del SeguidorComun no coincide.");
        assertEquals(nivelMagia, seguidor.nivelMagia, "El nivel de magia del SeguidorComun es incorrecto.");
        assertEquals(maxVida, seguidor.maxPuntosVida, "El tope de puntos de vida del SeguidorComun no coincide.");
        assertEquals(maxVida, seguidor.getPuntosVida(), "La vida actual del SeguidorComun debe iniciar al máximo.");
        assertSame(hechizosPrueba, seguidor.getHechizosConocidos(), "La lista de hechizos conocidos no se vinculó correctamente.");
    }
}
