package mundo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GuardarImagen {
    public static boolean guardarImagen(BufferedImage imagen, String nombre) {
        /**
         * Guarda la imagen en un archivo, retorna un booleano indicando el éxito de la operación.
         * @param imagen Imagen que se va a guardar. imagen != null.
         * @param nombre Nombre del archivo donde se va a guardar la imagen. nombre != null.
         */
        try {
            File archivo = new File(nombre + ".png");
            ImageIO.write(imagen, "png", archivo);
        } catch (IOException | IllegalArgumentException e) {
            return false;
        }

        return true;
    }
}
