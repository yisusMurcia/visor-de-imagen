/**
 *Visor de imaganes
 @author: Jesus Antonio Murcia - Luis Fernando Lopez
 *Fecha: 1/29/2025
 */

package interfaz;

import mundo.GuardarImagen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
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
     * Dimension para la convolucion.
     */
    public static final int DIMENSION_CONVOLUCION = 3;

    /**
     * Panel de la imagen.
     */
    private final PanelImagen panelImagen;

    /**
     * Panel para cargar la imagen.
     */
    private final PanelCargarImagen panelCargarImagen;

    /**
     * Crea la interfaz para el visor de imagenes.
     */
    public InterfazVisorImagen( )
    {
        setTitle( "Visor de imagenes" );
        setSize( 731, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Establece el distribuidor grafico
        setLayout( new BorderLayout( ) );
        setLocationRelativeTo(null);

        // Crea y adiciona el panel del banner

        PanelBanner panelBanner = new PanelBanner();
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

        PanelBotones panelBotones = new PanelBotones(this);
        panel.add(panelBotones);

        add( panel, BorderLayout.PAGE_END );
    }

    /**
     * Devuelve la imagen que se esta pintando.
     * @return La imagen que se esta pintando.
     */
    public BufferedImage getBufferedImage(){

        return panelImagen.getImagenPintar();
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
            GuardarImagen.guardarImagen(panelImagen.getImagenPintar(), "imagenOriginal");
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
     * Presenta el dialogo de definicion del umbral de binarizacion.
     */
    public void presentarDialogoUmbral( )
    {
        DialogoUmbralBinarizacion dialogoUmbral = new DialogoUmbralBinarizacion( this );
        dialogoUmbral.setVisible( true );
    }

    /**
     * Binariza la imagen.
     * @param pUmbral Umbral de binarizacion.
     */
    public void binarizarImagen( double pUmbral )
    {
        panelImagen.binarizarImagen( pUmbral );
    }

    /**
     * Pixela la imagen.
     */
    public void pixelarImagen( ) {
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
     * Presenta el dialogo de definicion de la matriz de convolucion.
     */
    public void presentarDialogoMatrizConvolucion( )
    {
        DialogoMatrizConvolucion dialogoMatriz = new DialogoMatrizConvolucion( this );
        dialogoMatriz.setVisible( true );
    }

    /**
     * Aplica el operador de convolucion representado en la matriz.
     * @param pConv Matriz de convolucion.
     */
    public void aplicarOperadorConvolucion(double[][] pConv)
    {
        panelImagen.aplicarOperadorConvolucion( pConv );
    }
    /**
     * Rotar la imagen.
     */
    public void rotar( )
    {
        panelImagen.rotar( );
    }

    /**
     * Reastaura la imagen.
     */
    public void restaurar( )
    {
        panelImagen.restaurarImagen( );
    }
}
