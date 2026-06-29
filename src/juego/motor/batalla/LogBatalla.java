package juego.motor.batalla;

import java.util.ArrayList;
import java.util.List;

import juego.motor.hechizo.Hechizo;
import juego.motor.personaje.Personaje;

public class LogBatalla implements BatallaObserver {

    private List<String> secuenciaAtaques = new ArrayList<>();

    @Override
    public void onPersonajeDerrotado(Personaje personaje) {
        secuenciaAtaques.add(personaje.getNombre() + " ha sido derrotado.");
        System.out.println(personaje.getNombre() + " ha sido derrotado.");
    }

    @Override
    public void onHechizoLanzado(Personaje lanzador, Hechizo hechizo, Personaje objetivo) {
        String registro = lanzador.getNombre() + " lanzó " + hechizo.getClass().getSimpleName() + " a " + objetivo.getNombre();
        secuenciaAtaques.add(registro);
        System.out.println(registro);
    }

    public void mostrarHistorial() {
    	for (String ataque : secuenciaAtaques) {
            System.out.println(ataque);
        }
    }
}
