import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        Juego juego = new Juego();

        // Create the first player
        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Bocachula");
        jugador1.setFichasEnMano();
        juego.agregarjugador(jugador1);

        // Create the second player
        Jugador jugador2 = new Jugador();
        jugador2.setNombre("EDDY");
        jugador2.setFichasEnMano();
        juego.agregarjugador(jugador2);

        int primerJugadorIndex = juego.determinarOrden();
        Jugador primerJugador = juego.getJugadores().get(primerJugadorIndex);
        juego.agarrarfichas();

        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            Jugador currentPlayer = primerJugador;
            System.out.println(currentPlayer.getNombre() + ", do you want to make a move? (yes/no)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                // Display the user's tiles
                System.out.println("Your Tiles:");
                for (int i = 0; i < primerJugador.getFichasEnMano().getCantfichas(); i++) {
                    Ficha ficha = primerJugador.getFichasEnMano().getficha(i);
                    System.out.println(i + ": " + ficha.getNum() + " " + ficha.getColor());
                }

                System.out.println("Enter the index of the tile you want to play:");
                int tileIndex;
                try {
                    tileIndex = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid tile index.");
                    continue;
                }

                if (tileIndex < 0 || tileIndex >= primerJugador.getFichasEnMano().getCantfichas()) {
                    System.out.println("Invalid tile index. Please enter a valid tile index.");
                    continue;
                }

                // Ask the user for matrix indices
                System.out.println("Enter the row (x) and column (y) indices to place the tile (e.g., 0 1):");
                String matrixIndicesInput = scanner.nextLine();
                String[] matrixIndicesStr = matrixIndicesInput.split(" ");

                if (matrixIndicesStr.length != 2) {
                    System.out.println("Invalid input. Please enter valid row and column indices.");
                    continue;
                }

                int rowIndex = Integer.parseInt(matrixIndicesStr[0]);
                int colIndex = Integer.parseInt(matrixIndicesStr[1]);

                // Get the selected tile from the user's hand
                Ficha selectedTile = primerJugador.getFichasEnMano().getficha(tileIndex);

                // Use the selected tile and matrix indices to update the table (matrix)
                juego.getTablero().ingresarFicha(selectedTile, rowIndex, colIndex);

                // Display the updated game table
                System.out.println("Updated Game Table:");
                juego.getTablero().imprimirMesa();

                // Handle the user's tile selection and the play
                // ...
            }
        }

    }
}

