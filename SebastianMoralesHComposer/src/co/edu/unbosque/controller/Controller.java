package co.edu.unbosque.controller;

import co.edu.unbosque.model.CreaciónCanción;
import co.edu.unbosque.view.View;

public class Controller {
    private View gui;
    private CreaciónCanción m;

    public Controller() {
        gui = new View();
        m = new CreaciónCanción(gui);
        iniciar();
    }

    private void iniciar() {
        String opcion;
        do {
            opcion = gui.pedirOpcion();
            switch (opcion) {
                case "1":
                    gui.escribirDato(m.gestionarPropiedades());
                    break;
                case "2":
                    m.crearCancion();
                    break;
                case "3":
                    m.mostrarCancion();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    gui.escribirDato("Opción inválida");
            }
        } while (!opcion.equals("4"));
    }
}