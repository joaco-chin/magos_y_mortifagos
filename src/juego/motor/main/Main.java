package juego.motor.main;

import juego.motor.batalla.Batallon;
import juego.motor.batalla.GestorBatalla;
import juego.motor.batalla.LogBatalla;
import juego.motor.personaje.Personaje;
import juego.motor.personaje.Reclutador;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" BATALLA: MAGOS VS MORTIFAGOS ");
        System.out.println("==========================================");

        Batallon batallonMagos = new Batallon();
        Batallon batallonMortifagos = new Batallon();
        LogBatalla logBatalla = new LogBatalla();
        GestorBatalla batalla = new GestorBatalla(
                batallonMagos,
                batallonMortifagos, logBatalla);
        // ====== MAGOS ======
        Personaje harry = Reclutador.crearMago("Auror", batalla);
        Personaje hermione = Reclutador.crearMago("Profesor", batalla);
        Personaje neville = Reclutador.crearMago("Estudiante", batalla);
        Personaje kingsley = Reclutador.crearMago("Auror", batalla);

        batallonMagos.agregarMiembro(harry);
        batallonMagos.agregarMiembro(hermione);
        batallonMagos.agregarMiembro(neville);
        batallonMagos.agregarMiembro(kingsley);

        // ====== MORTIFAGOS ======

        Personaje bellatrix = Reclutador.crearMortifago("Comandante", batalla);
        Personaje lucius = Reclutador.crearMortifago("Comandante", batalla);
        Personaje crabbe = Reclutador.crearMortifago("Seguidor_Comun", batalla);
        Personaje goyle = Reclutador.crearMortifago("Seguidor_Comun", batalla);

        batallonMortifagos.agregarMiembro(bellatrix);
        batallonMortifagos.agregarMiembro(lucius);
        batallonMortifagos.agregarMiembro(crabbe);
        batallonMortifagos.agregarMiembro(goyle);

        batalla.iniciarBatalla();
    }   
}