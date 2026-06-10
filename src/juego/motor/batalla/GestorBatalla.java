package juego.motor.batalla;

import java.util.List;

import juego.motor.personaje.EfectoDurable;

public class GestorBatalla {
	private List<EfectoDurable> listaEstados;
	
	public void agregarObserver(EfectoDurable observer) {
		listaEstados.add(observer);
	}
	
	public void eliminarObserver(EfectoDurable observer) {
		listaEstados.remove(observer);
	}
	
	public void notificarObservers() {
		for(EfectoDurable estado : listaEstados) {
			estado.actualizar();
		}
	}
}
