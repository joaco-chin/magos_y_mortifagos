package juego.motor.personaje;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juego.motor.batalla.Batallon;
import juego.motor.batalla.GestorBatalla;
import juego.motor.batalla.LogBatalla;

public class PersonajesTest {

    private GestorBatalla batallaDummy;

    @BeforeEach
    public void setUp() {
        // Configuramos el entorno mínimo de batalla que requieren los constructores
        Batallon magosDummy = new Batallon();
        Batallon mortifagosDummy = new Batallon();
        LogBatalla logDummy = new LogBatalla();
        batallaDummy = new GestorBatalla(magosDummy, mortifagosDummy, logDummy);
    }

    // =========================================================================
    // TESTS PARA RECLUTADOR (Casos de Éxito)
    // =========================================================================

    @Test
    public void testReclutadorCreaMagoCorrectamente() {
        // Ejecución: Probamos enviando minúsculas y espacios para validar el .toUpperCase().trim()
        Mago magoReclutado = Reclutador.crearMago("  auror  ", batallaDummy);

        // Verificaciones
        assertNotNull(magoReclutado, "El mago reclutado no debería ser null.");
        // Nota: Ajusta "Auror" por el nombre exacto que asigne tu factoría por defecto si falla
        assertNotNull(magoReclutado.getNombre(), "El mago debería tener un nombre asignado por su factoría.");
    }

    @Test
    public void testReclutadorCreaMortifagoCorrectamente() {
        // Ejecución
        Mortifago mortifagoReclutado = Reclutador.crearMortifago("comandante", batallaDummy);

        // Verificaciones
        assertNotNull(mortifagoReclutado, "El mortífago reclutado no debería ser null.");
        assertNotNull(mortifagoReclutado.getNombre(), "El mortífago debería tener un nombre asignado por su factoría.");
    }

    // =========================================================================
    // TESTS PARA RECLUTADOR (Casos de Error / Excepciones)
    // =========================================================================

    @Test
    public void testReclutadorMagoLanzaExcepcionSiTipoNoExiste() {
        // Verificamos que salte IllegalArgumentException ante un tipo inválido como "Muggle"
        assertThrows(IllegalArgumentException.class, () -> {
            Reclutador.crearMago("Muggle", batallaDummy);
        }, "Debería lanzar IllegalArgumentException si el tipo de mago no existe en el Enum.");
    }

    @Test
    public void testReclutadorMortifagoLanzaExcepcionSiTipoNoExiste() {
        assertThrows(IllegalArgumentException.class, () -> {
            Reclutador.crearMortifago("Infiltrado", batallaDummy);
        }, "Debería lanzar IllegalArgumentException si el tipo de mortífago no existe en el Enum.");
    }

    // =========================================================================
    // TESTS PARA CLASES ABSTRACTAS (Mago y Mortifago)
    // =========================================================================

    @Test
    public void testConstructorMagoInicializaAtributosBase() {
        Mago mago = new MagoTestImpl("Harry", batallaDummy);

        assertEquals("Harry", mago.getNombre(), "El nombre del mago debería ser el asignado en el constructor.");
        assertEquals(0.0, mago.getPuntosVida(), "La vida inicial debería arrancar en 0 hasta que su estado o factoría la asigne.");
    }

    @Test
    public void testConstructorMortifagoInicializaAtributosBase() {
        Mortifago mortifago = new MortifagoTestImpl("Voldemort", batallaDummy);

        assertEquals("Voldemort", mortifago.getNombre(), "El nombre del mortífago debería ser el asignado.");
    }

    // =========================================================================
    // IMPLEMENTACIONES CONCRETAS SIMPLIFICADAS PARA TESTEAR CLASES ABSTRACTAS
    // =========================================================================

    private static class MagoTestImpl extends Mago {
        public MagoTestImpl(String nombre, GestorBatalla batalla) {
            super(nombre, batalla);
        }

        @Override
        protected void notificarDerrota() {
            // No requiere lógica para verificar herencia de constructor
        }
    }

    private static class MortifagoTestImpl extends Mortifago {
        public MortifagoTestImpl(String nombre, GestorBatalla batalla) {
            super(nombre, batalla);
        }

        @Override
        protected void notificarDerrota() {
            // No requiere lógica para verificar herencia de constructor
        }
    }
}
