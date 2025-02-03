
package interfaz;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import mundo.*;

/**
 * Panel para dibujar la imagen.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Imagen que se presenta en el panel.
     */
    private Imagen imagen;

    /**
     * Imagen en un buffer.
     */
    private BufferedImage imagenPintar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel donde se proyecta la imagen. Si no encuentra la imagen se presenta el panel vacío.
     */
    public PanelImagen( )
    {
        try
        {
            imagen = new Imagen( "data/imagen.bmp" );
            imagenPintar = imagen.darImagenBuffer( );
            setPreferredSize( new Dimension( imagenPintar.getWidth( ), imagenPintar.getHeight( ) ) );
            guardarImagen("imagenOriginal");
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "No fue posible cargar la imagen, intente de nuevo", JOptionPane.ERROR_MESSAGE );
        }

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * guardar imagen
     * @param nombre especifica el nombre de la imagen, se guarfa en formato png
     */
    public void guardarImagen(String nombre){
        try {
            File archivo = new File(nombre + ".png");
            ImageIO.write(imagenPintar, "png", archivo);
            System.out.println("Imagen guardada en: " + archivo.getAbsolutePath());
        } catch (IOException|IllegalArgumentException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
    }

    /**
     * Retorna el color promedio de la imagen.
     * @return El color promedio de la imagen.
     */
    public Color colorPromedio( )
    {
        Color promedio = null;
        if( imagen != null )
        {
            promedio = imagen.colorPromedio( );
        }
        return promedio;
    }

    /**
     * Procesa la imagen con el método que permite convertirla en su negativo.
     */
    public void convertirNegativo( )
    {
        if( imagen != null )
        {
            imagen.convertirNegativo( );
            repaint( );
        }
    }

    /**
     * Procesa la imagen con el método que permite calcular su reflejo.
     */
    public void reflejarImagen( )
    {
        if( imagen != null )
        {
            imagen.reflejarImagen( );
            repaint( );
        }
    }

    /**
     * Procesa la imagen con el m�todo que permite hacer una binarizaci�n.
     * @param pUmbral Umbral de modificaci�n.
     */
    public void binarizarImagen( double pUmbral )
    {
        if( imagen != null )
        {
            imagen.binarizarImagen( pUmbral );
            repaint( );
        }
    }

    /**
     * Procesa la imagen con el método que permite hacer un pixelamiento.
     */
    public void pixelarImagen( )
    {
        if( imagen != null )
        {
            imagen.pixelarImagen( );
            repaint( );
        }
    }

    /**
     * Procesa la imagen con el método que permite convertirla a tonos de gris.
     */
    public void convertirAGrises( )
    {
        if( imagen != null )
        {
            imagen.convertirAGrises( );
            repaint( );
        }
    }

    /**
     * Procesa la imagen con el método que permite aplicar un operador de convoluci�n, expresado como una matriz de valores.
     * @param pConv Matriz de convolución. pConv != null.
     */
    public void aplicarOperadorConvolucion( double pConv[][] )
    {
        if( imagen != null )
        {
            // Aplica la matriz de convoluci�n
            imagen.aplicarOperadorConvolucion( pConv, InterfazVisorImagen.DIMENSION_CONVOLUCION );
            repaint( );
        }
    }

    /**
     * Pinta la imagen.
     * @param pGraphics Gr�ficas del panel.
     */
    public void paint( Graphics pGraphics )
    {
        super.paint( pGraphics );
        if( imagen != null )
        {
            imagenPintar = imagen.darImagenBuffer( );
            pGraphics.drawImage( imagenPintar, 0, 0, null, null );
        }
    }

    /**
     * Actualiza la imagen.
     * @param pRuta La ruta de la imagen nueva.
     */
    public void actualizarImagen( String pRuta )
    {
        try
        {
            imagen = new Imagen( pRuta );
            imagenPintar = imagen.darImagenBuffer( );
            setPreferredSize( new Dimension( imagenPintar.getWidth( ), imagenPintar.getHeight( ) ) );
            repaint( );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "No fue posible cargar la imagen, intente de nuevo", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Rota la imagen 90 grados
     */
    public void rotar( )
    {
        if( imagen != null )
        {
            imagen.rotarImagen();
            repaint( );
        }
    }

    /**
     * Restaura la imagen original
     */
    public void restaurarImagen( ){
        actualizarImagen(imagen.getRuta());
    }

    /**
     * Modifca el método repaint para además guardar la edición de la imagen
     */
    @Override
    public void repaint() {
        super.repaint();
        guardarImagen("imagenEditada");
    }
}