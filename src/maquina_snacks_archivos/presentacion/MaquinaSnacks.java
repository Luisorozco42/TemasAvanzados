package maquina_snacks_archivos.presentacion;

import maquina_snacks_archivos.dominio.Snack;
import maquina_snacks_archivos.servicio.IServiciosSnacks;
import maquina_snacks_archivos.servicio.ServicioSnackArchivos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    static void main() {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);
        //Creamos el objeto para obtener el servicio de snacks
        IServiciosSnacks serviciosSnacks = new ServicioSnackArchivos();
        //Creamos la lista de productos
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de snacks ***");
        serviciosSnacks.mostrarSnacks();// mostar el inventario
        while (!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos, serviciosSnacks);
            }catch (Exception e){
                System.out.println("Ocurrio un error" + e);
            }
            finally {
                System.out.println();// imprime un salto de linea en cada iteracion
            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                Menu:
                1. Comprar Snack
                2. Mostrar Tiquet
                3. Agregar Nuevo Snack
                4. Mostrar inventario snacks
                5. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos, IServiciosSnacks serviciosSnacks){
        var salir = false;

        switch (opcion){
            case 1 -> comprarSnack(consola, productos, serviciosSnacks);
            case 2 -> mostarTicket(productos);
            case 3 -> agregarNuevoSnack(consola, serviciosSnacks);
            case 4 -> listarInventarioSnacks(consola, serviciosSnacks);
            case 5 -> salir = true;
            default -> System.out.println("Opcion Invalida");
        }
        return salir;
    }

    private static void listarInventarioSnacks(Scanner consola, IServiciosSnacks serviciosSnacks) {
        serviciosSnacks.mostrarSnacks();
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos, IServiciosSnacks serviciosSnacks) {
        System.out.print("Que snack quieres comprar (id)?");
        var idSnack = Integer.parseInt(consola.nextLine());
        var estaSnack = false;
        for(Snack snack : serviciosSnacks.getSnacks()){
            if (snack.getIdSnack() == idSnack){
                productos.add(snack);
                System.out.println("Ok, Snack agregado: " + snack);
                estaSnack = true;
                break;
            }
        }

        if (!estaSnack){
            System.out.println("Id del snack no encontrado: " + idSnack);
        }

    }

    private static void mostarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de venta ***";
        var total = 0.0;

        for (Snack producto : productos){
            ticket += "\n\t-" + producto.getNombre() + " -$" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\t -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarNuevoSnack(Scanner consola, IServiciosSnacks serviciosSnacks) {
        System.out.print("Ingrese el nombre del producto a agregar:\s");
        var nombre = consola.nextLine();
        System.out.print("Ingrese el precio del snack:\s");
        var precio = Double.parseDouble(consola.nextLine());

        serviciosSnacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu snack se a agregado correctamente");
        serviciosSnacks.mostrarSnacks();
    }
}
