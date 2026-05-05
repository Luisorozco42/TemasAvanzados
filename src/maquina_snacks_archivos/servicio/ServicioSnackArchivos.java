package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnackArchivos implements IServiciosSnacks {
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    //creamos la lista de tipo snack
    private List<Snack> snacks = new ArrayList<>();

    public ServicioSnackArchivos(){
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;

        try{
            existe = archivo.exists();
            if (existe){
                this.snacks = obtenerSnacks();
            }else {
                //Creamos el archivo
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();//con esto se guarda el archivo en disco
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Error al crear el archivo " + e);
            e.printStackTrace();
        }
        if (!existe){
            cargarSnacksIniciales();
        }
    }

    private List<Snack> obtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for (String linea : lineas){
                String [] lineaSnack = linea.split(",");
                var idSnack = Integer.parseInt(lineaSnack[0]);
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombre, precio);
                //agregamos a la lista el snack
                snacks.add(snack);
            }
        }catch (Exception e){
            System.out.println("Error al recuperar los snacks del archivo" + e);
            e.printStackTrace();
        }
        return snacks;
    }

    private void cargarSnacksIniciales() {
        this.agregarSnack(new Snack("Papas", 70));
        this.agregarSnack(new Snack("Refresco", 50));
        this.agregarSnack(new Snack("Sandwich", 120));
    }

    @Override
    public void agregarSnack(Snack snack) {
        this.snacks.add(snack);
        //guardamos el nuevo snack en el archivo
        agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack) {
        var anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);

        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(snack.escribirSnack());
            salida.close();//Se escribe la informacion en el archivo y lo cierra
        } catch (Exception e) {
            System.out.println("Error al agregar snack: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void mostrarSnacks() {
        System.out.println("--- Snacks en el inventario ---");
        var inventarioSnacks = "";
        for (var snack : this.snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
