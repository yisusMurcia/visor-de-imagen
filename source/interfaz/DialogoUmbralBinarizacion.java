/**
 *Visor de imáganes
 @author: Jesús Antonio Murcia - Luis Fernando Lopez
  *Fecha: 1/29/2025
 */
package interfaz;

import java.awt.*;

import javax.swing.*;

/**
 * Dialogo para pedir el umbral para la binarizacion.
 */
@SuppressWarnings("serial")
public class DialogoUmbralBinarizacion extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Panel del umbral.
     */
    private final PanelUmbral panelUmbral;

    /**
     * Panel de los botones.
     */
    private PanelBotonesUmbral panelBotones;

    /**
     * Interfaz padre.
     */
    private InterfazVisorImagen principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el dialogo para el umbral de la binarización.
     * @param pPrincipal Ventana del diálogo.
     */
    public DialogoUmbralBinarizacion( InterfazVisorImagen pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Umbral de binarización" );
        setSize( 250, 90 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        // Establece el distribuidor grafico
        setLayout( new BorderLayout( ) );

        // Crea, inicializa y adiciona el panel
        panelUmbral = new PanelUmbral( );

        // Sugiere como umbral el color promedio de toda la imagen
        Color promedio = principal.colorPromedio( );
        double umbral = (double) (promedio.getBlue() + promedio.getGreen() + promedio.getRed()) / 3;
        panelUmbral.asignarUmbral( umbral );
        add( panelUmbral, BorderLayout.CENTER );

        // Crea y adiciona el panel de botones
        panelBotones = new PanelBotonesUmbral( this );
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
        double umbral = panelUmbral.darUmbral( );
        if( umbral != -1 )
        {
            principal.binarizarImagen( umbral );
        }
        setVisible( false );
    }

    /**
     * Procesa el cancelar del panel de botones.
     */
    public void cancelar( )
    {
        setVisible( false );
    }
}