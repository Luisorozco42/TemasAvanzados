package idiomas;

public interface Traductor {
    //cabe a destacar que cuando creamos una funcion asi, viene como public y abstracto por default
    void traducir();
    // metodos con implementacion por default
    default void iniciarTraductor(){
        System.out.println("Iniciando traductor");
    }
}
