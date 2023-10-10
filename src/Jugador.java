public class Jugador {

    private String Nombre;
    private int puntos;
    private  Soporte fichasEnMano;
    private boolean puedoempezar;
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

    public void setFichasEnMano() {
        this.fichasEnMano = new Soporte();
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public boolean isPuedoempezar() {
        return puedoempezar;
    }

    public void setPuedoempezar(boolean miTurno) {
        puedoempezar = miTurno;
    }

    public int cantFichas(){return fichasEnMano.cantfichas;}

    public Soporte Soporte (){return fichasEnMano;}


    public void agregarFicha(Ficha ficha) {
        fichasEnMano.ingresarficha(ficha);
    }

    public void jugarFicha(Ficha ficha) {
        fichasEnMano.usarficha(ficha);
    }

}
