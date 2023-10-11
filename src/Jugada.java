import java.util.Vector;

public class Jugada {
    private Vector<Ficha> jugada;

    public void Jugada() {
        jugada = new Vector<>();
    }

    public boolean escaleravaldida(Jugada jugada) {
        if(jugada.jugada.size()>=3) {
            for (int i = 0; i < jugada.jugada.size() - 1; i++) {
                Ficha ficha1 = jugada.jugada.get(i);
                Ficha ficha2 = jugada.jugada.get(i + 1);

                if (ficha2.getNum() > ficha1.getNum() + 1 || !ficha2.getColor().equals(ficha1.getColor())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean secuenciavalida(Jugada jugada) {
        if (jugada.jugada.size() >= 3) {
            for (int i = 0; i < jugada.jugada.size(); i++) {
                Ficha ficha1 = jugada.jugada.get(i);
                Ficha ficha2 = jugada.jugada.get(i + 1);

                if (ficha2.getNum() != ficha1.getNum() && ficha2.getColor().equals(ficha1.getColor())) return false;

            }
            return true;
        }
        return false;
    }

    public int valorjugada(Jugada jugada){
        int cont = 0;
        if(jugada.escaleravaldida(jugada)==true && jugada.secuenciavalida(jugada)==true){
            for(int i=0;i<jugada.jugada.size();i++){
                Ficha ficha = jugada.jugada.get(i);
                
                cont+=ficha.getNum();

            }
        }
        return cont;
    }
}
