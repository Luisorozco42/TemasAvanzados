package metodos;

public class MetodoVariable {

    static void imprimirNumeros(int... numeros){
        for(int numero : numeros){
            System.out.println("numero = " + numero);
        }
    }
    //regla al usar argumentos variables
    //no se debeen poner antes de agumentos sencillos siempre después
    public static void variosParametros(String nombre, int... numeros){
        System.out.println("nombre = " + nombre);
        imprimirNumeros(numeros);
    }
}
