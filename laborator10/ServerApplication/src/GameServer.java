import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Waiting for a client ...");
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                //System.out.println("New command recieved...");
                new ClientThread(socket).start();
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