
package interfaz;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Objects;

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
     * Crea el panel donde se proyecta la imagen, preguntando si desea abrir la última imágen guardada, si no encuentra la imagen se presenta el panel vacío.
     */
    public PanelImagen( )
    {
        try
        {
            //Buscar la imagen original
            File img = new File("imagenOriginal.png");
            int respuesta = 0;
            String ruta = "data/imagen.bmp";
            if(img.exists()){
                respuesta = JOptionPane.showConfirmDialog(this, "¿Desea abrir la última imagen guardada?", "Abrir última imagen", JOptionPane.YES_NO_OPTION);
                if(respuesta == JOptionPane.YES_OPTION){
                    ruta = "imagenOriginal.png";
                }
            }
            imagen = new Imagen(ruta);
            //Actualizar la ruta si la imagen es restaurada
            if(respuesta == JOptionPane.YES_OPTION){
                ruta = PersistenciaRuta.cargarRuta();
                imagen.setRuta(ruta);
            }
            establecerDimension();

            //Guardar datos
            GuardarImagen.guardarImagen(imagenPintar, "imagenOriginal");
            PersistenciaRuta.guardarRuta(ruta);
        }
        catch( IOException e ) {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "No fue posible cargar la imagen, intente de nuevo", JOptionPane.ERROR_MESSAGE );
        }

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la imagen.
     * @return La imagen.
     */
    public BufferedImage getImagenPintar() {
        return imagen.darImagenBuffer();
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
     * Actualiza la imagen y guarda la ruta.
     * @param pRuta La ruta de la imagen nueva.
     */
    public void actualizarImagen( String pRuta )
    {
        try
        {
            imagen = new Imagen( pRuta );
            establecerDimension();
            PersistenciaRuta.guardarRuta(pRuta);
            repaint( );
        }
        catch( IOException e ) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog( this, e.getMessage( ), "No fue posible cargar la imagen, intente de nuevo", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Rota la imagen 90 grados
     */
    public void rotar( ){
        if( imagen != null ) {
            imagen.rotarImagen();
            establecerDimension();
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
     * Calcular la dimensión para que la imagen se ajuste al panel.
     */
    public void establecerDimension( ){
        imagenPintar = imagen.darImagenBuffer();
        if(imagenPintar.getHeight() > getHeight()){
            setPreferredSize( new Dimension( getHeight(), imagenPintar.getHeight()/ imagenPintar.getWidth() * getHeight() ) );
        }else if(imagen.darAncho() > getWidth()){
            setPreferredSize( new Dimension( imagenPintar.getWidth()/ imagenPintar.getHeight() * getWidth(), getWidth() ) );
        }else{
            setPreferredSize( new Dimension( imagenPintar.getWidth(), imagenPintar.getHeight() ) );
        }
    }
}