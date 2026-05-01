package colecciones;

import java.util.Set;
import java.util.TreeSet;

public class Sets {
    static void main() {
        //set no permite elementos duplicados como las listas
        Set<String> conjunto = new TreeSet<>();

        conjunto.add("Carlos");
        conjunto.add("Karla");
        conjunto.add("Victoria");

        System.out.println("Elementos TreeSet");
        conjunto.forEach(System.out::println);
        conjunto.remove("Karla");
        System.out.println("\nNuevos elementos del TreeSet");
        conjunto.forEach(System.out::println);
    }
}
