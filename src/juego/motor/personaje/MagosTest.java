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

public class MagosTest {

    private GestorBatalla batallaDummy;
    private List<Hechizo> hechizosPrueba;

    @BeforeEach
    public void setUp() {
        // Configuramos el entorno mínimo de batalla para los constructores
        Batallon magosDummy = new Batallon();
        Batallon mortifagosDummy = new Batallon();
        LogBatalla logDummy = new LogBatalla();
        batallaDummy = new GestorBatalla(magosDummy, mortifagosDummy, logDummy);

        // Inicializamos una lista simulada de hechizos (puede estar vacía para el test de asignación)
        hechizosPrueba = new ArrayList<>();
    }

    @Test
    public void testConstructorAurorAsignaAtributosCorrectamente() {
        // Configuración de parámetros de prueba
        String nombre = "Harry";
        int nivelMagia = 5;
        double maxVida = 150.0;

        // Ejecución
        Auror auror = new Auror(nombre, batallaDummy, hechizosPrueba, nivelMagia, maxVida);

        // Verificaciones
        assertEquals(nombre, auror.getNombre(), "El nombre del Auror no coincide.");
        assertEquals(nivelMagia, auror.nivelMagia, "El nivel de magia no se asignó correctamente.");
        assertEquals(maxVida, auror.maxPuntosVida, "El máximo de puntos de vida no coincide.");
        assertEquals(maxVida, auror.getPuntosVida(), "La vida actual del Auror debería iniciar al máximo (puntosVida = maxPuntosVida).");
        assertSame(hechizosPrueba, auror.getHechizosConocidos(), "La lista de hechizos conocidos debe ser la misma referencia provista.");
    }

    @Test
    public void testConstructorEstudianteAsignaAtributosCorrectamente() {
        String nombre = "Neville";
        int nivelMagia = 2;
        double maxVida = 100.0;

        // Ejecución
        Estudiante estudiante = new Estudiante(nombre, batallaDummy, hechizosPrueba, nivelMagia, maxVida);

        // Verificaciones
        assertEquals(nombre, estudiante.getNombre(), "El nombre del Estudiante no coincide.");
        assertEquals(nivelMagia, estudiante.nivelMagia, "El nivel de magia del Estudiante es incorrecto.");
        assertEquals(maxVida, estudiante.maxPuntosVida, "El tope de puntos de vida no coincide.");
        assertEquals(maxVida, estudiante.getPuntosVida(), "La vida actual del Estudiante debe iniciar llena.");
        assertSame(hechizosPrueba, estudiante.getHechizosConocidos(), "La lista de hechizos conocidos no se vinculó correctamente.");
    }

    @Test
    public void testConstructorProfesorAsignaAtributosCorrectamente() {
        String nombre = "Snape";
        int nivelMagia = 8;
        double maxVida = 200.0;

        // Ejecución
        Profesor profesor = new Profesor(nombre, batallaDummy, hechizosPrueba, nivelMagia, maxVida);

        // Verificaciones
        assertEquals(nombre, profesor.getNombre(), "El nombre del Profesor no coincide.");
        assertEquals(nivelMagia, profesor.nivelMagia, "El nivel de magia del Profesor es incorrecto.");
        assertEquals(maxVida, profesor.maxPuntosVida, "Los puntos de vida máximos no coinciden.");
        assertEquals(maxVida, profesor.getPuntosVida(), "La vida actual del Profesor debe iniciar llena.");
        assertSame(hechizosPrueba, profesor.getHechizosConocidos(), "La lista de hechizos conocidos no se vinculó.");
    }
}
