package interfaz;

import javax.swing.*;

public class PanelDeAlertas {
    public static void mostrarAlerta(String mensaje, int icon) {
        /**
         * Muestra una alerta con el mensaje recibido.
         * @param mensaje Mensaje que se va a mostrar en la alerta. mensaje != null.
         */
        JOptionPane.showMessageDialog(null, mensaje, "important", icon);
    }
}
