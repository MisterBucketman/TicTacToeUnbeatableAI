package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class MoveController {
    final MoveStrategy strategy;
    final char playerSymbol;
    final String playerID;
    static List<MoveController> players = new ArrayList<>();


    public MoveController(MoveStrategy strategy, char playerSymbol, String playerID) {
        this.strategy = strategy;
        this.playerSymbol = playerSymbol;
        this.playerID = playerID;
    }

    public String getPlayerID() {
        return this.playerID;
    }

    public void move() {
        strategy.move();
    }

    static void setPlayers(String playX, String playO) {
        players.add(playX.equals("easy") ? new MoveController(new EasyAI(), Grid.X, "easyAI")
                : playX.equals("medium") ? new MoveController(new MediumAI(), Grid.X, "mediumAI")
                : playX.equals("hard") ? new MoveController(new HardAI(), Grid.X, "hardAI")
                : new MoveController(new HumanPlayer(), Grid.X, "human"));
        players.add(playO.equals("easy") ? new MoveController(new EasyAI(), Grid.O, "easyAI")
                : playO.equals("medium") ? new MoveController(new MediumAI(), Grid.O, "mediumAI")
                : playO.equals("hard") ? new MoveController(new HardAI(), Grid.O, "hardAI")
                : new MoveController(new HumanPlayer(), Grid.O, "human"));
    }
}
