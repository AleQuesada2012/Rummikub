import java.util.Vector;

public class Juego {

    private Mesa Tablero;


    private Mesa temporalmesa;
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
            for (Ficha ficha : jugador.getFichasEnMano().getFichas()) {
                if (ficha.getNum() > maxficha) {
                    maxficha= ficha.getNum();
                    indicedeprimerjugador= i;
                }
            }
        }

        return indicedeprimerjugador;
    }

    public void sumarpuntos(){
        int cont = 0;
        Jugador ganador = null;
        for(Jugador jugador : jugadores){
            if(jugador.getFichasEnMano().getsumadefichas()==0){
                jugador.setGanador(true);
                ganador = jugador;

            }
            else {
                jugador.setPuntos(-(jugador.getFichasEnMano().getsumadefichas()));
                cont+=jugador.getFichasEnMano().getsumadefichas();

            }
        }
        if(ganador!=null){
            ganador.setPuntos(cont);
        }


    }





}

