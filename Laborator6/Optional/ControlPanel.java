import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton undoBtn = new JButton("DeleteLastShape"); //undo
    JButton resetBtn = new JButton("DeleteAllShapes"); //reset
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
        add(undoBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        undoBtn.addActionListener(this::undo);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    /*private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }*/

    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            File selectedFile = null;
            add(fileChooser);
            int returnedValue = fileChooser.showSaveDialog(null);
            if (returnedValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
            }
            ImageIO.write(frame.canvas.image, "PNG", new File(selectedFile.getAbsolutePath()));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /*private void load(ActionEvent e) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("d:/test.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        frame.canvas.graphics.drawImage(image, 0, 0, null);
        frame.canvas.repaint();
    }*/

    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            File selectedFile = null;
            add(fileChooser);
            int returnedValue = fileChooser.showOpenDialog(null);
            if (returnedValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                BufferedImage loadedImage = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                frame.canvas.graphics.drawImage(loadedImage, 0, 0, null);
                frame.canvas.repaint();
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    //am adaugat functionalitatea butonului undo
    private void undo(ActionEvent e) {
        frame.canvas.shapeList.remove(frame.canvas.shapeList.size()-1);
        frame.canvas.shapecolorList.remove(frame.canvas.shapecolorList.size()-1);
        frame.canvas.repaintundo();
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
