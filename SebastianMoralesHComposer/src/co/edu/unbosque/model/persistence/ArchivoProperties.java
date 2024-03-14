package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class ArchivoProperties {
    private Properties prop = new Properties();
    private String archivoProp;

    public ArchivoProperties(String ruta) {
        this.archivoProp = ruta;
    }

    public int escribirPropiedades(int numEstrofas, int numFrases) {
        try {
            prop.setProperty("numEstrofas", String.valueOf(numEstrofas));
            prop.setProperty("numFrases", String.valueOf(numFrases));
            prop.store(new FileOutputStream(archivoProp), null);
        } catch (IOException ex) {
            return -1;
        }
        return 0;
    }

    public String leerPropiedades() {
        String linea = "";
        try {
            prop.load(new FileInputStream(archivoProp));
            linea += "Número de Estrofas: " + prop.getProperty("numEstrofas") + "\n";
            linea += "Número de Frases por Estrofa: " + prop.getProperty("numFrases") + "\n";
        } catch (IOException ex) {
            return null;
        }
        return linea;
    }
}