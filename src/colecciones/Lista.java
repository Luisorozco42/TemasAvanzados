package colecciones;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lista {
    static void main() {
        List<String> lista = new ArrayList<>();

        lista.add("Lunes");
        lista.add("Martes");
        lista.add("Miercoles");
        lista.add("Jueves");
        lista.add("Viernes");
        lista.add("Sabado");
        lista.add("Domingo");

        for (String elemento : lista){
            System.out.println("Dia de la semana: " + elemento);
        }

        //otra forma de recorrer listas: Lambda
        lista.forEach( elemento ->{
            System.out.println("elemento: " + elemento);
        });

        //y otra forma de trabajar con foreach
        lista.forEach(System.out::println);

        List<String> nombres = Arrays.asList("Pedro", "Ivonne", "Nohemi");
        System.out.println("Lista de nombres");
        nombres.forEach(System.out::println);
    }

}
