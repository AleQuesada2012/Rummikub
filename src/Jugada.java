import java.util.Vector;

public class Jugada {
    private Vector<Ficha> jugada;

    public void Jugada() {
        jugada = new Vector<>();
    }

    public boolean escaleravaldida(Jugada jugada) {
        for (int i = 0; i < jugada.jugada.size() - 1; i++) {
            Ficha ficha1 = jugada.jugada.get(i);
            Ficha ficha2 = jugada.jugada.get(i + 1);

            if (ficha2.getNum() > ficha1.getNum() + 1 || !ficha2.getColor().equals(ficha1.getColor())) {
                return false;
            }
        }
        return true;
    }
    public boolean secuenciavalida(Jugada jugada){
        for(int i=0; i<jugada.jugada.size();i++){
            Ficha ficha1 = jugada.jugada.get(i);
            Ficha ficha2 = jugada.jugada.get(i + 1);

            if(ficha2.getNum() != ficha1.getNum() && ficha2.getColor().equals(ficha1.getColor()))return false;

        }
        return true;
    }
}

