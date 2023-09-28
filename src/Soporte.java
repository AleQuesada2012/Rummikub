
import java.util.*;
public class Soporte {

    private  Vector<Ficha>fichas;

    int cantfichas;


    public int getCantfichas() {
        return cantfichas;
    }

    public void setCantfichas(int cantfichas) {
        this.cantfichas = cantfichas;
    }

    public void getFichas() {
        for(Ficha ficha:fichas){
            ficha.getficha();
        }
    }
}
