package co.edu.unbosque.model.persistence;

import java.io.*;

public class ArchivoTexto {
    private String archivoNuevo;

    public ArchivoTexto(String ruta) {
        this.archivoNuevo = ruta;
    }

    public int escribirArchivoNuevo(String dato) {
        File f = new File(this.archivoNuevo);
        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(dato);
            fw.close();
        } catch (IOException e) {
            return -1;
        }
        return 0;
    }

    public String getArchivoNuevo() {
        return archivoNuevo;
    }

    public String leerArchivoNuevo() {
        String linea = "";
        String cadena = "";
        File f = new File(this.archivoNuevo);

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();

            while (linea != null) {
                cadena += linea + "\n";
                linea = br.readLine();
            }

            fr.close();
        } catch (IOException e) {
            return null;
        }

        return cadena;
    }
}