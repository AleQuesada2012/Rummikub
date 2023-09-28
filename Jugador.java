import java.util.*;

public class Jugador {

    private String Nombre;
    private int puntos;
    private ArrayList<Ficha> fichasEnMano;
    private boolean MiTurno;
    private boolean ganador;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Ficha> getFichasEnMano() {
        return fichasEnMano;
    }

    public void setFichasEnMano(ArrayList<Ficha> fichasEnMano) {
        this.fichasEnMano = fichasEnMano;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public boolean isMiTurno() {
        return MiTurno;
    }

    public void setMiTurno(boolean miTurno) {
        MiTurno = miTurno;
    }

    public int cantFichas(){
        return fichasEnMano.size();
    }

    public void agregarFicha(Ficha ficha) {
        fichasEnMano.add(ficha);
    }

    public void jugarFicha(Ficha ficha) {
        fichasEnMano.remove(ficha);
    }

}