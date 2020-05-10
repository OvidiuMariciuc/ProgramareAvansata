import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    private List<Game> games = new ArrayList<>();

    public void createGame(String name) {
        Game game = new Game(name);
        games.add(game);
        Player player = new Player(1);
        game.addPlayer(player);
    }

    public void joinGame(String name) {
        for (Game game : games) {
            if (game.getName().equals(name)) {
                game.addPlayer(new Player(2));
            }
        }
    }

    public void submitMove(String gameName, int type, int pos1, int pos2) {
        for (Game game : games) {
            if (game.getName().equals(gameName)) {
                game.getBoard().move(type, pos1, pos2);
            }
        }
    }

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Waiting for a client ...");
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                //System.out.println("New command recieved...");
                new ClientThread(socket, this).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
}