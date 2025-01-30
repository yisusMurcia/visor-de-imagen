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

import javax.swing.*;

/**
 * Panel donde se entran los datos de la matriz de convoluci�n.
 */
@SuppressWarnings("serial")
public class PanelMatriz extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campos donde se indican los valores de la matriz de convoluci�n.
     */
    private JTextField factores[][];

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel para recibir los datos de la matriz de convoluci�n.
     */
    public PanelMatriz( )
    {
        int dimension = InterfazVisorImagen.DIMENSION_CONVOLUCION;

        factores = new JTextField[dimension][dimension];

        // Establece el distribuidor gr�fico
        setLayout( new GridLayout( dimension, dimension ) );

        // Crea, inicializa y adiciona los campos de texto
        for( int i = 0; i < dimension; i++ )
            for( int j = 0; j < dimension; j++ )
            {
                factores[ i ][ j ] = new JTextField( "0" );
                add( factores[ i ][ j ] );
            }
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Limpia los valores de los factores dados.
     */
    public void limpiar( )
    {
        for( int i = 0; i < InterfazVisorImagen.DIMENSION_CONVOLUCION; i++ )
            for( int j = 0; j < InterfazVisorImagen.DIMENSION_CONVOLUCION; j++ )
                factores[ i ][ j ].setText( "0" );
    }

    /**
     * Retorna la matriz de convoluci�n definida por el usuario.
     * @return La matriz de convoluci�n.
     */
    public double[][] darMatriz( )
    {
        int dimension = InterfazVisorImagen.DIMENSION_CONVOLUCION;
        double matriz[][] = new double[dimension][dimension];
        boolean error = false;
        for( int i = 0; i < dimension && !error; i++ )
            for( int j = 0; j < dimension && !error; j++ )
            {
                try
                {
                    matriz[ i ][ j ] = Double.parseDouble( factores[ i ][ j ].getText( ) );
                }
                catch( Exception e )
                {
                    JOptionPane.showMessageDialog( this, "Factor inv�lido: " + factores[ i ][ j ].getText( ), "Matriz de Convoluci�n", JOptionPane.ERROR_MESSAGE );
                    factores[ i ][ j ].setText( "0" );
                    error = true;
                    matriz = null;
                }
            }
        return matriz;
    }
}