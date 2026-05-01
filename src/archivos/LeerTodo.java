package archivos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LeerTodo {
    static void main() {
        var archivo = "mi_archivo.txt";
        try {
            //Leer todas las lineas del archivo
            List<String> lineas = Files.readAllLines(Paths.get(archivo));
            System.out.println("Contenido del archivo:");
//            for (String linea : lineas){
//                System.out.println(linea);
//            }
            lineas.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Error al leer todo el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
