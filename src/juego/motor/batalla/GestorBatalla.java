package juego.motor.batalla;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import juego.motor.hechizo.Hechizo;
import juego.motor.personaje.Personaje;

public class GestorBatalla {
    private Batallon bandoMagos;
    private Batallon bandoMortifagos;

    private Map<Personaje, List<Hechizo>> historialMagia = new HashMap<>();
    private Set<String> hechizosUsadosEnTurno = new HashSet<>();
    private List<BatallaObserver> observers = new ArrayList<>();

    public GestorBatalla(Batallon magos, Batallon mortifagos, LogBatalla log) {
        this.bandoMagos = magos;
        this.bandoMortifagos = mortifagos;
        
        this.observers.add(log);
        this.observers.add(magos);
        this.observers.add(mortifagos);
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
    
    public void aplicarDaño(Personaje atacante, Personaje objetivo, double daño) {
        objetivo.recibirDaño(daño);
        if (objetivo.getPuntosVida() <= 0) {
            for (BatallaObserver obs : this.observers) {
                obs.onPersonajeDerrotado(objetivo);
            }
        }
    }
    
    public void agregarObserver(BatallaObserver obs) {
        this.observers.add(obs);
    }

    public void gestionarTurno(Personaje turnoActual) {
        turnoActual.aplicarEfectosDeTurno();
        Hechizo hechizoAEjecutar = null;
        
        if (turnoActual.getPuntosVida() <= 0) {
            notificarPersonajeDerrotado(turnoActual);
            return;
        }
        
        if (turnoActual.tieneItem("PiedraFilosofal") && Math.random() < 0.5) {
            List<Personaje> aliadosMuertos = turnoActual.getBando().obtenerMuertos();
            if (!aliadosMuertos.isEmpty()) {
                turnoActual.usarItem("PiedraFilosofal", aliadosMuertos.get(0));
                return;
            }
        }

        
        List<Hechizo> disponibles = new ArrayList<>();
        for (Hechizo h : turnoActual.getHechizosConocidos()) {
            if (!hechizosUsadosEnTurno.contains(h.getClass().getSimpleName())) {
                disponibles.add(h);
            }
        }
        
        if (!disponibles.isEmpty()) {
            hechizoAEjecutar = disponibles.get(new java.util.Random().nextInt(disponibles.size()));
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
        
        if (objetivo.getPuntosVida() <= 0) { 
            this.notificarPersonajeDerrotado(objetivo);
            System.out.println("¡" + objetivo.getNombre() + " ha sido derrotado!");
        }

        hechizosUsadosEnTurno.add(nombreHechizo);

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
        int maxRondas = 100;
      
        while (!bandoMagos.obtenerPersonajesVivos().isEmpty() && !bandoMortifagos.obtenerPersonajesVivos().isEmpty() && nroRonda <= maxRondas) {
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
    }

    private void ejecutarTurnoBandoMagos() {
        System.out.println("\nTurno del Bando de los Magos");
        hechizosUsadosEnTurno.clear();
        java.util.List<Personaje> magosATurnar = new java.util.ArrayList<>(bandoMagos.obtenerPersonajesVivos());
        for (Personaje mago : magosATurnar) {
            if (bandoMagos.obtenerPersonajesVivos().contains(mago) && !bandoMortifagos.obtenerPersonajesVivos().isEmpty()) {
                gestionarTurno(mago);
            }
        }
    }

    private void ejecutarTurnoBandoMortifagos() {
        System.out.println("\nTurno del Bando de los Mortífagos");
        hechizosUsadosEnTurno.clear();
        java.util.List<Personaje> mortifagosATurnar = new java.util.ArrayList<>(bandoMortifagos.obtenerPersonajesVivos());
        for (Personaje mortifago : mortifagosATurnar) {
            if (bandoMortifagos.obtenerPersonajesVivos().contains(mortifago) && !bandoMagos.obtenerPersonajesVivos().isEmpty()) {
                gestionarTurno(mortifago);
            }
        }
    }
}