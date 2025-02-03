package interfaz;

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
     * Extensi�n 2.
     */
    public final static String RESTAURAR = "Restaurar imagen";

    // -----------------------------------------------------------------
    // Elementos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón negativo.
     */
    private JButton butNegativo;

    /**
     * Botón reflejar.
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
     * Botón rotar imagen.
     */
    private JButton btnRotar;

    /**
     * Botón restaurar imagen.
     */
    private JButton btnRestore;

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

        btnRotar = new JButton(ROTAR);
        btnRotar.setActionCommand(ROTAR);
        btnRotar.addActionListener( this );

        btnRestore = new JButton( RESTAURAR );
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones de los elementos de la interfaz.
     * @param pEvento Evento de la acci�n. pEvento != null.
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
    }
}