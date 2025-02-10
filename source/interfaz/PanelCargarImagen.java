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
public class PanelCargarImagen extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante del boton de cargar imagen.
     */
    private final static String CARGAR = "Cargar";

    // -----------------------------------------------------------------
    // Elementos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Boton para cargar la imagen.
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
    private final InterfazVisorImagen principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel para cargar la imagen.
     * @param pPrincipal Una referencia a la clase principal de la interfaz. pPrincipal != null.
     */
    public PanelCargarImagen( InterfazVisorImagen pPrincipal)
    {
        // Guarda la referencia al padre
        principal = pPrincipal;

        // Establece el distribuidor gr�fico
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Cargar Imagen" ) );
        setPreferredSize( new Dimension( 1024, 20 ) );

        // Crea e inicializa los elementos de la interfaz

        lblNombre = new JLabel();
        add(lblNombre, BorderLayout.WEST );


        btnCargar = new JButton( CARGAR );
        btnCargar.addActionListener( this );
        btnCargar.setActionCommand( CARGAR );
        add( btnCargar, BorderLayout.EAST );

    }

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz
     * @param pEvento Evento de la accion. pEvento != null.
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
     * @param nombreImagen Nombre de la imagén añadide
     */
    public void actualizarRuta( String nombreImagen ) {
        lblNombre.setText(nombreImagen);
    }

}
