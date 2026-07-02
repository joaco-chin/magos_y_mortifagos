package juego.motor.hechizo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juego.motor.batalla.Batallon;
import juego.motor.batalla.GestorBatalla;
import juego.motor.batalla.LogBatalla;
import juego.motor.personaje.Personaje;
import juego.motor.personaje.EfectoEstado;
import juego.motor.personaje.EstadoVeneno;
import juego.motor.personaje.EstadoDebilidad;
import juego.motor.personaje.EstadoResistencia;

public class HechizoTest {

    private PersonajeMock objetivo;

    @BeforeEach
    public void setUp() {
        // Creamos las dependencias mínimas para que GestorBatalla no sea null
        Batallon magosDummy = new Batallon();
        Batallon mortifagosDummy = new Batallon();
        LogBatalla logDummy = new LogBatalla(); // Asegúrate de que use el constructor de tu clase
        
        GestorBatalla batallaDummy = new GestorBatalla(magosDummy, mortifagosDummy, logDummy);
        
        // Le pasamos la batalla real dummy al personaje para evitar el NullPointerException
        objetivo = new PersonajeMock("Harry", batallaDummy);
    }

    @Test
    public void testAvadaKedavraCambiaEstadoAVeneno() {
        Hechizo avada = new AvadaKedavra();
        avada.ejecutar(objetivo);
        
        assertNotNull(objetivo.getEstadoActual(), "El estado del personaje no debería ser null.");
        assertTrue(objetivo.getEstadoActual() instanceof EstadoVeneno, 
            "AvadaKedavra debería cambiar el estado del personaje a EstadoVeneno.");
    }

    @Test
    public void testDesmaiusCambiaEstadoADebilidad() {
        Hechizo desmaius = new Desmaius();
        desmaius.ejecutar(objetivo);
        
        assertNotNull(objetivo.getEstadoActual(), "El estado del personaje no debería ser null.");
        assertTrue(objetivo.getEstadoActual() instanceof EstadoDebilidad, 
            "Desmaius debería cambiar el estado del personaje a EstadoDebilidad.");
    }

    @Test
    public void testProtegoCambiaEstadoAResistencia() {
        Hechizo protego = new Protego();
        protego.ejecutar(objetivo);
        
        assertNotNull(objetivo.getEstadoActual(), "El estado del personaje no debería ser null.");
        assertTrue(objetivo.getEstadoActual() instanceof EstadoResistencia, 
            "Protego debería cambiar el estado del personaje a EstadoResistencia.");
    }

    @Test
    public void testExpectoPatronumAplicaCuracionSegunNivel() {
        double nivelMagia = 2.0;
        double curacionEsperada = 30 * nivelMagia;
        Hechizo patronum = new ExpectoPatronum(nivelMagia);
        
        patronum.ejecutar(objetivo);
        
        assertTrue(objetivo.fueCurado, "El método curarse() debió ser invocado.");
        assertEquals(curacionEsperada, objetivo.cantidadCurada, 0.001);
    }

    @Test
    public void testExpelliarmusAplicaDañoSegunNivel() {
        double nivelMagia = 3.0;
        double dañoEsperado = 50 * nivelMagia;
        Hechizo expelliarmus = new Expelliarmus(nivelMagia);
        
        expelliarmus.ejecutar(objetivo);
        
        assertTrue(objetivo.recibioDaño, "El método recibirDaño() debió ser invocado.");
        assertEquals(dañoEsperado, objetivo.cantidadDaño, 0.001);
    }

    private static class PersonajeMock extends Personaje {
        public boolean recibioDaño = false;
        public double cantidadDaño = 0;
        public boolean fueCurado = false;
        public double cantidadCurada = 0;

        public PersonajeMock(String nombre, GestorBatalla batalla) {
            super(nombre, batalla);
            this.nivelMagia = 1; 
        }

        @Override
        public void recibirDaño(double cantidad) {
            this.recibioDaño = true;
            this.cantidadDaño = cantidad;
        }

        @Override
        public void curarse(double cantidad) {
            this.fueCurado = true;
            this.cantidadCurada = cantidad;
        }

        @Override
        public void cambiarEstado(EfectoEstado nuevoEstado) {
            this.estado = nuevoEstado;
        }

        public EfectoEstado getEstadoActual() {
            return this.estado;
        }

        @Override
        protected void notificarDerrota() {
        }
    }
}
