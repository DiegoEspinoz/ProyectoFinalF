package Model;

import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Date;

public class OpciondePago {

    public static void procesarPago(int tipoPlan) {
        switch (tipoPlan) {
            case 1 -> JOptionPane.showMessageDialog(null, """
                    Metodos de pago:
                    Monto a pagar: 40 soles
                    1. Yape o Plin al siguiente numero:920155454
                    2. Realizas una transferencia bancaria a: 456189555959494
                    3. Pago en efectivo
                    """);
            case 2 -> JOptionPane.showMessageDialog(null, """
                    Metodos de pago:
                    Monto a pagar: 90 soles
                    1. Yape o Plin al siguiente numero:920155454
                    2. Realizas una transferencia bancaria a: 456189555959494
                    3. Pago en efectivo
                    """);
            case 3 -> JOptionPane.showMessageDialog(null, """
                    Metodos de pago:
                    Monto a pagar: 140 soles
                    1. Yape o Plin al siguiente numero:920155454
                    2. Realizas una transferencia bancaria a: 456189555959494
                    3. Pago en efectivo
                    """);
            case 4 -> JOptionPane.showMessageDialog(null, """
                    Metodos de pago:
                    Monto a pagar: 225 soles
                    1. Yape o Plin al siguiente numero:920155454
                    2. Realizas una transferencia bancaria a: 456189555959494
                    3. Pago en efectivo
                    """);
            default -> JOptionPane.showMessageDialog(null, "Tipo de plan no reconocido");
        }
    }

    public static Date calcularFechaExpiracion(Date fechaIngreso, int tipoPlan, int frecuenciaEjercicio) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaIngreso);

        switch (tipoPlan) {
            case 1 -> calendar.add(Calendar.MONTH, 1);
            case 2 -> calendar.add(Calendar.MONTH, 3);
            case 3 -> calendar.add(Calendar.MONTH, 6);
            case 4 -> calendar.add(Calendar.MONTH, 12);
        }

        switch (frecuenciaEjercicio) {
            case 1 -> {
                // No hacer nada (sin cambios en la fecha de expiración)
            }
            case 2 -> calendar.add(Calendar.WEEK_OF_YEAR, 2);
            case 3 -> calendar.add(Calendar.WEEK_OF_YEAR, 4);
            case 4 -> calendar.add(Calendar.WEEK_OF_YEAR, 5);
        }
        return calendar.getTime();
    }
}
