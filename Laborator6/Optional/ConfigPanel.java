import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JLabel colorsLabel, shapesLabel;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JComboBox shapeCombo;


    public JSpinner getSidesField() {
        return sidesField;
    }

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //colorCombo = new JComboBox();
        //colorCombo.setForeground(randomColor);
        //colorCombo.setBackground(randomColor);
        //black or random
        String colors[] = {"Random", "Black"};
        String shapes[] = {"Polygon", "Circle", "VerticalLine", "HorizontalLine"};
        colorsLabel = new JLabel("Colors:");
        colorCombo = new JComboBox(colors);
        shapesLabel = new JLabel("Shapes:");
        shapeCombo = new JComboBox(shapes);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorsLabel);
        add(colorCombo);
        add(shapesLabel);
        add(shapeCombo);
    }
}