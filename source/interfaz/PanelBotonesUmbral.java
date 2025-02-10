
package interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Panel de los botones del umbral de binarizacion.
 */
@SuppressWarnings("serial")
public class PanelBotonesUmbral extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Aceptar.
     */
    public final static String ACEPTAR = "aceptar";

    /**
     * Cancelar.
     */
    public final static String CANCELAR = "cancelar";

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Boton aceptar.
     */
    private JButton botonAceptar;

    /**
     * Boton cancelar.
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Dialogo al que pertenece el panel.
     */
    private DialogoUmbralBinarizacion dialogo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones del umbral de binarizacion.
     * @param pDialogo Di�logo al que pertenece este panel. pDialogo != null.
     */
    public PanelBotonesUmbral( DialogoUmbralBinarizacion pDialogo )
    {
        // Guarda la referencia al di�logo
        dialogo = pDialogo;

        // Establece el distribuidor gr�fico
        setLayout( new GridLayout( 1, 2 ) );

        // Crea e inicializa los elementos de la interfaz
        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );

        // Adiciona los elementos al panel
        add( botonAceptar );
        add( botonCancelar );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz.
     * @param pEvento Evento que genero la accion. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            dialogo.aceptar( );
        }
        if( comando.equals( CANCELAR ) )
        {
            dialogo.cancelar( );
        }
    }
}