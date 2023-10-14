package src;

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
            int turno = 1;
            Jugador currentPlayer = primerJugador;
            System.out.println(currentPlayer.getNombre() + ", do you want to make a move? (yes/no)");
            String input = scanner.nextLine();


            System.out.println("Original Game Table:");
            juego.getTablero().imprimirMesa();

            if (input.equalsIgnoreCase("yes")) {

                Vector<Ficha>fichasJugador = juego.copiarFichasEnMano(currentPlayer);

                System.out.println("Your Tiles:");
                for (int i = 0; i < currentPlayer.getFichasEnMano().getCantfichas(); i++) {
                    Ficha ficha = currentPlayer.getFichasEnMano().getficha(i);
                    System.out.println(i + ": " + ficha.getNum() + " " + ficha.getColor());
                }
                // Display the user's tiles

                // Ask the user for the type of move
                System.out.println("Choose your move:");
                System.out.println("1. Play a tile on the table");
                System.out.println("2. Move a tile on the table");
                System.out.println("3. Finish your turn");
                System.out.println("4. Take a tile from the bunch");
                String moveTypeInput = scanner.nextLine();


                if (moveTypeInput.equals("1")) {
                    // Display the current game table
                    // Ask the user for the index of the tile they want to play
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
                    juego.getTemporalmesa().ingresarFicha(selectedTile, rowIndex, colIndex,primerJugador);

                    // Display the updated game table
                    System.out.println("Updated Game Table:");
                    juego.getTemporalmesa().imprimirMesa();

                } else if (moveTypeInput.equals("2")) {
                    // Code for moving a tile on the table
                    System.out.println("Enter the row (x) and column (y) indices of the tile you want to move (e.g., 0 1):");
                    String fromIndicesInput = scanner.nextLine();
                    String[] fromIndicesStr = fromIndicesInput.split(" ");

                    if (fromIndicesStr.length != 2) {
                        System.out.println("Invalid input. Please enter valid row and column indices.");
                        continue;
                    }

                    int fromRowIndex, fromColIndex;

                    try {
                        fromRowIndex = Integer.parseInt(fromIndicesStr[0]);
                        fromColIndex = Integer.parseInt(fromIndicesStr[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid row and column indices.");
                        continue;
                    }

                    // Ask for the target position
                    System.out.println("Enter the row (x) and column (y) indices to place the tile (e.g., 0 1):");
                    String toIndicesInput = scanner.nextLine();
                    String[] toIndicesStr = toIndicesInput.split(" ");

                    if (toIndicesStr.length != 2) {
                        System.out.println("Invalid input. Please enter valid row and column indices.");
                        continue;
                    }

                    int toRowIndex, toColIndex;

                    try {
                        toRowIndex = Integer.parseInt(toIndicesStr[0]);
                        toColIndex = Integer.parseInt(toIndicesStr[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid row and column indices.");
                        continue;
                    }

                    // Perform the tile movement
                    juego.getTemporalmesa().reacomodarFicha(fromRowIndex, fromColIndex, toRowIndex, toColIndex);

                    // Display the updated game table
                    System.out.println("Updated Game Table:");
                    juego.getTemporalmesa().imprimirMesa();
                }


                else if (moveTypeInput.equals("3")) {
                    // Finish the player's turn
                    System.out.println("Turn finished.");

                    if (juego.getTemporalmesa().matrizValida()) {
                        // The table is valid, end the player's turn and proceed to the next player
                        juego.getTablero().copiarMesa(juego.getTemporalmesa());
                        int currentPlayerIndex = (primerJugadorIndex + 1) % juego.getJugadores().size();
                        primerJugadorIndex = currentPlayerIndex;
                        primerJugador = juego.getJugadores().get(currentPlayerIndex);
                    } else {
                        // The table is not valid, print a message, and let the current player rearrange tiles
                        System.out.println("Table is not valid. Please rearrange your tiles.");
                        // You might want to add a mechanism for the player to rearrange tiles here

                        // The table is not valid, print temporalmesa and give the same three options
                        System.out.println("Temporary Table is not valid. Please rearrange your tiles.");

                        currentPlayer.getFichasEnMano().setFichas(fichasJugador);

                        juego.getTemporalmesa().copiarMesa(juego.getTablero());
                        System.out.println("Temporary Table:");
                        juego.getTemporalmesa().imprimirMesa();

                        // Display the user's tiles
                        System.out.println("Your Tiles:");
                        for (int i = 0; i < currentPlayer.getFichasEnMano().getCantfichas(); i++) {
                            Ficha ficha = currentPlayer.getFichasEnMano().getficha(i);
                            System.out.println(i + ": " + ficha.getNum() + " " + ficha.getColor());
                        }

                        // Ask the user for the type of move
                        System.out.println("Choose your move:");
                        System.out.println("1. Play a tile on the table");
                        System.out.println("2. Move a tile on the table");
                        System.out.println("3. Finish your turn");
                        System.out.println("4. grab a tile from the bunch");
                        moveTypeInput = scanner.nextLine();
                    }
                    
                }
                else if (moveTypeInput.equals("4")) {
                    if(juego.getTemporalmesa().matrizValida()){
                // Code for grabbing a tile from the bunch and ending the turn
                Ficha grabbedTile = juego.getTablero().agarrarpila();// Assuming agarrarpila() returns a tile from the bunch
                if (grabbedTile != null) {
                    // The player successfully grabbed a tile
                    System.out.println(currentPlayer.getNombre() + " grabbed a tile from the bunch.");
                    // Add the grabbed tile to the player's hand
                    currentPlayer.getFichasEnMano().ingresarficha(grabbedTile);
                    // End the player's turn
                    System.out.println("Turn finished.");
                    // Proceed to the next player
                    int currentPlayerIndex = (primerJugadorIndex + 1) % juego.getJugadores().size();
                    primerJugadorIndex = currentPlayerIndex;
                    primerJugador = juego.getJugadores().get(currentPlayerIndex);
                }
                }
                else {
                    // The bunch is empty or the player cannot grab more tiles
                        System.out.println("Temporary Table is not valid. Please rearrange your tiles.");

                        currentPlayer.getFichasEnMano().setFichas(fichasJugador);

                        juego.getTemporalmesa().copiarMesa(juego.getTablero());

                        System.out.println("Temporary Table:");
                        juego.getTemporalmesa().imprimirMesa();

                        // Display the user's tiles
                        System.out.println("Your Tiles:");
                        for (int i = 0; i < currentPlayer.getFichasEnMano().getCantfichas(); i++) {
                            Ficha ficha = currentPlayer.getFichasEnMano().getficha(i);
                            System.out.println(i + ": " + ficha.getNum() + " " + ficha.getColor());
                        }

                        // Ask the user for the type of move
                        System.out.println("Choose your move:");
                        System.out.println("1. Play a tile on the table");
                        System.out.println("2. Move a tile on the table");
                        System.out.println("3. Finish your turn");
                        System.out.println("4. grab a tile from the bunch");
                        moveTypeInput = scanner.nextLine();
                }

            }

            }
        }

    }
}

