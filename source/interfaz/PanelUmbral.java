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
 * Panel donde se entra el valor del umbral para la binarizaci�n.
 */
@SuppressWarnings("serial")
public class PanelUmbral extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo para indicar el umbral.
     */
    private JTextField txtUmbral;

    /**
     * Etiqueta umbral.
     */
    private JLabel labUmbral;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel para recibir el umbral de binarizaci�n.
     */
    public PanelUmbral( )
    {
        // Establece el distribuidor gr�fico
        setLayout( new GridLayout( 1, 2 ) );

        // Crea, inicializa los elementos de la interfaz y adiciona los componentes gr�ficos
        txtUmbral = new JTextField( );
        txtUmbral.setForeground( Color.BLUE );
        labUmbral = new JLabel( "Umbral:" );
        labUmbral.setHorizontalAlignment( JLabel.CENTER );
        add( labUmbral );
        add( txtUmbral );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el valor del umbral.
     * @return Retorna el valor de umbral ingresado por el usuario, o -1 si no es un valor v�lido.
     */
    public double darUmbral( )
    {
        double umbral = 0;
        try
        {
            umbral = Double.parseDouble( txtUmbral.getText( ) );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Umbral inv�lido: " + txtUmbral.getText( ), "Umbral de Binariaaci�nMatriz de Convoluci�n", JOptionPane.ERROR_MESSAGE );
            txtUmbral.setText( "0" );
            umbral = -1;
        }
        return umbral;
    }

    /**
     * Asigna un nuevo umbral al respectivo campo de texto.
     * @param pUmbral El nuevo umbral.
     */
    public void asignarUmbral( double pUmbral )
    {
        txtUmbral.setText( pUmbral + "" );
    }
}