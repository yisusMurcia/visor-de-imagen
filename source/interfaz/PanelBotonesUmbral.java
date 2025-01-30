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
 * Panel de los botones del umbral de binarizaci�n.
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
     * Bot�n aceptar.
     */
    private JButton botonAceptar;

    /**
     * Bot�n cancelar.
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Di�logo al que pertenece el panel.
     */
    private DialogoUmbralBinarizacion dialogo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones del umbral de binarizaci�n.
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
     * @param pEvento Evento que gener� la acci�n. pEvento != null.
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