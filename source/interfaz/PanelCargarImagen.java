package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
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

        // Establece el distribuidor gráfico
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Cargar Imagen" ) );

        // Crea e inicializa los elementos de la interfaz

        lblNombre = new JLabel();
        add(lblNombre, BorderLayout.WEST );


        btnCargar = crearBotonConImagen("Cargar", "./iconos/cargar.png", 20);
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

    /**
     * Metodo para crear botones con imagen redimensionada
     * @param texto Texto del boton
     * @param rutaimagen Ruta de la imagen
     * @param lado Tamaño de la imagen
     * @return Boton con imagen redimensionada
     */
    public static JButton crearBotonConImagen(String texto, String rutaimagen, int lado) {
        // Cargar imagen original
        ImageIcon iconoOriginal = new ImageIcon(rutaimagen);
        // Redimensionar la imagen
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(lado, lado, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        // Crear botón con imagen y texto
        JButton boton = new JButton(texto, iconoRedimensionado);
        boton.setHorizontalTextPosition(SwingConstants.RIGHT);
        boton.setVerticalTextPosition(SwingConstants.CENTER);
        return boton;
    }

}
