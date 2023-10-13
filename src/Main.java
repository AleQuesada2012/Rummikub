import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Ficha ficha1 = new Ficha(1, "rojo");
        Ficha ficha2 = new Ficha(1, "azul");

        Ficha comodin = new Ficha(1, "negro");

        Ficha ficha3 = new Ficha(0,"comodin");


        Vector<Ficha> prueba = new Vector<>();


        prueba.add(ficha1);
        prueba.add(ficha2);
        prueba.add(comodin);
        prueba.add(ficha3);

        Jugada jugada = new Jugada(prueba);

        System.out.println(jugada.getSizeJugada());
        System.out.println(jugada.retirarFicha(3));



    }

}
