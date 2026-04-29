import figuras.Circulo;
import figuras.FiguraGeometrica;
import idiomas.Frances;
import idiomas.Ingles;
import idiomas.Traductor;
import metodos.MetodoVariable;
import figuras.Rectangulo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    MetodoVariable.variosParametros("Luis", 10, 20, 30);
    int[] Edades = {5, 10, 20, 34};
    for (int edad : Edades){
        System.out.println("edad = " + edad);
    }

    //Esto da error ya que no se puede instanciar una clase abstracta
    //FiguraGeometrica figuraGeometrica = new FiguraGeometrica();
    //La forma correcta es la del polimorfismo
//    FiguraGeometrica figuraGeometrica = new Rectangulo();
//    figuraGeometrica.dibujar();
//    figuraGeometrica = new Circulo();
//    figuraGeometrica.dibujar();

    //las interfaces no se pueden instanciar, pero si pueden funcionar como super clases
    Traductor ingles = new Ingles();
    ingles.traducir();
    Traductor frances = new Frances();
    frances.iniciarTraductor();
    frances.traducir();
}
