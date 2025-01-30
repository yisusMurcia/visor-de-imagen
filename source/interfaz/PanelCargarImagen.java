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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel para cargar la imagen.
 */
@SuppressWarnings("serial")
public class PanelCargarImagen extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante del bot�n de cargar imagen.
     */
    private final static String CARGAR = "Cargar";

    // -----------------------------------------------------------------
    // Elementos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para cargar la imagen.
     */
    private JButton btnCargar;

    /**
     * Etiqueta de la ruta.
     */
    private final JLabel lblNombre;

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
     * Construye el panel para cargar la imagen.
     * @param pPrincipal Una referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public PanelCargarImagen( InterfazVisorImagen pPrincipal )
    {
        // Guarda la referencia al padre
        principal = pPrincipal;

        // Establece el distribuidor gr�fico
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Cargar Imagen" ) );
        setPreferredSize( new Dimension( 1024, 20 ) );

        // Crea e inicializa los elementos de la interfaz

        lblNombre = new JLabel( "Imagen de prueba" );
        add(lblNombre, BorderLayout.WEST );


        btnCargar = new JButton( CARGAR );
        btnCargar.addActionListener( this );
        btnCargar.setActionCommand( CARGAR );
        add( btnCargar, BorderLayout.EAST );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz
     * @param pEvento Evento de la acci�n. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( CARGAR ) )
        {
            principal.cargarImagen( );
        }

    }

    /**
     * Actualiza la ruta de la imagen en el campo de texto.
     * @param nombreImagen Nombre de la imagén añadida
     */
    public void actualizarRuta( String nombreImagen )
    {
        lblNombre.setText(nombreImagen);
    }

}
