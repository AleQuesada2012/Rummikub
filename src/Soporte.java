
import java.util.*;
public class Soporte {

    private  Vector<Ficha>fichas;

    int cantfichas;

    public Soporte() {
        this.fichas = new Vector<>();
    }

    public Vector<Ficha> getFichas(){
        return fichas;
    }

    public Ficha getficha(int x){
        return fichas.get(x);
    }

    public int getCantfichas() {
        return cantfichas;
    }

    public void setCantfichas(int cantfichas) {
        this.cantfichas = cantfichas;
    }

    public int getsumadefichas(){
        int cont = 0;
        for( Ficha ficha : fichas){
            cont+=ficha.getNum();
        }
        return cont;
    }

    public void ingresarficha(Ficha ficha){
        fichas.add(ficha);
        cantfichas++;
    }

    public void usarficha(Ficha ficha){
        fichas.remove(ficha);
        cantfichas--;
    }
}

