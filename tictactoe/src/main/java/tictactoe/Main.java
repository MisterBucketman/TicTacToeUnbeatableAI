package tictactoe;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("Input command: ");
            String command = sc.nextLine().toLowerCase().trim();
            if ("exit".equals(command)) break;
            if (!command.matches("^start\\s+(easy|user|medium|hard)\\s+(easy|user|medium|hard)")) {
                System.out.println("Bad parameters!");
                continue;
            }
            String[] commArr = command.toLowerCase().split(" ");
            MoveController.players.clear();
            MoveController.setPlayers(commArr[1], commArr[2]);
            Grid.clearingBoard();
            Grid.printingGrid();
            do Fight.fighting(); while (!Fight.getGameStatus(Grid.grid).endOfGame);
            System.out.println(Fight.getGameStatus(Grid.grid).stringValue);
        }
    }
}