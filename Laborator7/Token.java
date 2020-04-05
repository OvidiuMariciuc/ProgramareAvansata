import java.util.Random;

public class Token {
    private Integer value;

    //constructor
    public Token(Integer value) {
        this.value = new Random().nextInt(value);
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                '}';
    }
}
