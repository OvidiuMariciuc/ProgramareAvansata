import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private JLabel classLabel;
    private JTextField classField;
    private JLabel textLabel;
    private JTextField textField;
    private JButton createButton;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        classLabel = new JLabel("Type any class name of a Swing component:");
        classField = new JTextField(25);
        textLabel = new JLabel("Type text:");
        textField = new JTextField(25);
        createButton = new JButton("Create component");
        add(classLabel);
        add(classField);
        add(textLabel);
        add(textField);
        add(createButton);
        createButton.addActionListener(this::create);
    }

    private void create(ActionEvent actionEvent) {
        try {
            Class clazz = Class.forName(classField.getText());
            Component component = (Component) clazz.getConstructor().newInstance();

            Method method = clazz.getMethod("setText", String.class);
            method.invoke(component, textField.getText());
            frame.designPanel.createComponent((JComponent) component);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
