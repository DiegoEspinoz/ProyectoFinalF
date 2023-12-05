/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.OpciondePago;
import Model.TipodePlan;
import Model.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import static Model.TipodePlan.seleccionarFrecuenciaEjercicioTexto;

/**
 *
 * @author migue
 */
public class NuevoUsuarioLista {
    public static void registrarNuevoUsuario() {
        Usuario nuevoUsuario = new Usuario();
        
        //Nombre del usuario
        nuevoUsuario.setNombre(JOptionPane.showInputDialog("Ingrese su nombre:"));
        //Apellido del usuario
        nuevoUsuario.setApellido(JOptionPane.showInputDialog("Ingrese su Apellido:"));
        
        try {
            
            nuevoUsuario.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad(entre 15 y 80 años):")));
            //Rango de edades permitidas
            if (nuevoUsuario.getEdad() <= 15 || nuevoUsuario.getEdad() >= 80) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una edad válida (entre 18 y 80 años).");
            return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una edad válida (número entero).");
            return;
        }

        try {
            nuevoUsuario.setTalla(Double.parseDouble(JOptionPane.showInputDialog("Ingrese su talla(metros):")));
            //Rango de talla
            if (nuevoUsuario.getTalla() <= 1.10 || nuevoUsuario.getTalla() >= 2.20) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una talla válida (entre 1.20 y 2.00 metros).");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una talla válida (número decimal).");
            return;
        }

        try {
            nuevoUsuario.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso (kilogramos):")));
            //Rango de peso de usuario
            if (nuevoUsuario.getPeso() < 40 || nuevoUsuario.getPeso() > 150) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un peso válido (entre 40 y 150 kilogramos).");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un peso válido (número decimal).");
            return;
        }

        // Resto del código para seleccionar frecuencia, tipo de plan, procesar pago,
        // calcular fecha de expiración y guardar datos en archivo
        TipodePlan seleccionarPlan = new TipodePlan();  // Instanciar la clase o utilizar la instancia existente
        int frecuenciaEjercicio = seleccionarPlan.seleccionarFrecuenciaEjercicio();
        int tipoPlan = seleccionarPlan.seleccionarTipoPlan();
        OpciondePago.procesarPago(tipoPlan);

        Date fechaIngreso = new Date();
        Date fechaExpiracion = OpciondePago.calcularFechaExpiracion(fechaIngreso, tipoPlan, frecuenciaEjercicio);

        guardarDatosEnArchivo("src/DatosGenerales/UNuevos/usuariosNuevos.txt", nuevoUsuario, frecuenciaEjercicio, tipoPlan, fechaIngreso, fechaExpiracion);

        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(null, "Datos guardados en 'src/DatosGenerales/UNuevos/usuariosNuevos.txt'");
    }
    
    public static void guardarDatosEnArchivo(String rutaArchivo, Usuario usuario, int frecuenciaEjercicio, int tipoPlan, Date fechaIngreso, Date fechaExpiracion) {
        try {
            File carpetaDatos = new File(System.getProperty("user.dir"), "src/DatosGenerales/UNuevos");
            carpetaDatos.mkdirs();
            File archivo = new File(rutaArchivo);

            StringBuilder datosUsuario = new StringBuilder();
            // Construye la cadena con los datos del usuario
            datosUsuario.append("Nombre: ").append(usuario.getNombre()).append("\n");
            datosUsuario.append("Apellido: ").append(usuario.getApellido()).append("\n");
            datosUsuario.append("Edad: ").append(usuario.getEdad()).append(" años\n");
            datosUsuario.append("Talla: ").append(usuario.getTalla()).append(" metros\n");
            datosUsuario.append("Peso: ").append(usuario.getPeso()).append(" kg\n");
            datosUsuario.append("Tipo de Plan: ").append(usuario.getTipoPlan()).append("\n");
            datosUsuario.append("Frecuencia de ejercicio: ").append(frecuenciaEjercicio).append("\n");
            datosUsuario.append(seleccionarFrecuenciaEjercicioTexto(frecuenciaEjercicio)).append("\n");
            datosUsuario.append("Fecha de ingreso: ").append(fechaIngreso).append("\n");
            datosUsuario.append("Fecha de expiración: ").append(fechaExpiracion).append("\n");

           try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
                writer.write(datosUsuario.toString());
                writer.newLine();
            }

        } catch (IOException e) {
        }
    }
}
