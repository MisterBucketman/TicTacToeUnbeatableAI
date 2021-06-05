package tictactoe;

public class EasyAI implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Making move level \"easy\"");
        while (true) {
            int row = (int) (Math.random() * 3);
            int column = (int) (Math.random() * 3);
            if (Grid.isCellEmpty(row, column, Grid.grid)) {
                Grid.setCell(row, column, Grid.grid, Grid.getPlayerSymbol());
                break;
            }
        }
    }
}
