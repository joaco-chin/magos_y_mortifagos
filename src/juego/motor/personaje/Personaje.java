package juego.motor.personaje;
import java.util.List;
import java.util.ArrayList;
import juego.motor.batalla.GestorBatalla;
import juego.motor.hechizo.Hechizo;
import juego.motor.batalla.*;

public abstract class Personaje {
	public static final int PUNTOS_DERROTA = 0;
	
	protected String nombre;
	protected int nivelMagia;
	protected double puntosVida;
	protected double maxPuntosVida;
	protected List<Hechizo> hechizosConocidos;
	private List<Object> inventario = new ArrayList<>();
	protected EfectoEstado estado;
	protected final GestorBatalla batalla;
	protected Batallon bando;
	
	public Personaje(String nombre, GestorBatalla batalla) {
		this.nombre = nombre;
		this.estado = new EstadoNormal(this);
		this.batalla = batalla;
	}
	
	public void equiparItem(Object item) {
        this.inventario.add(item);
    }
	
	public boolean tieneItem(String nombreItem) {
        return inventario.stream().anyMatch(i -> i.getClass().getSimpleName().equals(nombreItem));
    }

    public void usarItem(String nombreItem, Personaje objetivo) {
        Object item = inventario.stream()
                .filter(i -> i.getClass().getSimpleName().equals(nombreItem))
                .findFirst()
                .orElse(null);

        if (item instanceof PiedraFilosofal) {
            ((PiedraFilosofal) item).usar(this, objetivo);
            inventario.remove(item);
        }
    }
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
		this.estado.lanzarHechizo(hechizo, objetivo);
	}
	
	public void recibirDaño(double cantidad) {
		this.estado.recibirDaño(cantidad);
	}
	
	public void curarse(double cantidad) {
		this.estado.curarse(cantidad);
		
		if (this.puntosVida > 0 && this.estado instanceof EstadoDerrotado) {
	        this.cambiarEstado(new EstadoNormal(this));
	    }
	}
	
	public void cambiarEstado(EfectoEstado estado) {
		this.estado = estado;
	}
	
	public void aplicarEfectosDeTurno() {
	    if (this.estado != null) {
	        this.estado.actualizar();
	    }
	}
	
	public double getPuntosVida() {
		return this.puntosVida;
	}
	
	public List<Hechizo> getHechizosConocidos(){
		return this.hechizosConocidos;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public GestorBatalla getGestorBatalla() {
		return this.batalla;
	}
	
	public void setBando(Batallon bando) {
		this.bando = bando;
	}
	
	public Batallon getBando() {
		return this.bando;
		}

	public boolean esDelMismoBando(Personaje otro) {
	    return this.bando != null && this.bando == otro.getBando();
	}
}