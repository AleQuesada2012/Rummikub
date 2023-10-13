import java.util.Vector;

public class Juego {

    private Mesa Tablero;

    private Mesa temporalmesa;

    private Vector<Jugador> jugadores;


    public Juego() {
        Tablero = new Mesa();
        temporalmesa = new Mesa(1);
        jugadores = new Vector<>();
    }

    public void setJugadores(Vector<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void agregarjugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public int determinarOrden() {
        int maxficha = -1;
        int indicedeprimerjugador = 0;

        for (int i = 0; i < this.jugadores.size(); i++) {
            Jugador jugador = this.jugadores.get(i);
            jugador.agregarFicha(Tablero.agarrarpila());
            for (Ficha ficha : jugador.getFichasEnMano().getFichas()) {
                if (ficha.getNum() > maxficha) {
                    maxficha= ficha.getNum();
                    indicedeprimerjugador= i;
                }
            }
        }

        return indicedeprimerjugador;
    }

    public void sumarPuntos(){
        int cont = 0;
        Jugador ganador = null;
        for(Jugador jugador : jugadores){
            if(jugador.getFichasEnMano().getsumadefichas()==0){
                jugador.setGanador(true);
                ganador = jugador;

            }
            else {
                jugador.setPuntos(-(jugador.getFichasEnMano().getsumadefichas()));
                cont += jugador.getFichasEnMano().getsumadefichas();

            }
        }
        if(ganador!=null){
            ganador.setPuntos(cont);
        }
    }

    public void agarrarfichas(){
        for(Jugador jugador :  jugadores) {
            for (int i = 0; i < 13; i++) {
                jugador.agregarFicha((Tablero.agarrarpila()));
            }
        }

    }


    public void actualizarMesa(){
        if(temporalmesa.matrizValida()){
            Tablero.copiarMesa(temporalmesa);
        }
    }

    public void terminarTurno(){
        actualizarMesa();

    }

    public Mesa getTablero() {
        return Tablero;
    }

    public Vector<Jugador> getJugadores() {
        return this.jugadores;
    }
}

