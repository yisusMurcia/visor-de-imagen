package mundo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class PersistenciaRuta {
    public static void guardarRuta(String ruta) {
        /**
         * Guarda la ruta en un archivo.
         * @param ruta Ruta que se va a guardar. ruta != null.
         */
        try {
            File archivo = new File("ruta.txt");
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(ruta);
            escritor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Carga la ruta guardada en el archivo.
     */
    public static String cargarRuta() {

        String ruta = null;
        try {
            File archivo = new File("ruta.txt");
            if (!archivo.exists()) {
                return null;
            }
            FileReader lector = new FileReader(archivo);
            char[] contenido = new char[(int) archivo.length()];
            lector.read(contenido);
            ruta = new String(contenido);
            lector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ruta;
    }
}
