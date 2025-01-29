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

import javax.swing.*;

/**
 * Diálogo para pedir el umbral para la binarización.
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
    private PanelUmbral panelUmbral;

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
     * Crea el diálogo para el umbral de la binarización.
     * @param pPrincipal Ventana del diálogo.
     */
    public DialogoUmbralBinarizacion( InterfazVisorImagen pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Umbral de binarización" );
        setSize( 250, 90 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        // Establece el distribuidor gráfico
        setLayout( new BorderLayout( ) );

        // Crea, inicializa y adiciona el panel
        panelUmbral = new PanelUmbral( );

        // Sugiere como umbral el color promedio de toda la imagen
        Color promedio = principal.colorPromedio( );
        double umbral = ( promedio.getBlue( ) + promedio.getGreen( ) + promedio.getRed( ) ) / 3;
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
    // Métodos
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