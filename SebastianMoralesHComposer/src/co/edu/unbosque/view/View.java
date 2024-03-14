package co.edu.unbosque.view;

import javax.swing.*;
import java.io.*;

public class View {
    public String pedirDato() {
        return JOptionPane.showInputDialog(null, "Ingrese un dato", "Título del InputDialog", JOptionPane.INFORMATION_MESSAGE);
    }

    public void escribirDato(String dato) {
        JOptionPane.showMessageDialog(null, dato, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
    }

    public int pedirNumeroEstrofas() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estrofas:"));
    }

    public int pedirNumeroFrases() {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de frases por estrofa:"));
    }

    public String pedirOpcion() {
        return JOptionPane.showInputDialog(null, "Seleccione una opción:\n" +
                "1. Definir parámetros de número de estrofas y número de frases por estrofa\n" +
                "2. Crear canción y guardarla en disco\n" +
                "3. Seleccionar una canción creada y mostrarla\n" +
                "4. Salir");
    }

    public void guardarCancion(String cancion) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(archivo);
                writer.write(cancion);
                writer.close();
                escribirDato("Canción guardada correctamente");
            } catch (IOException e) {
                escribirDato("Error al guardar la canción");
            }
        }
    }

    public String seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                StringBuilder contenido = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = reader.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                reader.close();
                return contenido.toString();
            } catch (Exception e) {
                escribirDato("Error al leer el archivo");
            }
        }
        return null;
    }
}