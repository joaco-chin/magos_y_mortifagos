package juego.motor.batalla;

import java.util.List;

import juego.motor.personaje.EfectosDurables;

public class GestorBatalla {
	private List<EfectosDurables> listaEstados;
	
	public void agregarObserver(EfectosDurables observer) {
		listaEstados.add(observer);
	}
	
	public void eliminarObserver(EfectosDurables observer) {
		listaEstados.remove(observer);
	}
	
	public void notificarObservers() {
		for(EfectosDurables estado : listaEstados) {
			estado.actualizar();
		}
	}
}
