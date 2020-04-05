import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private List<Token> tokens;

    public Board(Integer nrTokens, Integer maxtokenValue) {
        tokens = new ArrayList<Token>();
        for (int iterator = 0; iterator < nrTokens; iterator++) {
            tokens.add(new Token(maxtokenValue));
        }
        Collections.shuffle(tokens);
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public synchronized List<Token> getTokens() {
        return tokens;
    }

    public synchronized void updateTokens() {
        tokens.remove(0);
    }
}
