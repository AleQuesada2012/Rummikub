import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        Vector<Ficha> tiles = pila.getStack();

        // Sort the tiles by color and number
        Collections.sort(tiles, new Comparator<Ficha>() {
            @Override
            public int compare(Ficha tile1, Ficha tile2) {
                int colorComparison = tile1.getColor().compareTo(tile2.getColor());
                if (colorComparison == 0) {
                    return Integer.compare(tile1.getNum(), tile2.getNum());
                }
                return colorComparison;
            }
        });

        // Display the sorted tiles
        for (int i = 0; i < tiles.size(); i++) {
            Ficha ficha = tiles.get(i);
            System.out.println("Tile " + i + ": " + ficha.getNum() + " " + ficha.getColor());
        }
        Ficha grabbedTile = pila.agarrarficha();

        if (grabbedTile != null) {
            System.out.println("Grabbed Tile: " + grabbedTile.getNum() + " " + grabbedTile.getColor());


            if (!tiles.contains(grabbedTile)) {
                System.out.println("Grabbed tile has been successfully removed from the Pila.");
            } else {
                System.out.println("Error: Grabbed tile is still in the Pila.");
            }
        } else {
            System.out.println("No tiles left to grab.");


        }
    }

}

