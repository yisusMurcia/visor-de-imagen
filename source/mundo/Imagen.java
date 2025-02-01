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
package mundo;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

/**
 * Imagen de mapa de colores.
 */
public class Imagen
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Matriz de colores de la imagen.
     */
    private int[][] bitmap;

    /**
     * Ancho de la imagen.
     */
    private int ancho;

    /**
     * Alto de la imagen.
     */
    private int alto;

    /**
     * Ruta de la imagen.
     */
    private String ruta;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una imagen a partir de la ruta del archivo donde esta la imagen original en BMP. La imagen numera los p�xeles desde la esquina superior izquierda <br>
     * de la imagen con (0,0). La coordenada X ve de 0 hasta el ancho-1 y la coordenada Y va de 0 a el alto-1 Si la imagen es de ancho mayor al ANCHO_MAXIMO <br>
     * o con altura mayor a ALTO_MAXIMO, la imagen se recorta hasta los l�mites.
     * @param pRuta Ruta de la imagen. pRuta != null && pRuta != "".
     * @throws IOException Error al leer el archivo.
     */
    public Imagen( String pRuta ) throws IOException
    {
        ruta = pRuta;
        cargarImagen( ruta );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el color de un pixel seg�n su ubicaci�n en la imagen.
     * @param pX Coordenada horizontal.
     * @param pY Coordenada vertical.
     * @return El color del pixel de coordenadas (x,y) o null en caso de que las coordenadas sobrepasen los l�mites de la imagen.
     */
    public Color darColorPixel( int pX, int pY )
    {
        Color color = null;
        if( pX >= ancho || pY >= alto )
        {
            color = null;
        }
        else
        {
            color = new Color(bitmap[ pY ][ pX ]);
        }
        return color;
    }

    /**
     * Retorna el alto en pixeles de la imagen.
     * @return El alto de la imagen.
     */
    public int darAlto( )
    {
        return alto;
    }

    /**
     * Retorna el ancho en pixeles de la imagen.
     * @return El ancho de la imagen.
     */
    public int darAncho( )
    {
        return ancho;
    }

    /**
     * Carga la imagen que se encuentra en el archivo.
     * @param pArchivo Nombre y ruta del archivo.
     * @throws IOException Error al cargar la imagen.
     */
    private void cargarImagen( String pArchivo ) throws IOException
    {
        File archivo = new File( pArchivo );
        BufferedImage bmp;

        try
        {
            bmp = ImageIO.read( archivo );
        }
        catch( IOException e )
        {
            throw new IOException( "No se encuentra la imagen" );
        }

        ancho = bmp.getWidth( );
        alto = bmp.getHeight( );
        bitmap = new int[alto][ancho];

        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho; j++ )
            {
                bitmap[i][ j ] = bmp.getRGB( j, i );
            }
        }
    }

    /**
     * Retorna el mapa de bits como una BufferdImage.
     * @return Imagen como objeto BufferedImage.
     */
    public BufferedImage darImagenBuffer( )
    {
        BufferedImage imagen = new BufferedImage( ancho, alto, BufferedImage.TYPE_INT_RGB );
        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho; j++ )
            {
                imagen.setRGB( j, i, bitmap[ i ][ j ]);
            }
        }
        return imagen;
    }

    /**
     * Convierte la imagen en negativo.
     * El negativo se calcula cambiando cada componente RGB, tomando el valor absoluto de restarle al componente 255.
     */
    public void convertirNegativo( ) {
        // Recorre la matriz y calcula los componentes del nuevo color
        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho; j++ )
            {
                Color pixel = new Color(bitmap[ i ][ j ]);

                int nuevoR = Math.abs( pixel.getRed( ) - 255 );

                int nuevoG = Math.abs( pixel.getGreen( ) - 255 );
                int nuevoB = Math.abs( pixel.getBlue( ) - 255 );
                bitmap[ i ][ j ] = new Color( nuevoR, nuevoG, nuevoB ).getRGB();
            }
        }
    }

    /**
     * Refleja la imagen. <br>
     * Consiste en intercambiar las columnas enteras de la imagen, de las finales a la iniciales.
     */
    public void reflejarImagen( )
    {
        // Recorre la matriz hasta la mitad para intercambiar los colores de la columna
        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho / 2; j++ )
            {
                int temporal = bitmap[ i ][ j ];
                bitmap[ i ][ j ] = bitmap[ i ][ ancho - 1 - j ];
                bitmap[ i ][ ancho - 1 - j ] = temporal;
            }
        }
    }

    /**
     * Binarización: Consiste en llevar cada pixel de una imagen a negro o blanco. Para ello se requiere un umbral: si el color del pixel est� <br>
     * por encima o igual se lleva a blanco y si está por debajo se lleva a negro.
     * @param pUmbral Umbral para la binarización.
     */
    public void binarizarImagen( double pUmbral )
    {
        // Recorre la matriz de la imagen. Aquellos puntos con color menor o
        // igual al umbral los lleva a blanco y los mayores al negro.
        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho; j++ )
            {
                Color pixel = new Color(bitmap[ i ][ j ]);
                int promedio = ( pixel.getBlue( ) + pixel.getGreen( ) + pixel.getRed( ) ) / 3;
                if( promedio < pUmbral )
                {
                    bitmap[ i ][ j ] = Color.BLACK.getRGB();
                }
                else
                {
                    bitmap[ i ][ j ] = Color.WHITE.getRGB();
                }
            }
        }
    }

    /**
     * Pixelamiento: Consiste en dividir la imagen en peque�as regiones de pixeles y para cada una de esas regiones cambiar el color de los pixeles al <br>
     * color promedio de dicha regi�n. En este ejemplo, la regi�n se dimensiona con los divisores m�s peque�os del ancho y el alto de la imagen.
     */
    public void pixelarImagen( )
    {
        // Los p�xeles son divisores de las dimensiones de la imagen
        int anchoPixel = menorDivisorMayorAUno( ancho );
        int altoPixel = menorDivisorMayorAUno( alto );

        // Recorre la matriz por regiones para modificarla
        for( int x = 0; x < ancho; x += anchoPixel )
        {
            for( int y = 0; y < alto; y += altoPixel )
            {
                // Obtiene el color medio de la regi�n
                Color colorPromedio = colorPromedio( x, y, x + anchoPixel - 1, y + altoPixel - 1 );
                // Cambia el color de la regi�n al promedio
                cambiarColorRegion( colorPromedio, x, y, x + anchoPixel - 1, y + altoPixel - 1 );
            }
        }
    }

    /**
     * Escala de grises: Para ello promedia los componentes de cada pixel y crea un nuevo color donde cada componente (RGB) tiene el valor de dicho promedio.
     */
    public void convertirAGrises( )
    {
        // Recorre la matriz de la imagen para pasarla a gris.
        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho; j++ )
            {
                Color pixel = new Color(bitmap[ i ][ j ]);
                int rgbGris = ( pixel.getBlue( ) + pixel.getGreen( ) + pixel.getRed( ) ) / 3;
                bitmap[ i ][ j ] = new Color( rgbGris, rgbGris, rgbGris ).getRGB();
            }
        }
    }

    /**
     * Convoluci�n: Opera la imagen con la matriz de convoluci�n dada por el usuario.
     * @param pConvolucion Matriz cuadrada de dimensi�n impar. pConvolucion != null.
     * @param pDimension Dimensión de la matriz de convolución. Dimension es válido para el contenido de la matriz.
     */
    public void aplicarOperadorConvolucion( double[][] pConvolucion, int pDimension )
    {
        // Obtiene una copia de la imagen original, pero con un marco
        // de píxeles negros para operar fácilmente las esquinas de la imagen
        // con la matriz de convoluci�n
        Color copiaBorde[][] = copiarConBorde( pDimension / 2 );

        // Calcula la suma de los factores de convolución
        double sumaConvolucion = 0;
        for( int i = 0; i < pDimension; i++ )
        {
            for( int j = 0; j < pDimension; j++ )
            {
                sumaConvolucion += pConvolucion[ i ][ j ];
            }
        }

        // Recorre la matriz de píxeles para cambiar la imagen
        for( int i = 0; i < alto; i++ )
        {
            for( int j = 0; j < ancho; j++ )
            {
                // Para cada p�xel realiza el c�lculo recorriendo la matriz de convoluci�n
                double sumaRed = 0;
                double sumaGreen = 0;
                double sumaBlue = 0;

                // La divisi�n se hace en la mayor�a de los casos (excepto en los bordes)
                // Restando sobre la suma de los factores de convoluci�n
                double divisor = sumaConvolucion;

                // La suma se hace con los p�xeles de la imagen original
                for( int k = -pDimension / 2; k <= pDimension / 2; k++ )
                {
                    for( int l = -pDimension / 2; l <= pDimension / 2; l++ )
                    {
                        sumaRed += pConvolucion[ k + pDimension / 2 ][ l + pDimension / 2 ] * copiaBorde[ i + k + pDimension / 2 ][ j + l + pDimension / 2 ].getRed( );
                        sumaGreen += pConvolucion[ k + pDimension / 2 ][ l + pDimension / 2 ] * copiaBorde[ i + k + pDimension / 2 ][ j + l + pDimension / 2 ].getGreen( );
                        sumaBlue += pConvolucion[ k + pDimension / 2 ][ l + pDimension / 2 ] * copiaBorde[ i + k + pDimension / 2 ][ j + l + pDimension / 2 ].getBlue( );

                        // Si es un p�xel del borde no cuenta para el divisor
                        if( i + l < 0 || i + l > alto || j + k < 0 || j + k > ancho )
                        {
                            divisor -= pConvolucion[ k + pDimension / 2 ][ l + pDimension / 2 ];
                        }
                    }
                }

                if( divisor > 0 )
                {
                    sumaRed /= divisor;
                    sumaGreen /= divisor;
                    sumaBlue /= divisor;

                    if( sumaRed > 255 )
                    {
                        sumaRed = 255;
                    }
                    else if( sumaRed < 0 )
                    {
                        sumaRed = 0;
                    }

                    if( sumaGreen > 255 )
                    {
                        sumaGreen = 255;
                    }
                    else if( sumaGreen < 0 )
                    {
                        sumaGreen = 0;
                    }

                    if( sumaBlue > 255 )
                    {
                        sumaBlue = 255;
                    }
                    else if( sumaBlue < 0 )
                    {
                        sumaBlue = 0;
                    }

                    // Cambia el p�xel en la imagen
                    bitmap[ i ][ j ] = new Color( ( int )sumaRed, ( int )sumaGreen, ( int )sumaBlue ).getRGB();
                }
                else
                {
                    if( sumaRed > 255 )
                    {
                        sumaRed = 255;
                    }
                    else if( sumaRed < 0 )
                    {
                        sumaRed = 0;
                    }

                    if( sumaGreen > 255 )
                    {
                        sumaGreen = 255;
                    }
                    else if( sumaGreen < 0 )
                    {
                        sumaGreen = 0;
                    }

                    if( sumaBlue > 255 )
                    {
                        sumaBlue = 255;
                    }
                    else if( sumaBlue < 0 )
                    {
                        sumaBlue = 0;
                    }

                    // Cambia el p�xel en la imagen
                    bitmap[ i ][ j ] = new Color( ( int )sumaRed, ( int )sumaGreen, ( int )sumaBlue ).getRGB();
                }
            }
        }
    }

    /**
     * Retorna el color promedio de la imagen.
     * @return El color promedio de toda la imagen.
     */
    public Color colorPromedio( )
    {
        return colorPromedio( 0, 0, ancho - 1, alto - 1 );
    }

    /**
     * Busca el color promedio de la regi�n de la imagen El color promedio es formado por los promedios de rojos, verdes y azules de cada pixel.
     * @param pXInicial Coordenada x del pixel de inicio.
     * @param pYInicial Coordenada y del pixel de inicio.
     * @param pXFinal Coordenada x del pixel final.
     * @param pYFinal Coordenada y del pixel final.
     * @return Color promedio de la regi�n.
     */
    private Color colorPromedio( int pXInicial, int pYInicial, int pXFinal, int pYFinal )
    {
        int valorMedioRojo = 0, valorMedioVerde = 0, valorMedioAzul = 0;
        int totalPixeles = ( pXFinal - pXInicial + 1 ) * ( pYFinal - pYInicial + 1 );

        // Recorre la región para promediar los componentes de los colores
        for( int i = pYInicial; i <= pYFinal; i++ )
        {
            for( int j = pXInicial; j <= pXFinal; j++ )
            {
                Color color = new Color(bitmap[ i ][ j ]);
                valorMedioRojo += color.getRed( );
                valorMedioVerde += color.getGreen( );
                valorMedioAzul += color.getBlue( );
            }
        }

        valorMedioRojo /= totalPixeles;
        valorMedioVerde /= totalPixeles;
        valorMedioAzul /= totalPixeles;
        return new Color( valorMedioRojo, valorMedioVerde, valorMedioAzul );
    }

    /**
     * Calcula el menor divisor del n�mero dado que sea mayor a 1.
     * @param pNumero Al que se le buscar� el divisor.
     * @return Divisor mayor a uno del n�mero.
     */
    private int menorDivisorMayorAUno( int pNumero )
    {
        boolean encontrado = false;
        // Si el número es par el divisor menor es 2
        int divisor = 2;

        if( pNumero % divisor != 0 )
        {
            // Si el n�mero es impar le busca un divisor impar
            divisor = 3;
            while( divisor < pNumero && !encontrado )
            {
                if( pNumero % divisor == 0 )
                {
                    encontrado = true;
                }
                else
                {
                    divisor += 2;
                }
            }
        }

        return divisor;
    }

    /**
     * Cambia el color de los pixeles de la regi�n al dado como par�metro.
     * @param pColor Color de la nueva regi�n.
     * @param pXInicial Coordenada x del pixel de inicio.
     * @param pYInicial Coordenada y del pixel de inicio.
     * @param pXFinal Coordenada x del pixel final.
     * @param pYFinal Coordenada y del pixel final.
     */
    private void cambiarColorRegion( Color pColor, int pXInicial, int pYInicial, int pXFinal, int pYFinal )
    {
        for( int i = pYInicial; i <= pYFinal && i < alto; i++ )
        {
            for( int j = pXInicial; j <= pXFinal && j < ancho; j++ )
            {
                bitmap[ i ][ j ] = pColor.getRGB();
            }
        }
    }

    /**
     * Crea una copia de la imagen pero le adiciona un borde de pixeles de color negro, esto con el fin de poder operar con m�s facilidad la matriz de <br>
     * convoluci�n con las esquinas de la imagen, y sin alterar el resultado de los bordes.
     * @param pBorde Ancho en pixeles del borde (sobre un lado).
     * @return Copia de la imagen (mapa de colores).
     */
    private Color[][] copiarConBorde( int pBorde )
    {
        // Crea una copia de la imagen original que incluye un marco de p�xeles negros
        Color[][] copia = new Color[alto + 2 * pBorde][ancho + 2 * pBorde];

        // Recorre la imagen pero incluye el borde
        for( int i = 0; i < alto + pBorde * 2; i++ )
        {
            for( int j = 0; j < ancho + pBorde * 2; j++ )
            {
                // Si el p�xel es del borde, es de color negro
                if( i < pBorde || i >= alto + pBorde || j < pBorde || j >= ancho + pBorde )
                {
                    copia[ i ][ j ] = Color.BLACK;

                }
                else
                // Si no lo toma de la imagen
                {
                    copia[ i ][ j ] = new Color( bitmap[ i - pBorde ][ j - pBorde ]);
                }
            }
        }
        return copia;
    }

    /**
     * Rota la matriz bitmap
     * intercambia el ancho por alto y copia los valores de cada fila invertidos en cada columna
     */
    public void rotarImagen(){
        int [][] matrizRotada = new int[ancho][alto];
        for(int i = 0; i < alto; i ++){
            int[] vector = bitmap[i];
            for(int j = 0; j < ancho; j++){
                matrizRotada[j][i] = vector[ancho -1 - j];
            }
        }

        bitmap = matrizRotada;

        //Actualizar ancho y alto
        int altoTemp = alto;
        alto = ancho;
        ancho = altoTemp;
    }

    // -----------------------------------------------------------------
    // Puntos de extensión
    // -----------------------------------------------------------------

    /**
     * M�todo de extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo de extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}