package tictactoe;

import static tictactoe.Grid.*;

public class MediumAI implements MoveStrategy {
    private static char mediumAI;

    @Override
    public void move() {
        System.out.println("Making move level \"medium\"");
        String id1 = MoveController.players.get(0).getPlayerID();
        String id2 = MoveController.players.get(1).getPlayerID();
        mediumAI = (id1.equals("mediumAI") && id2.equals("mediumAI"))
                ? (getPlayerSymbol() == X ? X : O) : (id1.equals("mediumAI") ? X : O);
        if (isPlayerOneMoveToWin()) return;               // ----- making move if a win is possible with one move -----
        if (isOpponentOneMoveToWin()) return;           // ----- blocking move if opponent's next move is winning -----
        while (true) {                                     // ----- otherwise players symbol is inserted randomly -----
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            if (isCellEmpty(row, col, grid)) {
                setCell(row, col, grid, mediumAI);
                break;
            }
        }
    }

    private boolean isPlayerOneMoveToWin() {
        return isWinPossible(mediumAI);
    }

    private boolean isOpponentOneMoveToWin() {
        return isWinPossible(mediumAI == X ? O : X);
    }

    private boolean isWinPossible(char ch) {
        for (int row = 0; row < grid.length; row++) {             // ----- insert 'X' (or 'O') in all empty cells -----
            for (int col = 0; col < grid.length; col++) {            // ----- to check if there is a winning move -----
                if (isCellEmpty(row, col, grid)) {
                    setCell(row, col, grid, ch);
                    if (checkIfWin(ch, grid)) {
                        setCell(row, col, grid, mediumAI);
                        return true;
                    } else setCell(row, col, grid, BLANK);
                }
            }
        }
        return false;
    }
}
