package juego.motor.main;

import juego.motor.batalla.*;
import juego.motor.personaje.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" BATALLA: MAGOS VS MORTIFAGOS ");
        System.out.println("==========================================");

        Batallon batallonMagos = new Batallon();
        Batallon batallonMortifagos = new Batallon();
        LogBatalla logBatalla = new LogBatalla();
        GestorBatalla batalla = new GestorBatalla(batallonMagos, batallonMortifagos, logBatalla);

        Personaje harry = Reclutador.crearMago("Harry", "Auror", batalla);
        Personaje hermione = Reclutador.crearMago("Hermione", "Profesor", batalla);
        Personaje neville = Reclutador.crearMago("Neville", "Estudiante", batalla);
        Personaje kingsley = Reclutador.crearMago("Kingsley", "Auror", batalla);
        harry.equiparItem(new CapaInvisibilidad());

        batallonMagos.agregarMiembro(harry);
        batallonMagos.agregarMiembro(hermione);
        batallonMagos.agregarMiembro(neville);
        batallonMagos.agregarMiembro(kingsley);

        Personaje bellatrix = Reclutador.crearMortifago("Bellatrix", "Comandante", batalla);
        Personaje lucius = Reclutador.crearMortifago("Lucius", "Comandante", batalla);
        Personaje crabbe = Reclutador.crearMortifago("Crabbe", "Seguidor_Comun", batalla);
        Personaje goyle = Reclutador.crearMortifago("Goyle", "Seguidor_Comun", batalla);
        lucius.equiparItem(new PiedraFilosofal(lucius));

        batallonMortifagos.agregarMiembro(bellatrix);
        batallonMortifagos.agregarMiembro(lucius);
        batallonMortifagos.agregarMiembro(crabbe);
        batallonMortifagos.agregarMiembro(goyle);
        
        batalla.iniciarBatalla();
    }   
}