package juego.motor.batalla;

import java.util.List;
import java.util.ArrayList;

import juego.motor.hechizo.Hechizo;
import juego.motor.personaje.Personaje;

public class Batallon implements BatallaObserver {

	private List<Personaje> miembros = new ArrayList<>();

    public void agregarMiembro(Personaje personaje) {
    		miembros.add(personaje);
    }
    
    public List<Personaje> obtenerPersonajesVivos() {
        List<Personaje> personajesVivos = new ArrayList<>();
        
        for (Personaje p : this.miembros) {
            if (p.getPuntosVida() > Personaje.PUNTOS_DERROTA) {
            	personajesVivos.add(p); 
            }
        }
        
        return personajesVivos;
    }
       
    @Override
    public void onPersonajeDerrotado(Personaje personaje) {
    }

    @Override
    public void onHechizoLanzado(Personaje lanzador, Hechizo hechizo, Personaje objetivo) {
    }  
}
