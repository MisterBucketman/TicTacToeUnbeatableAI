package tictactoe;

public class HumanPlayer implements MoveStrategy {
    boolean validCoords;
    int rowCoord = 0, colCoord = 0;

    @Override
    public void move() {
        do validatingCoordinates(); while (!validCoords);
        Grid.setCell(rowCoord, colCoord, Grid.grid, Grid.getPlayerSymbol());
    }

    private void validatingCoordinates() {
        validCoords = false;
        System.out.println("Enter the coordinates: ");
        String[] coords = Main.sc.nextLine().trim().split(" ");
        try {
            String message;
            if (!("").equals(message = (coords.length != 2 ? "There should be two coordinates!"
                    : ((rowCoord = Integer.parseInt(coords[0]) - 1) > 2 || rowCoord < 0
                    || (colCoord = Integer.parseInt(coords[1]) - 1) > 2 || colCoord < 0)
                    ? "Coordinates should be from 1 to 3!" : !Grid.isCellEmpty(rowCoord, colCoord, Grid.grid)
                    ? "This cell is occupied! Choose another one!" : ""))) System.out.println(message);
            else validCoords = true;
        } catch (NumberFormatException nfe) {
            System.out.println("You should enter numbers!");
        }
    }
}
