/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_visorImagen
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.visorImagen.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Panel de los botones de la matriz de convolución.
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
     * Botón aceptar.
     */
    private JButton butAceptar;

    /**
     * Botón limpiar.
     */
    private JButton butLimpiar;

    /**
     * Botón cancelar.
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
     * Crea el panel de botones de la matriz de convolución.
     * @param pDialogo Diálogo al que pertenece este panel. pDialogo != null.
     */
    public PanelBotonesMatriz( DialogoMatrizConvolucion pDialogo )
    {
        // Guarda la referencia al padre
        dialogo = pDialogo;

        // Establece el distribuidor gráfico
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
     * @param pEvento Evento que generó la acción. pEvento != null.
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