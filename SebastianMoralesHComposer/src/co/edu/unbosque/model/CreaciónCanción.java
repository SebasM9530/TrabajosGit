package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArchivoProperties;
import co.edu.unbosque.model.persistence.ArchivoTexto;
import co.edu.unbosque.view.View;

import java.util.Random;

public class CreaciónCanción {
    private View gui;
    private int numEstrofas;
    private int numFrases;
    private String[] cancion;
    private static final String[][] TABLA_FRASES = {
            {"Mami", "Bebé", "Princess", "Bellaca"},
            {"yo quiero", "yo puedo", "yo vengo a", "voy a"},
            {"encenderte", "amarte", "ligar", "jugar"},
            {"suave", "lento", "rápido", "fuerte"},
            {"hasta que salga el sol", "toda la noche", "hasta el amanecer", "todo el día"},
            {"sin anestesia", "sin compromiso", "feis to feis", "sin miedo"}
    };

    public CreaciónCanción(View gui) {
        this.gui = gui;
    }

    public String gestionarPropiedades() {
        ArchivoProperties prop = new ArchivoProperties("C:\\Canción\\properties.properties");
        numEstrofas = gui.pedirNumeroEstrofas();
        numFrases = gui.pedirNumeroFrases();
        prop.escribirPropiedades(numEstrofas, numFrases);
        return "Se leyeron estas propiedades: \n" + prop.leerPropiedades();
    }

    public void generarCancion() {
        cancion = new String[numEstrofas];
        Random random = new Random();

        for (int i = 0; i < numEstrofas; i++) {
            StringBuilder estrofa = new StringBuilder();
            int fila = random.nextInt(TABLA_FRASES[0].length);
            estrofa.append(TABLA_FRASES[0][fila]).append(" ");

            for (int j = 1; j < numFrases; j++) {
                if (j >= TABLA_FRASES.length) {
                    break; // Si j excede la longitud de TABLA_FRASES, salimos del bucle
                }
                fila = random.nextInt(TABLA_FRASES[j].length);
                estrofa.append(TABLA_FRASES[j][fila]).append(" ");
            }

            cancion[i] = estrofa.toString().trim();
        }
    }

    public void crearCancion() {
        generarCancion();
        String cancionGenerada = String.join("\n\n", cancion);
        gui.escribirDato(cancionGenerada);
        ArchivoTexto archivo = new ArchivoTexto("C:\\Canción\\properties.txt");
        archivo.escribirArchivoNuevo(cancionGenerada);
        gui.guardarCancion(cancionGenerada);
    }

    public void mostrarCancion() {
        String cancionLeida = gui.seleccionarArchivo();
        if (cancionLeida != null) {
            gui.escribirDato(cancionLeida);
        } else {
            gui.escribirDato("No se pudo leer el archivo de la canción.");
        }
    }
}