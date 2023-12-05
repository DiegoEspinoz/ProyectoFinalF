package View;

import static Controlador.NuevoUsuarioLista.registrarNuevoUsuario;
import javax.swing.JOptionPane;
import java.io.File;
import Controlador.UsuarioLista;
import javax.swing.JFileChooser;

public class GymWelcome {

    public static void main(String[] args) {
        UsuarioLista usuariosLista = new UsuarioLista();
        String nombreGym = "Gold's Gym";
        String direccionGym = "Av. Universitaria 5364, Lima 15311";
        String[] opcionesMenu = { "Registrar nuevo usuario", "Gestion de aforo", "Cerrar" };

        int opcionSeleccionada = JOptionPane.showOptionDialog(
                null,
                "Bienvenido a " + nombreGym + "\n" +
                        "Nos ubicamos en: " + direccionGym + "\n" +
                        "¡Estamos emocionados de tenerte con nosotros!",
                nombreGym,
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMenu,
                opcionesMenu[0]);

        switch (opcionSeleccionada) {
            case 0:
                registrarNuevoUsuario();
                break;
            case 1:
                while (true) {
                    String[] options = { "Ingreso de Usuario", 
                                                    "Salida de Usuario",
                                                   "Mostrar lista de usuarios activos",
                                                     "Salir" };
                    int choice = JOptionPane.showOptionDialog(
                     null,
                             "Seleccione una acción:",
                                    "Gestión de Usuarios",
                           JOptionPane.DEFAULT_OPTION,
                         JOptionPane.PLAIN_MESSAGE,
                                     null,
                                           options,
                                           options[0]);

                    switch (choice) {
                        case 0:
                            String nuevoUsuario = JOptionPane.showInputDialog("Ingrese el nuevo usuario:");
                            usuariosLista.agregarUsuario(nuevoUsuario);
                            break;
                        case 1:
                            String usuarioEliminar = JOptionPane.showInputDialog("Ingrese el usuario a eliminar:");
                            usuariosLista.quitarUsuario(usuarioEliminar);
                            break;
                        case 2:
                            JFileChooser fileChooserMostrar = new JFileChooser();
                            int resultMostrar = fileChooserMostrar.showOpenDialog(null);
                            if (resultMostrar == JFileChooser.APPROVE_OPTION) {
                                File selectedFileMostrar = fileChooserMostrar.getSelectedFile();
                                usuariosLista.mostrarContenidoArchivoSeleccionado(selectedFileMostrar);
                            }
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                    }
                }
            case 2:
                System.exit(0);
        }
    }
}
