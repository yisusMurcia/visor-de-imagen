package interfaz;

import mundo.GuardarImagen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Panel de los botones.
 */
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
     * Restaurar imagen
     */
    public final static String RESTAURAR = "Restaurar imagen";

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
     * Botón rotar imagen.
     */
    private JButton btnRotar = crearBotonConImagen("Rotar", "./iconos/rotar.png", 40, 40);

    /**
     * Botón restaurar imagen.
     */
    private JButton btnRestore = crearBotonConImagen("Restaurar", "./iconos/restaurar.png", 40, 40);

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

        // Establece el distribuidor grafico
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


        btnRestore.setActionCommand(RESTAURAR);
        btnRestore.addActionListener( this );

        // Adiciona los elementos al panel
        add( butNegativo );
        add( butReflejar );
        add( butBinarizar );
        add( butPixelar );
        add( butEscalaGrises );
        add( butConvolucion );
        add(btnRotar);
        add( btnRestore );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz.
     * @param pEvento Evento de la acción. pEvento != null.
     * guarda la imagen en un archivo.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        switch (comando) {
            case NEGATIVO -> principal.convertirNegativo();
            case REFLEJAR -> principal.reflejarImagen();
            case BINARIZAR -> principal.presentarDialogoUmbral();
            case PIXELAR -> principal.pixelarImagen();
            case ESCALA_GRISES -> principal.convertirAGrises();
            case CONVOLUCION -> principal.presentarDialogoMatrizConvolucion();
            case ROTAR -> principal.rotar();
            case RESTAURAR -> principal.restaurar();
        }
        if(!GuardarImagen.guardarImagen(principal.getBufferedImage(), "imagenEditada")){
            PanelDeAlertas.mostrarAlerta("No se pudo guardar la imagen", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para crear botones con imagen redimensionada
     * @param texto Texto del boton
     * @param rutaimagen Ruta de la imagen
     * @param ancho Ancho de la imagen
     * @param alto Alto de la imagen
     * @return Boton con imagen redimensionada
     */
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