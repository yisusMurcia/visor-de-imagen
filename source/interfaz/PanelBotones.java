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
    public final static String CONVOLUCION = "Convolucion";

    /**
     * Rotar
     */
    public final static String ROTAR = "Rotar";

    /**
     * Extensi�n 2.
     */
    public final static String OPCION_2 = "Opcion 2";

    // -----------------------------------------------------------------
    // Elementos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón negativo.
     */
    private JButton butNegativo = crearBotonConImagen("Negativo", "./iconos/negativo.png", 40, 40);

    /**
     * Botón reflejar.
     */
    private JButton butReflejar = crearBotonConImagen("Reflejar", "./iconos/reflejar.png", 40, 40);

    /**
     * Botón binarizar.
     */
    private JButton butBinarizar = crearBotonConImagen("Binarizar", "./iconos/binarizar.png", 40, 40);

    /**
     * Botón pixelar.
     */
    private JButton butPixelar = crearBotonConImagen("Pixelar", "./iconos/pixelar.png", 40, 40);

    /**
     * Botón escala de grises.
     */
    private JButton butEscalaGrises = crearBotonConImagen("Escala de grises", "./iconos/grises.png", 40, 40);

    /**
     * Botón operador de convolución.
     */
    private JButton butConvolucion = crearBotonConImagen("Convolucion", "./iconos/convolucion.png", 40, 40);

    /**
     * Botón extensión 1.
     */
    private JButton btnRotar = crearBotonConImagen("Rotar", "./iconos/rotar.png", 40, 40);

    /**
     * Botón extensión 2.
     */
    private JButton butExtension2 = crearBotonConImagen("Opcion 2", "./iconos/opcion2.png", 40, 40);



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
    public PanelBotones( InterfazVisorImagen pPrincipal ) {
        // Guarda la referencia al padre
        principal = pPrincipal;

        // Establece el distribuidor gr�fico
        setLayout(new GridLayout(2, 4));
        setBorder(new TitledBorder("Opciones"));

        // Crear ventana



        // Crea e inicializa los elementos de la interfaz

        butNegativo.setActionCommand(NEGATIVO);
        butNegativo.addActionListener(this);



        butReflejar.addActionListener(this);



        butBinarizar.addActionListener(this);



        butPixelar.addActionListener(this);



        butEscalaGrises.addActionListener( this );



        butConvolucion.addActionListener( this );


        btnRotar.setActionCommand(ROTAR);
        btnRotar.addActionListener( this );



        butExtension2.addActionListener( this );


        // Adiciona los elementos al panel
        add( butNegativo );
        add( butReflejar );
        add( butBinarizar );
        add( butPixelar );
        add( butEscalaGrises );
        add( butConvolucion );
        add(btnRotar);
        add( butExtension2 );

        setVisible(true);
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz.
     * @param pEvento Evento de la accion. pEvento != null.
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
        else if( comando.equals(ROTAR) )
        {
            principal.rotar();
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
    // Método para crear botones con imagen redimensionada
    public static JButton crearBotonConImagen(String texto, String rutaimagen, int ancho, int alto) {
        // Cargar imagen original
        ImageIcon iconoOriginal = new ImageIcon(rutaimagen);
        // Redimensionar la imagen
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
        // Crear botón con imagen y texto
        JButton boton = new JButton(texto, iconoRedimensionado);
        boton.setHorizontalTextPosition(SwingConstants.RIGHT);
        boton.setVerticalTextPosition(SwingConstants.CENTER);
        return boton;
    }
}