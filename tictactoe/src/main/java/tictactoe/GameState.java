package tictactoe;

public enum GameState {
    X_WIN("X wins", true), O_WIN("O wins", true),
    DRAW("Draw", true), IN_PROGRESS("Game not finished", false);

    final String stringValue;
    final boolean endOfGame;

    GameState(String s, boolean end) {
        this.stringValue = s;
        this.endOfGame = end;
    }
}
