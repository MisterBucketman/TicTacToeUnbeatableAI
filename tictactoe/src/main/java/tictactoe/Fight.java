package tictactoe;

public class Fight {
    static void fighting() {
        for (int i = 0; true; i++, i = i % 2) {
            MoveController.players.get(i).move();
            Grid.printingGrid();
            if (getGameStatus(Grid.grid).endOfGame) return;
        }
    }

    static public GameState getGameStatus(char[][] board) {
        if (Grid.checkIfWin(Grid.X, board)) return GameState.X_WIN;
        if (Grid.checkIfWin(Grid.O, board)) return GameState.O_WIN;
        if (Grid.noEmptyCellsLeft(board)) return GameState.DRAW;
        else return GameState.IN_PROGRESS;
    }
}
