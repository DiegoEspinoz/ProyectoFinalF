package Model;

import javax.swing.JOptionPane;

public class TipodePlan {

    public static int seleccionarFrecuenciaEjercicio() {
        String[] opcionesFrecuencia = {  "Sedentario (0 veces por semana)", 
                                                            "Ejercicio ligero (1-2 veces por semana)",
                                                           "Ejercicio moderado (3 veces por semana)", 
                                                            "Ejercicio intenso (4-5 veces por semana)" };
        int opcionFrecuencia = JOptionPane.showOptionDialog(
                null,
                "Seleccione la frecuencia de ejercicio:",
                "Frecuencia de Ejercicio",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesFrecuencia,
                opcionesFrecuencia[0]);

        return opcionFrecuencia + 1;
    }

    public static int seleccionarTipoPlan() {
        String[] opcionesPlan = { "Plan Basic (1 mes) - 40 soles", 
                                                 "Plan Silver (3 meses) - 90 soles",
                                                "Plan Gold (6 meses) - 140 soles", 
                                                "Plan Premium (12 meses) - 225 soles" };
        int opcionPlan = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de plan:",
                "Tipo de Plan",
                0,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesPlan,
                opcionesPlan[0]);

        return opcionPlan + 1;
    }
    public static String seleccionarFrecuenciaEjercicioTexto(int frecuenciaEjercicio) {
        return switch (frecuenciaEjercicio) {
            case 1 -> "Sedentario (0 veces por semana)";
            case 2 -> "Ejercicio ligero (1-2 veces por semana)";
            case 3 -> "Ejercicio moderado (3 veces por semana)";
            case 4 -> "Ejercicio intenso (4-5 veces por semana)";
            default -> "Frecuencia de ejercicio no reconocida";
        };
    }
}
