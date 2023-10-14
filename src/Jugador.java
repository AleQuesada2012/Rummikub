package src;

import java.util.*;

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

    public Soporte getFichasEnMano() {
        return fichasEnMano;
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
    
    public Ficha escogerficha(int x){
        return fichasEnMano.getficha(x);
    }
    public Jugada crearjugada(Vector<Integer> indices) {
        Vector<Ficha> seleccionadas = new Vector<>();

        for (int indice : indices) {
            if (indice >= 0 && indice < fichasEnMano.cantfichas) {
                seleccionadas.add(fichasEnMano.getficha(indice));
            }
        }

        return new  Jugada(seleccionadas);
    }

    public void agregarFicha(Ficha ficha) {
        fichasEnMano.ingresarficha(ficha);
    }
    }






