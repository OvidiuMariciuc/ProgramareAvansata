import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("d:/test.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        frame.canvas.graphics.drawImage(image, 0, 0, null);
        frame.canvas.repaint();
    }

    private void reset(ActionEvent e) {
        frame.canvas.graphics.setColor(Color.WHITE); //fill the image with white
        frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }
}
