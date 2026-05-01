package maquina_snack;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Snacks {

    private static final List<Snack> snacks;

    //bloque inicializador
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 70));
        snacks.add(new Snack("Refresco", 50));
        snacks.add(new Snack("Sandwich", 1120));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSnacks(){
        var inventarioSnacks = "";
        for (Snack snack :snacks){
            inventarioSnacks += snack +"\n";
        }
        System.out.println("--- Snacks en el inventario ---");
        System.out.println(inventarioSnacks);
    }

    public static   List<Snack> getSnacks() {return snacks;}
}
