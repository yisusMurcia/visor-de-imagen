/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_visorImagen
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.visorImagen.interfaz;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.swing.*;

import uniandes.cupi2.visorImagen.mundo.*;

/**
 * Panel para dibujar la imagen.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel
{
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
     * Crea el panel donde se proyectará la imagen. Si no encuentra la imagen se presenta el panel vacío.
     */
    public PanelImagen( )
    {
        try
        {
            imagen = new Imagen( "data/imagen.bmp" );
            imagenPintar = imagen.darImagenBuffer( );
            setPreferredSize( new Dimension( imagenPintar.getWidth( ), imagenPintar.getHeight( ) ) );
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
     * Procesa la imagen con el método que permite hacer una binarización.
     * @param pUmbral Umbral de modificación.
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
     * Procesa la imagen con el método que permite aplicar un operador de convolución, expresado como una matriz de valores.
     * @param pConv Matriz de convolución. pConv != null.
     */
    public void aplicarOperadorConvolucion( double pConv[][] )
    {
        if( imagen != null )
        {
            // Aplica la matriz de convolución
            imagen.aplicarOperadorConvolucion( pConv, InterfazVisorImagen.DIMENSION_CONVOLUCION );
            repaint( );
        }
    }

    /**
     * Pinta la imagen.
     * @param pGraphics Gráficas del panel.
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

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Procesa la imagen con el método de extensión 1.
     */
    public void extension1( )
    {
        if( imagen != null )
        {
            String respuesta = imagen.metodo1( );
            JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
            repaint( );
        }
    }

    /**
     * Procesa la imagen con el método de extensión 2.
     */
    public void extension2( )
    {
        if( imagen != null )
        {
            String respuesta = imagen.metodo2( );
            JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
            repaint( );
        }
    }

}