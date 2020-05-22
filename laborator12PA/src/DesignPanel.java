import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    private final MainFrame frame;
    final static int W = 800, H = 600;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        repaint();
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBackground(Color.WHITE);
        setLayout(null);
    }

    public void createComponent(JComponent component) {
        Random random = new Random();
        int width = component.getPreferredSize().width;
        int height = component.getPreferredSize().height;
        int x = random.nextInt(W);
        int y = random.nextInt(H);
        Insets insets = this.getInsets();
        component.setBounds(x + insets.left, y + insets.top, width, height);
        this.add(component);
        repaint();
        frame.pack();
    }

}
