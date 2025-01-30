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
package uniandes.cupi2.visorImagen.test;

import java.awt.*;
import java.io.*;

import org.junit.Test;
import static org.junit.Assert.*;
import mundo.*;

/**
 * Clase de prueba para el visor de im�genes
 */
public class ImagenTest
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Imagen de prueba
     */
    private Imagen imagen;

    /**
     * alto de la imagen de prueba
     */
    private int alto;

    /**
     * ancho de la imagen de prueba
     */
    private int ancho;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Prepara un escenario con una imagen blanca de 10 x 20
     */
    private void setupEscenario1( )
    {
        try
        {
            // Crea y prepara al calculador de impuestos
            imagen = new Imagen( "test/data/imagen1.bmp" );
            ancho = 10;
            alto = 20;
        }
        catch( IOException e )
        {
            fail( "no pudo crear la imagen" );
        }
    }

    /**
     * Prepara un escenario con una imagen negra del ancho y el alto limite La imagen debe tener tales dimensiones.
     */
    private void setupEscenario2( )
    {
        try
        {

            imagen = new Imagen( "test/data/imagen2.bmp" );
            ancho = imagen.darAncho( );
            alto = imagen.darAlto( );
        }
        catch( IOException e )
        {
            fail( "no pudo crear la imagen" );
        }
    }

    /**
     * Prepara un escenario con una imagen azul del ancho y el alto mayores a los limites. La imagen es de 1000 x 900
     */
    private void setupEscenario3( )
    {
        try
        {
            // Crea y prepara al calculador de impuestos
            imagen = new Imagen( "test/data/imagen3.bmp" );
            ancho = 1000;
            alto = 900;
        }
        catch( IOException e )
        {
            fail( "no pudo crear la imagen" );
        }
    }

    /**
     * Prueba la carga de una imagen menor al m�ximo
     */
    @Test
    public void testCargaImagenPequenia( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // El ancho y el alto de la imagen deben ser el esperado
        assertEquals( ancho, imagen.darAncho( ) );
        assertEquals( alto, imagen.darAlto( ) );

    }

    /**
     * Prueba la carga de una imagen con los limites exactos
     */
    @Test
    public void testCargaImagenExacta( )
    {
        // Configura el escenario de prueba
        setupEscenario2( );

        // El ancho y el alto de la imagen deben ser el esperado
        assertEquals( ancho, imagen.darAncho( ) );
        assertEquals( alto, imagen.darAlto( ) );
    }

    /**
     * Prueba que la imagen cargada corresponda a la imagen totalmente blanca
     */
    @Test
    public void testCargaImagenBlanca( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );

        // Todos los bits de la imagen deben ser blancos
        for( int i = 0; i < imagen.darAncho( ); i++ )
        {
            for( int j = 0; j < imagen.darAlto( ); j++ )
            {
                assertEquals( Color.white.getRGB( ), imagen.darColorPixel( i, j ).getRGB( ) );
            }
        }
    }

    /**
     * Prueba del c�lculo del color promedio
     */
    @Test
    public void testColorPromedioImagenBlanca( )
    {
        // Configura el escenario de prueba
        setupEscenario1( );
        // Valida que el color promedio sea blanco
        assertEquals( Color.white.getRGB( ), imagen.colorPromedio( ).getRGB( ) );
    }

    /**
     * Prueba que la imagen cargada corresponda a la imagen totalmente negra
     */
    @Test
    public void testCargaImagenNegra( )
    {
        // Configura el escenario de prueba
        setupEscenario2( );

        // Todos los bits de la imagen deben ser blancos
        for( int i = 0; i < imagen.darAncho( ); i++ )
        {
            for( int j = 0; j < imagen.darAlto( ); j++ )
            {
                assertEquals( Color.black.getRGB( ), imagen.darColorPixel( i, j ).getRGB( ) );
            }
        }
    }
}