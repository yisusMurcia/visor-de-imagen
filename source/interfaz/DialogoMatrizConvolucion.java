/**
 *Visor de imáganes
 @author: Jesús Antonio Murcia - Luis Fernando Lopez
  *Fecha: 1/29/2025
 */
package interfaz;

import java.awt.*;

import javax.swing.*;

/**
 * Diálogo para pedir la matriz de convolución.
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
    private final PanelMatriz panelMatriz;

    /**
     * Panel de los botones.
     */
    private PanelBotonesMatriz panelBotones;

    /**
     * Interfaz padre.
     */
    private final InterfazVisorImagen principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el diálogo para los valores de la matriz de convolución.
     * @param pPrincipal Ventana de la interfaz de la cual hace parte este diálogo. pPrincipal != null.
     */
    public DialogoMatrizConvolucion( InterfazVisorImagen pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Matriz de Convolución" );
        setSize( 280, 125 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        // Establece el distribuidor gráfico
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
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Procesa el aceptar del panel de botones.
     */
    public void aceptar( )
    {
        double[][] conv = panelMatriz.darMatriz( );
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