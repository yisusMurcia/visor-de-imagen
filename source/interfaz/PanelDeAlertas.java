package interfaz;

import javax.swing.*;

/**
 * Panel de alertas.
 */
public class PanelDeAlertas {
    /**
     * Muestra una alerta con el mensaje recibido.
     * @param mensaje Mensaje que se va a mostrar en la alerta. mensaje != null.
     * @param icon Icono de la alerta.
     */
    public static void mostrarAlerta(String mensaje, int icon) {
        JOptionPane.showMessageDialog(null, mensaje, "important", icon);
    }
}
