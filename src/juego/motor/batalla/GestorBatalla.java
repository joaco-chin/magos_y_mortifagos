package juego.motor.batalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import juego.motor.hechizo.Hechizo;
import juego.motor.personaje.EfectoEstado;
import juego.motor.personaje.Personaje;

public class GestorBatalla {
	private Batallon bandoMagos;
    private Batallon bandoMortifagos;
    private LogBatalla logEventos;
    
    private Map<Personaje, List<Hechizo>> historialMagia = new HashMap<>();
    private Set<Hechizo> hechizosUsadosEnRonda = new HashSet<>();
    private List<EfectoEstado> observerEstados = new ArrayList<>();
    
    private List<BatallaObserver> observers = new ArrayList<>();
    
    public GestorBatalla(Batallon magos, Batallon mortifagos, LogBatalla log) {
        this.bandoMagos = magos;
        this.bandoMortifagos = mortifagos;
        this.logEventos = log;
        
        this.observers.add(log);
        this.observers.add(magos);
        this.observers.add(mortifagos);
        
    }
    
    public void agregarObserver(EfectoEstado observer) {
        this.observerEstados.add(observer);
    }
    
    public void eliminarObserver(EfectoEstado observer) {
        this.observerEstados.remove(observer);
    }
    
    public void notificarPersonajeDerrotado(Personaje p) {
    		for (BatallaObserver obs : observers) {
            obs.onPersonajeDerrotado(p);
        }
    }
    
    public void notificarHechizoLanzado(Personaje lanzador, Hechizo h, Personaje objetivo) {
        for (BatallaObserver obs : observers) {
            obs.onHechizoLanzado(lanzador, h, objetivo);
        }
    }
    
    public void gestionarTurno(Personaje turnoActual) {
  
        Hechizo hechizoAEjecutar = null;
        
        for (Hechizo h : turnoActual.getHechizosConocidos()) { 
            
            if (!hechizosUsadosEnRonda.contains(h)) {
                hechizoAEjecutar = h;
                break; 
            }
        }

        if (hechizoAEjecutar == null) {
            System.out.println(turnoActual.getNombre() + " no tiene hechizos disponibles para este turno.");
            return;
        }

        Batallon bandoEnemigo = (bandoMagos.obtenerPersonajesVivos().contains(turnoActual)) ? bandoMortifagos : bandoMagos;
        List<Personaje> enemigosVivos = bandoEnemigo.obtenerPersonajesVivos();

 
        if (enemigosVivos.isEmpty()) {
            return;
        }
        
        Personaje objetivo = enemigosVivos.get(0); 
        
        String nombreHechizo = hechizoAEjecutar.getClass().getSimpleName();
        if (nombreHechizo.equals("Protego") || nombreHechizo.equals("ExpectoPatronum")) {
            objetivo = turnoActual; 
        }

        turnoActual.lanzarHechizo(hechizoAEjecutar, objetivo);
        
        this.notificarHechizoLanzado(turnoActual, hechizoAEjecutar, objetivo);

        hechizosUsadosEnRonda.add(hechizoAEjecutar);

        if (!historialMagia.containsKey(turnoActual)) {
            historialMagia.put(turnoActual, new ArrayList<>());
        }

        historialMagia.get(turnoActual).add(hechizoAEjecutar);
    }
    
    public void iniciarBatalla() {
        System.out.println("\n========================================");
        System.out.println("            COMIENZA LA BATALLA           ");
        System.out.println("========================================");
        int nroRonda = 1;
        int maxRondas = 10;
      
        while (!bandoMagos.obtenerPersonajesVivos().isEmpty() && !bandoMortifagos.obtenerPersonajesVivos().isEmpty() && nroRonda <= maxRondas) 
        {
            System.out.println("\nRONDA " + nroRonda);
            
            boolean empiezanMagos = Math.random() < 0.5;

            if (empiezanMagos) {
                ejecutarTurnoBandoMagos();
                if (!bandoMortifagos.obtenerPersonajesVivos().isEmpty()) {
                    ejecutarTurnoBandoMortifagos();
                }
            } else {
                ejecutarTurnoBandoMortifagos();
                if (!bandoMagos.obtenerPersonajesVivos().isEmpty()) {
                    ejecutarTurnoBandoMagos();
                }
            }

            nroRonda++;
        }

        System.out.println("\n========================================");
        System.out.println("            FIN DE LA BATALLA           ");
        System.out.println("========================================");

        if (bandoMagos.obtenerPersonajesVivos().isEmpty()) {
            System.out.println("¡Los Mortífagos han ganado la batalla!");
        } else if (bandoMortifagos.obtenerPersonajesVivos().isEmpty()) {
            System.out.println("¡Los Magos han ganado la batalla!");
        } else {
            System.out.println("¡La batalla ha terminado en empate!");
        }
        
        logEventos.mostrarHistorial();
    }
    
    private void ejecutarTurnoBandoMagos() {
        System.out.println("\nTurno del Bando de los Magos");
        hechizosUsadosEnRonda.clear();
        java.util.List<Personaje> magosATurnar = new java.util.ArrayList<>(bandoMagos.obtenerPersonajesVivos());
        for (Personaje mago : magosATurnar) {
            if (bandoMagos.obtenerPersonajesVivos().contains(mago) && !bandoMortifagos.obtenerPersonajesVivos().isEmpty()) {
                gestionarTurno(mago);
            }
        }
    }

    private void ejecutarTurnoBandoMortifagos() {
        System.out.println("\nTurno del Bando de los Mortífagos");
        hechizosUsadosEnRonda.clear(); 
        java.util.List<Personaje> mortifagosATurnar = new java.util.ArrayList<>(bandoMortifagos.obtenerPersonajesVivos());
        for (Personaje mortifago : mortifagosATurnar) {
            if (bandoMortifagos.obtenerPersonajesVivos().contains(mortifago) && !bandoMagos.obtenerPersonajesVivos().isEmpty()) {
                gestionarTurno(mortifago);
            }
        }
    }
   

}
