/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_visorImagen
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
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
     * Bot�n aceptar.
     */
    private JButton butAceptar;

    /**
     * Bot�n limpiar.
     */
    private JButton butLimpiar;

    /**
     * Bot�n cancelar.
     */
    private JButton butCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Di�logo al que pertenece este panel.
     */
    private DialogoMatrizConvolucion dialogo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones de la matriz de convoluci�n.
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
    // M�todos
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