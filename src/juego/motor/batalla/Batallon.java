package juego.motor.batalla;

import java.util.List;
import java.util.ArrayList;

import juego.motor.hechizo.Hechizo;
import juego.motor.personaje.Personaje;

public class Batallon implements BatallaObserver {

	private List<Personaje> miembros = new ArrayList<>();

    public void agregarMiembro(Personaje personaje) {
    		miembros.add(personaje);
    		personaje.setBando(this);
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
    
    public List<Personaje> obtenerMuertos() {
        List<Personaje> muertos = new ArrayList<>();
        for (Personaje p : miembros) {
            if (p.getPuntosVida() <= 0) muertos.add(p);
        }
        return muertos;
    }
    
    public void reincorporar(Personaje p) {
        System.out.println(p.getNombre() + " ha vuelto al combate!");
    }
       
    @Override
    public void onPersonajeDerrotado(Personaje personaje) {
    	this.miembros.remove(personaje);
    }

    @Override
    public void onHechizoLanzado(Personaje lanzador, Hechizo hechizo, Personaje objetivo) {
    }  
}
