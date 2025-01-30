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
import javax.swing.border.TitledBorder;

/**
 * Panel de los botones.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * NEGATIVO.
     */
    public final static String NEGATIVO = "Negativo";

    /**
     * REFLEJAR.
     */
    public final static String REFLEJAR = "Reflejar";

    /**
     * BINARIZAR.
     */
    public final static String BINARIZAR = "Binarizar";

    /**
     * PIXELAR.
     */
    public final static String PIXELAR = "Pixelar";

    /**
     * ESCALA_GRISES.
     */
    public final static String ESCALA_GRISES = "Escala de grises";

    /**
     * CONVOLUCION.
     */
    public final static String CONVOLUCION = "Convolución";

    /**
     * Extensión 1.
     */
    public final static String OPCION_1 = "Opción 1";

    /**
     * Extensi�n 2.
     */
    public final static String OPCION_2 = "Opción 2";

    // -----------------------------------------------------------------
    // Elementos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n negativo.
     */
    private JButton butNegativo;

    /**
     * Bot�n reflejar.
     */
    private JButton butReflejar;

    /**
     * Botón binarizar.
     */
    private JButton butBinarizar;

    /**
     * Botón pixelar.
     */
    private JButton butPixelar;

    /**
     * Botón escala de grises.
     */
    private JButton butEscalaGrises;

    /**
     * Botón operador de convolución.
     */
    private JButton butConvolucion;

    /**
     * Botón extensión 1.
     */
    private JButton butExtension1;

    /**
     * Botón extensión 2.
     */
    private JButton butExtension2;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Una referencia a la clase principal de la interfaz.
     */
    private InterfazVisorImagen principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel de los botones.
     * @param pPrincipal Una referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public PanelBotones( InterfazVisorImagen pPrincipal )
    {
        // Guarda la referencia al padre
        principal = pPrincipal;

        // Establece el distribuidor gr�fico
        setLayout( new GridLayout( 2, 4 ) );
        setBorder( new TitledBorder( "Opciones" ) );

        // Crea e inicializa los elementos de la interfaz
        butNegativo = new JButton( NEGATIVO );
        butNegativo.setActionCommand( NEGATIVO );
        butNegativo.addActionListener( this );

        butReflejar = new JButton( REFLEJAR );
        butReflejar.setActionCommand( REFLEJAR );
        butReflejar.addActionListener( this );

        butBinarizar = new JButton( BINARIZAR );
        butBinarizar.setActionCommand( BINARIZAR );
        butBinarizar.addActionListener( this );

        butPixelar = new JButton( PIXELAR );
        butPixelar.setActionCommand( PIXELAR );
        butPixelar.addActionListener( this );

        butEscalaGrises = new JButton( ESCALA_GRISES );
        butEscalaGrises.setActionCommand( ESCALA_GRISES );
        butEscalaGrises.addActionListener( this );

        butConvolucion = new JButton( CONVOLUCION );
        butConvolucion.setActionCommand( CONVOLUCION );
        butConvolucion.addActionListener( this );

        butExtension1 = new JButton( OPCION_1 );
        butExtension1.setActionCommand( OPCION_1 );
        butExtension1.addActionListener( this );

        butExtension2 = new JButton( OPCION_2 );
        butExtension2.setActionCommand( OPCION_2 );
        butExtension2.addActionListener( this );

        // Adiciona los elementos al panel
        add( butNegativo );
        add( butReflejar );
        add( butBinarizar );
        add( butPixelar );
        add( butEscalaGrises );
        add( butConvolucion );
        add( butExtension1 );
        add( butExtension2 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz.
     * @param pEvento Evento de la acci�n. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( NEGATIVO ) )
        {
            principal.convertirNegativo( );
        }
        else if( comando.equals( REFLEJAR ) )
        {
            principal.reflejarImagen( );
        }
        else if( comando.equals( BINARIZAR ) )
        {
            principal.presentarDialogoUmbral( );
        }
        else if( comando.equals( PIXELAR ) )
        {
            principal.pixelarImagen( );
        }
        else if( comando.equals( ESCALA_GRISES ) )
        {
            principal.convertirAGrises( );
        }
        else if( comando.equals( CONVOLUCION ) )
        {
            principal.presentarDialogoMatrizConvolucion( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}