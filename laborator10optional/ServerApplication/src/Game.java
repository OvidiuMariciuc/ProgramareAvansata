import java.util.ArrayList;
import java.util.List;

public class Game {
    private String name;
    private Board board;
    private List<Player> players = new ArrayList<>();

    public Game(String name) {
        this.name = name;
        Player player = new Player(1);
        players.add(player);
        this.board = new Board();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
