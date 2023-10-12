import java.util.Vector;

public class Jugada {
    private Vector<Ficha> jugada;


    public Jugada() {
        jugada = new Vector<>();
    }

    public  Jugada(Vector<Ficha>lista){
        jugada = lista;
    }

    public boolean escaleravaldida() {
        if(this.jugada.size()>=3) {
            for (int i = 0; i < this.jugada.size() - 1; i++) {
                Ficha ficha1 = this.jugada.get(i);
                Ficha ficha2 = this.jugada.get(i + 1);

                if (ficha2.getNum() > ficha1.getNum() + 1 || !ficha2.getColor().equals(ficha1.getColor())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public boolean secuenciavalida() {
        if (this.jugada.size() >= 3) {
            for (int i = 0; i < this.jugada.size(); i++) {
                Ficha ficha1 = this.jugada.get(i);
                Ficha ficha2 = this.jugada.get(i + 1);

                if (ficha2.getNum() != ficha1.getNum() && ficha2.getColor().equals(ficha1.getColor())) return false;

            }
            return true;
        }
        return false;
    }

    public int valorjugada(){
        int cont = 0;
        if(this.escaleravaldida() && this.secuenciavalida()){
            for(int i=0;i<this.jugada.size();i++){
                Ficha ficha = this.jugada.get(i);
                cont+=ficha.getNum();

            }
        }
        return cont;
    }
    public Ficha getfichapos(int x){
        if(this.jugada.size()<x){
           return this.jugada.get(x);
        }
        return null;
    }
}

