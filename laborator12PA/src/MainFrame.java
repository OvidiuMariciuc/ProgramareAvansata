import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame() {
        super("Lab 12 - Dynamic Swing Designer");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);

        //invoke the layout manager
        pack();
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
