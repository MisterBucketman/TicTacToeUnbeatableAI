package tictactoe;

public class Grid {
    public static char[][] grid = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    public static final char BLANK = ' ', O = 'O', X = 'X';

    static void clearingBoard() {
        grid = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    static void printingGrid() {
        System.out.print("---------\n");
        for (int i = 0; i <= grid.length; i++) {
            System.out.print(i == grid.length ? "---------\n" : "| ");
            if (i == grid.length) break;
            for (int j = 0; j <= grid.length; j++)
                System.out.print(j == grid.length ? "|\n" : (grid[i][j] + " "));
        }
    }

    static boolean checkIfWin(char ch, char[][] board) {
        return (board[0][2] == ch && board[1][2] == ch && board[2][2] == ch)
                || (board[0][1] == ch && board[1][1] == ch && board[2][1] == ch)
                || (board[0][0] == ch && board[1][0] == ch && board[2][0] == ch)
                || (board[0][2] == ch && board[0][1] == ch && board[0][0] == ch)
                || (board[1][2] == ch && board[1][1] == ch && board[1][0] == ch)
                || (board[2][2] == ch && board[2][1] == ch && board[2][0] == ch)
                || (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch)
                || (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch);
    }

    static boolean isCellEmpty(int row, int col, char[][] board) {
        return board[row][col] == BLANK;
    }

    static void setCell(int row, int col, char[][] board, char ch) {
        board[row][col] = ch;
    }

    static boolean noEmptyCellsLeft(char[][] board) {
        for (char[] chars : board)
            for (int j = 0; j < board.length; j++)
                if (chars[j] == BLANK) return false;
        return true;
    }

    static char getPlayerSymbol() {
        int countX = 0, countO = 0;
        for (int i = grid.length - 1; i >= 0; i--)
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == X) countX++;
                if (grid[i][j] == O) countO++;
            }
        return countX == countO ? X : O;
    }

    static char getOpponentSymbol(char ch) {
        if (ch == X) return O;
        else return X;
    }
}
