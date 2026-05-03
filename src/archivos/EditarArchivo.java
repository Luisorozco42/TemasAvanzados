package archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EditarArchivo {
    static void main() {
        boolean anexar = false;// esto es para no sobreescribir
        var nombreArchivo = "mi_archivo.tx";
        var archivo = new File(nombreArchivo);

        try{
            //revisar si el archivo existe
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            var nuevoContenido = "Nuevo\nContenido";
            salida.println(nuevoContenido);
            salida.close();
            System.out.println("Se afrefo contenido al archivo!");
        }catch (Exception e){
            System.out.println("Error al escribir en ek archivo" + e.getMessage());
            e.printStackTrace();
        }
    }
}
