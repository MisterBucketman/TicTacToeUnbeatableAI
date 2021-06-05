package tictactoe;

import static tictactoe.Grid.*;

public class HardAI implements MoveStrategy {
    private static char maximizer, minimizer;

    @Override
    public void move() {
        System.out.println("Making move level \"hard\"");
        String id1 = MoveController.players.get(0).getPlayerID();
        String id2 = MoveController.players.get(1).getPlayerID();
        maximizer = (id1.equals("hardAI") && id2.equals("hardAI")) ? (getPlayerSymbol() == Grid.X ? Grid.X : Grid.O)
                : (id1.equals("hardAI") ? Grid.X : Grid.O);
        minimizer = Grid.getOpponentSymbol(maximizer);
        char[][] board = grid;
        int[] bestMove = getBestMove(board);
        setCell(bestMove[0], bestMove[1], grid, maximizer);
    }

    public int[] getBestMove(char[][] board) {
        final int MAX_DEPTH = 10;
        int[] bestMove = new int[2];
        int bestValue = Integer.MIN_VALUE;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (isCellEmpty(row, col, board)) {
                    setCell(row, col, board, maximizer);
                    int moveValue = minimax(board, MAX_DEPTH, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
                    setCell(row, col, board, BLANK);
                    if (moveValue > bestValue) {
                        bestMove = new int[]{row, col};
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

    private static int evaluateBoard(char[][] board, int depth) {
        if (checkIfWin(X, board)) return maximizer == X ? 10 + depth : -10 - depth;
        else if (checkIfWin(O, board)) return minimizer == O ? -10 - depth : 10 + depth;
        else return 0;
    }

    public int minimax(char[][] board, int depth, int alpha, int beta, boolean isMax) {
        int boardVal = evaluateBoard(board, depth);
// ----------------------------------------------- recursion function base - (win/lose/draw) or max depth reached -----
        if (Math.abs(boardVal) > 0 || depth == 0 || noEmptyCellsLeft(board)) return boardVal;
// maximising player looks for the max value, minimising for the lowest / alpha and beta are 'cutting' useless nodes --
        int bestValue = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (isCellEmpty(row, col, board)) {
                    setCell(row, col, board, isMax ? maximizer : minimizer);
                    int value = minimax(board, depth - 1, alpha, beta, !isMax);
                    setCell(row, col, board, BLANK);
                    bestValue = isMax ? Math.max(alpha, Math.max(bestValue, value))
                            : Math.min(beta, Math.min(bestValue, value));
                    if (alpha >= beta) return bestValue;
                }
            }
        }
        return bestValue;
    }
}