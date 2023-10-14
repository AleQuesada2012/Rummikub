package src;

import java.util.Vector;
import java.util.Random;

public class Pila{
    private Vector<Ficha> Stack;
    private Random random;

    public Pila() {
        Stack = new Vector<>();
        random = new Random();
        generarpila();
    }

    public void generarpila() {
        String[] colores = {"N", "A", "Y", "R"};
        for (String color : colores) {
            for (int number = 1; number <= 13; number++) {
                for (int pair = 0; pair < 2; pair++) {
                    Ficha ficha = new Ficha(number, color);
                    Stack.add(ficha);
                }
            }
        }
        Ficha comodin = new Ficha(0,"comodin");
        Ficha comodin2 = new Ficha(0,"comodin");
        Stack.add(comodin);
        Stack.add(comodin2);
    }
    public Ficha eliminar(int pos){
        return  Stack.remove(pos);
    }

    public Ficha agarrarficha() {
        if (Stack.isEmpty()) {
            return null;
        }

        int randomficha = random.nextInt(Stack.size());
        Ficha ficha = eliminar(randomficha);
        return ficha;
    }

    public int getStackSize(){
       return this.Stack.size();
    }

    public Vector<Ficha> getStack(){
        return this.Stack;
    }

}
