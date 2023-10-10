import java.util.Vector;

public class Juego {
    private Vector<Jugador>jugadores;

    private Pila fichas;


    public Juego() {
        fichas = new Pila();
        fichas.generarpila();
    }
    private int determinarorden(Vector<Jugador> jugadores) {
        int maxficha = -1;
        int indicedeprimerjugador = 0;

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            jugador.agregarFicha(fichas.agarrarficha());
            for (Ficha ficha : jugador.Soporte().getFichas()) {
                if (ficha.getNum() > maxficha) {
                    maxficha= ficha.getNum();
                    indicedeprimerjugador= i;
                }
            }
        }

        return indicedeprimerjugador;
    }

    public boolean hayganador(){
        int cont = 0;
        for(Jugador jugador : jugadores){
            if(jugador.Soporte().getsumadefichas()==0){
                jugador.setGanador(true);
                return true;
            }
            else {

            }
        }
        return false;
    }



}
