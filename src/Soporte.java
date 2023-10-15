package src;

import java.util.*;
public class Soporte {

    private  Vector<Ficha>fichas;

    private  int cantfichas;

    public Soporte() {
        this.fichas = new Vector<>();
    }
    public Soporte(Vector<Ficha>fichas1){
        this.fichas = fichas1;
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

    public void setFichas(Vector<Ficha> newTiles) {
        this.fichas.clear(); // Clear the current tiles
        this.fichas.addAll(newTiles); // Add the copied tiles
    }

    public void copiarsoporte(Soporte source) {
        fichas.clear();
        for (Ficha ficha : source.getFichas()) {
            fichas.add(ficha);
        }
    }







}

