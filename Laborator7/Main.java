import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 20);
        List<Player> players = new ArrayList<Player>();
        Player player1 = new Player("Ovidiu", board);
        Player player2 = new Player("Andrei", board);
        players.add(player1);
        players.add(player2);
        Game game = new Game(board, players);
        game.play();
    }
}
