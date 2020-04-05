import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private Board board;
    private List<Token> choosedTokens;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        choosedTokens = new ArrayList<Token>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void getToken() {
        Token choosedValue = board.getTokens().get(0);
        choosedTokens.add(choosedValue);
        //tokens.remove(0);
        //elimin token-ul(de pe board) dupa ce a fost ales de catre un jucator
        board.updateTokens();
        System.out.println(this.getName() + " a ales token-ul " + choosedValue);
    }

    @Override
    public void run() {
        //parcurg lista de tokens
        while (!board.getTokens().isEmpty()) {
            this.getToken();
        }
    }
}
