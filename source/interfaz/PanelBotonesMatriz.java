
package interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Panel de los botones de la matriz de convoluci�n.
 */
@SuppressWarnings("serial")
public class PanelBotonesMatriz extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Aceptar.
     */
    public final static String ACEPTAR = "aceptar";

    /**
     * Limpiar.
     */
    public final static String LIMPIAR = "limpiar";

    /**
     * Cancelar.
     */
    public final static String CANCELAR = "cancelar";

    // -----------------------------------------------------------------
    // Elementos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Boton aceptar.
     */
    private JButton butAceptar;

    /**
     * Boton limpiar.
     */
    private JButton butLimpiar;

    /**
     * Boton cancelar.
     */
    private JButton butCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Diálogo al que pertenece este panel.
     */
    private DialogoMatrizConvolucion dialogo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones de la matriz de convolucion.
     * @param pDialogo Di�logo al que pertenece este panel. pDialogo != null.
     */
    public PanelBotonesMatriz( DialogoMatrizConvolucion pDialogo )
    {
        // Guarda la referencia al padre
        dialogo = pDialogo;

        // Establece el distribuidor gr�fico
        setLayout( new GridLayout( 1, 3 ) );

        // Crea e inicializa los elementos de la interfaz
        butAceptar = new JButton( "Aceptar" );
        butAceptar.setActionCommand( ACEPTAR );
        butAceptar.addActionListener( this );

        butLimpiar = new JButton( "Limpiar" );
        butLimpiar.setActionCommand( LIMPIAR );
        butLimpiar.addActionListener( this );

        butCancelar = new JButton( "Cancelar" );
        butCancelar.setActionCommand( CANCELAR );
        butCancelar.addActionListener( this );

        // Adiciona los elementos al panel
        add( butAceptar );
        add( butLimpiar );
        add( butCancelar );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz
     * @param pEvento Evento que genera la acción. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            dialogo.aceptar( );
        }
        if( comando.equals( LIMPIAR ) )
        {
            dialogo.limpiar( );
        }
        if( comando.equals( CANCELAR ) )
        {
            dialogo.cancelar( );
        }
    }
}