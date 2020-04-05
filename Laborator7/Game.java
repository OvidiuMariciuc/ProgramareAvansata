import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;

    public Game(Board board, List<Player> playersList) {
        this.board = board;
        players = new ArrayList<Player>();
        this.players = playersList;

    }

    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

}
