import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;
    private GameServer game;

    public ClientThread(Socket socket, GameServer game) {
        this.socket = socket;
        this.game = game;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Server received the request ... ";
            System.out.println(request);
            if (request.contains("create game")) {
                raspuns = "Game created!";
                game.createGame(request.substring(12));
                out.println(raspuns);
                out.flush();
            } else if (request.contains("join game")) {
                raspuns = "Game joined!";
                game.joinGame(request.substring(11));
                out.println(raspuns);
                out.flush();
            } else if (request.contains("submit move")) {
                raspuns = "Move submitted!";
                String[] parameters = request.split("\\s+");
                game.submitMove(parameters[2], Integer.parseInt(parameters[3]), Integer.parseInt(parameters[4]), Integer.parseInt(parameters[5]));
                out.println(raspuns);
                out.flush();
            } else if (request.equals("stop")) {
                raspuns = "Server stopped";
                out.println(raspuns);
                out.flush();
                System.exit(0);
            }
            out.println(raspuns);
            out.flush();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}