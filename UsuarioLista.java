package Controlador;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;


public class UsuarioLista {
    private final String[] listaUsuarios;
    private int cantidadUsuarios;
    private final String archivoDatos = "src/DatosGenerales/Aforo/aforoActual.txt";

    
    public UsuarioLista() {
        listaUsuarios = new String[101];
        cantidadUsuarios = 0;
        cargarDesdeArchivo();
    }

    public void agregarUsuario(String usuario) {
        if (cantidadUsuarios < listaUsuarios.length) {
            listaUsuarios[cantidadUsuarios] = usuario;
            cantidadUsuarios++;
            guardarEnArchivo();
        } else {
            JOptionPane.showMessageDialog(null, "La lista está llena, no se puede agregar más usuarios.");
        }
    }

    public void quitarUsuario(String usuario) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (listaUsuarios[i].equals(usuario)) {
                for (int j = i; j < cantidadUsuarios - 1; j++) {
                    listaUsuarios[j] = listaUsuarios[j + 1];
                }
                cantidadUsuarios--;
                guardarEnArchivo();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado en la lista.");
    }

    private void guardarEnArchivo() {
        try (var writer = new BufferedWriter(new FileWriter(archivoDatos))) {
            for (int i = 0; i < cantidadUsuarios; i++) {
                writer.write(listaUsuarios[i]);
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    private void cargarDesdeArchivo() {
        try (var reader = new BufferedReader(new FileReader(archivoDatos))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listaUsuarios[cantidadUsuarios] = line;
                cantidadUsuarios++;
            }
        } catch (IOException e) {
            // El archivo probablemente no existe todavía, no es un problema
        }
    }

    public void mostrarContenidoArchivoSeleccionado(File archivo) {
        StringBuilder contenido = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contenido.append(line).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Contenido del archivo:\n" + contenido.toString());
        } catch (IOException e) {
        }
    }
}