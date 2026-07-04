package juego.motor.batalla;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import juego.motor.personaje.Personaje;

public class BatallonTest {

    private Batallon batallon;
    private Personaje personajeVivo1;
    private Personaje personajeVivo2;
    private Personaje personajeMuerto;

    @BeforeEach
    public void setUp() {
        batallon = new Batallon();
        
        // Inicializamos los personajes de prueba con sus puntos de vida
        personajeVivo1 = new PersonajeMock("Harry", 100.0);
        personajeVivo2 = new PersonajeMock("Hermione", 50.0);
        personajeMuerto = new PersonajeMock("Voldemort", (double) Personaje.PUNTOS_DERROTA);
    }

    @Test
    public void testAgregarMiembroYObtenerVivos() {
        // Ejecución
        batallon.agregarMiembro(personajeVivo1);
        batallon.agregarMiembro(personajeVivo2);
        
        List<Personaje> vivos = batallon.obtenerPersonajesVivos();
        
        // Verificaciones
        assertEquals(2, vivos.size(), "El batallón debería tener 2 personajes vivos.");
        assertTrue(vivos.contains(personajeVivo1), "Debería incluir a Harry.");
        assertTrue(vivos.contains(personajeVivo2), "Debería incluir a Hermione.");
    }

    @Test
    public void testObtenerPersonajesVivosFiltraLosMuertos() {
        // Ejecución
        batallon.agregarMiembro(personajeVivo1);
        batallon.agregarMiembro(personajeMuerto); // Tiene vida 0 (PUNTOS_DERROTA)
        
        List<Personaje> vivos = batallon.obtenerPersonajesVivos();
        
        // Verificaciones
        assertEquals(1, vivos.size(), "El batallón solo debería retornar los personajes con vida > PUNTOS_DERROTA.");
        assertTrue(vivos.contains(personajeVivo1), "Debería incluir al personaje vivo.");
        assertFalse(vivos.contains(personajeMuerto), "No debería incluir al personaje muerto.");
    }

    @Test
    public void testOnPersonajeDerrotadoNoPurgaAlMiembro() {
        batallon.agregarMiembro(personajeVivo1);
        batallon.agregarMiembro(personajeVivo2);

        // Simulamos que Harry cae en combate de verdad (PV a 0)
        personajeVivo1.recibirDaño(1000);
        batallon.onPersonajeDerrotado(personajeVivo1);

        List<Personaje> vivos = batallon.obtenerPersonajesVivos();
        List<Personaje> muertos = batallon.obtenerMuertos();

        assertFalse(vivos.contains(personajeVivo1), "Harry no debe contar como vivo con 0 PV.");
        assertTrue(vivos.contains(personajeVivo2), "Hermione debería seguir en el batallón.");
        assertTrue(muertos.contains(personajeVivo1), 
            "Harry debe seguir presente en el batallón para poder ser encontrado por obtenerMuertos() y revivido con un objeto mágico.");
    }

    @Test
    public void testBatallonVacioRetornaListaVacia() {
        // Verificación directa sobre un batallón recién instanciado
        List<Personaje> vivos = batallon.obtenerPersonajesVivos();
        
        assertNotNull(vivos, "La lista retornada nunca debe ser null.");
        assertTrue(vivos.isEmpty(), "La lista de un batallón vacío debe estar vacía.");
    }

    // =========================================================================
    // MOCK CLASE PERSONAJE
    // Creamos una subclase concreta muy simple de Personaje para poder testear
    // =========================================================================
    private static class PersonajeMock extends Personaje {
        
        public PersonajeMock(String nombre, double vidaInicial) {
            // Pasamos null en el GestorBatalla ya que no lo necesitamos para estos tests
            super(nombre, null); 
            this.puntosVida = vidaInicial;
        }

    }
}
