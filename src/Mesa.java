public class Mesa {
    private Ficha[][] matrizFichas;

    private int espaciolleno;

    public Mesa() {
        matrizFichas = new Ficha[15][15];
    }


    public void ingresarjugada(Jugada jugada) {
        if (jugada.escaleravaldida() && jugada.secuenciavalida()) {
            int fila = espaciolleno;
            if (matrizFichas[fila][0] != null) {
                espaciolleno++;
            } else {
                for (int i = 0; i < jugada.getJugada().size(); i++) {
                    matrizFichas[fila][i] = jugada.getfichapos(i);
                }
            }
        }

    }



}
