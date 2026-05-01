package colecciones;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
    static void main() {
        Map<String, String> persona = new HashMap<>();
        persona.put("Nombre", "Diego");
        persona.put("Apellido", "Brando");
        persona.put("Edad", "31");
        System.out.println("Valores del mapa");
        persona.entrySet().forEach(System.out::println);
        persona.put("Edad", "35");
        persona.remove("Apellido");
        System.out.println("Nuevos valores del mapa");
        persona.entrySet().forEach(System.out::println);

        //vamos a iterar sobre los elementos del mapa por separado
        System.out.println("\nIterando los elementos (llave, valor)");
        persona.forEach((key, value) ->{
            System.out.println("Llave: " + key);
            System.out.println("Valor: " + value);
        });
    }
}
