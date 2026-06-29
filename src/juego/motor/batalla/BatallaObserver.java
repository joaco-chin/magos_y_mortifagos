package juego.motor.batalla;

import juego.motor.hechizo.Hechizo;
import juego.motor.personaje.Personaje;

public interface BatallaObserver {
	void onPersonajeDerrotado(Personaje personaje);
    void onHechizoLanzado(Personaje lanzador, Hechizo hechizo, Personaje objetivo);
}
