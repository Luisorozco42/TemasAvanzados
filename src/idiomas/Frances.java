package idiomas;

public class Frances implements Traductor{
    @Override
    public void traducir() {
        System.out.println("Traduzco en frances");
    }

    @Override
    public void iniciarTraductor(){
        System.out.println("Iniciando traductor en frances");
    }
}