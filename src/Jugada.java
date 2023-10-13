import java.util.Vector;

public class Jugada {
    private Vector<Ficha> jugada;


    public Jugada() {
        jugada = new Vector<>();
    }

    public  Jugada(Vector<Ficha>lista){
        jugada = lista;
    }

    public boolean escaleravalida() {
        int escalera = jugada.size();
        if (escalera < 3) {
            return false;
        }
        else {
            Vector<String>color = new Vector<>();
            color.add(this.getfichapos(0).getColor().equals("comodin") ? this.getfichapos(1).getColor() : this.getfichapos(0).getColor());
            color.add("comodin");

            int cont = (this.getfichapos(0).getColor().equals("comodin")) ? this.getfichapos(1).getNum() : this.getfichapos(0).getNum();

            for (int i = 0; i < escalera-1; i++) {
                Ficha currentTile = this.jugada.get(i);
                Ficha siguiente = this.jugada.get(i+1);


                if("comodin".equals(currentTile.getColor())){
                    if(i == 0){
                        continue;
                    }
                }

                if("comodin".equals(siguiente.getColor())) {
                    cont++;
                    continue;
                }

                if (cont +1 != siguiente.getNum() || (!color.contains(currentTile.getColor()) && !color.contains(siguiente.getColor()))) {
                    return false;
                }
                cont++;
            }
        }
        return true;
    }

    public boolean serievalida() {
        int serie = this.jugada.size();
        if (serie < 3) {
            return false;
        } else {
            Vector<String> color = new Vector<>();
            color.add(this.getfichapos(0).getColor());
            int num = (this.getfichapos(0).getColor().equals("comodin")) ? this.getfichapos(1).getNum() : this.getfichapos(0).getNum();
            for (int i = 0; i < serie; i++) {
                Ficha currentTile = this.jugada.get(i);

                if ("comodin".equals(currentTile.getColor())) {
                    continue;
                }

                if (num != currentTile.getNum() || (color.contains(currentTile.getColor()))) {
                    return false;
                } else {
                    color.add(currentTile.getColor());
                }

            }
            return true;
        }
    }
    public int valorjugada(){
        int cont = 0;
        if(this.escaleravalida() && this.serievalida()){
            for(int i=0;i<this.jugada.size();i++){
                Ficha ficha = this.jugada.get(i);
                cont+=ficha.getNum();

            }
        }
        return cont;
    }

    public Ficha retirarficha(Jugada jugada,int x){
        Ficha ficha = jugada.getfichapos(x);
        return ficha;
    }

    public Vector<Ficha> getJugada() {
        return jugada;
    }

    public Ficha getfichapos(int x){
        if(this.jugada.size()<x){
            return this.jugada.get(x);
        }
        return null;
    }

    public int getsizejugada(){
        return this.jugada.size();
    }


}

