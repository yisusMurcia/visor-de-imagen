/**
 *Visor de im�ganes
 @author: Jes�s Antonio Murcia - Luis Fernando Lopez
 *Fecha: 1/29/2025
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Interfaz del visor de imagenes.
 */
@SuppressWarnings("serial")
public class InterfazVisorImagen extends JFrame
{
    /**
     * Dimensi�n para la convolucion.
     */
    public static final int DIMENSION_CONVOLUCION = 3;

    /**
     * Panel del banner de la aplicacion.
     */
    private PanelBanner panelBanner;

    /**
     * Panel de la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel de los botones.
     */
    private PanelBotones panelBotones;
    private PanelCargarImagen panelCargarImagen;

    /**
     * Crea la interfaz para el visor de imagenes.
     */
    public InterfazVisorImagen( )
    {
        setTitle( "Visor de im�genes" );
        setSize( 731, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Establece el distribuidor gr�fico
        setLayout( new BorderLayout( ) );

        // Crea y adiciona el panel del banner
        panelBanner = new PanelBanner( );
        add(panelBanner, BorderLayout.NORTH );

        // Crea y adiciona el panel de la imagen
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.CENTER );

        JPanel panel = new JPanel( );
        panel.setLayout( new GridLayout( 2, 1 ) );

        // Crea y adiciona el panel de cargar la imagen
        panelCargarImagen = new PanelCargarImagen(this );
        panel.add( panelCargarImagen );

        // Crea y adiciona el panel de botones
        panelBotones = new PanelBotones( this );
        panel.add( panelBotones );

        add( panel, BorderLayout.SOUTH );

        setLocationRelativeTo( null );
        setResizable( false );
    }

    /**
     * Escoge la imagen de la ruta que se quiere cargar.
     */
    public void cargarImagen( )
    {
        JFileChooser fc = new JFileChooser( "./data" );
        int response = fc.showOpenDialog( this );
        if( response == JFileChooser.APPROVE_OPTION )
        {
            File file = fc.getSelectedFile( );
            panelImagen.actualizarImagen( file.getAbsolutePath( ) );
            panelCargarImagen.actualizarRuta( file.getName());

        }else{
            JOptionPane.showMessageDialog( this, "No se ha elegido ninguna imagen" );
        }
    }

    /**
     * Da el color promedio de la imagen.
     * @return El color promedio.
     */
    public Color colorPromedio( )
    {
        return panelImagen.colorPromedio( );
    }

    /**
     * Convierte la imagen en su negativo.
     */
    public void convertirNegativo( )
    {
        panelImagen.convertirNegativo( );
    }

    /**
     * Refleja la imagen.
     */
    public void reflejarImagen( )
    {
        panelImagen.reflejarImagen( );
    }

    /**
     * Presenta el di�logo de definici�n del umbral de binarizaci�n.
     */
    public void presentarDialogoUmbral( )
    {
        DialogoUmbralBinarizacion dialogoUmbral = new DialogoUmbralBinarizacion( this );
        dialogoUmbral.setVisible( true );
    }

    /**
     * Binariza la imagen.
     * @param pUmbral Umbral de binarizaci�n.
     */
    public void binarizarImagen( double pUmbral )
    {
        panelImagen.binarizarImagen( pUmbral );
    }

    /**
     * Pixela la imagen.
     */
    public void pixelarImagen( )
    {
        panelImagen.pixelarImagen( );
    }

    /**
     * Convierte a tonos de gris la imagen.
     */
    public void convertirAGrises( )
    {
        panelImagen.convertirAGrises( );
    }

    /**
     * Presenta el dialogo de definici�n de la matriz de convoluci�n.
     */
    public void presentarDialogoMatrizConvolucion( )
    {
        DialogoMatrizConvolucion dialogoMatriz = new DialogoMatrizConvolucion( this );
        dialogoMatriz.setVisible( true );
    }

    /**
     * Aplica el operador de convoluci�n representado en la matriz.
     * @param pConv Matriz de convoluci�n.
     */
    public void aplicarOperadorConvolucion( double pConv[][] )
    {
        panelImagen.aplicarOperadorConvolucion( pConv );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        panelImagen.extension1( );
    }

    /**
     * Extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        panelImagen.extension2( );
    }
}
