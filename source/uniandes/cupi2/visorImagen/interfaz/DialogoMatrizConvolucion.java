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
package uniandes.cupi2.visorImagen.interfaz;

import java.awt.*;

import javax.swing.*;

/**
 * Di�logo para pedir la matriz de convoluci�n.
 */
@SuppressWarnings("serial")
public class DialogoMatrizConvolucion extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Panel de la matriz.
     */
    private PanelMatriz panelMatriz;

    /**
     * Panel de los botones.
     */
    private PanelBotonesMatriz panelBotones;

    /**
     * Interfaz padre.
     */
    private InterfazVisorImagen principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el di�logo para los valores de la matriz de convoluci�n.
     * @param pPrincipal Ventana de la interfaz de la cual hace parte este di�logo. pPrincipal != null.
     */
    public DialogoMatrizConvolucion( InterfazVisorImagen pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Matriz de Convoluci�n" );
        setSize( 280, 125 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        // Establece el distribuidor gr�fico
        setLayout( new BorderLayout( ) );

        // Crea y adiciona el panel de la imagen
        panelMatriz = new PanelMatriz( );
        add( panelMatriz, BorderLayout.CENTER );

        // Crea y adiciona el panel de botones
        panelBotones = new PanelBotonesMatriz( this );
        add( panelBotones, BorderLayout.SOUTH );

        setModal( true );
        setLocationRelativeTo( principal );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Procesa el aceptar del panel de botones.
     */
    public void aceptar( )
    {
        double conv[][] = panelMatriz.darMatriz( );
        if( conv != null )
        {
            principal.aplicarOperadorConvolucion( conv );
        }
        setVisible( false );
    }

    /**
     * Procesa el limpiar del panel de botones.
     */
    public void limpiar( )
    {
        panelMatriz.limpiar( );
    }

    /**
     * Procesa el cancelar del panel de botones.
     */
    public void cancelar( )
    {
        setVisible( false );
    }
}