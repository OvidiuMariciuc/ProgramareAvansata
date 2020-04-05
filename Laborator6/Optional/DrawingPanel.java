import com.sun.xml.internal.bind.v2.TODO;
import jdk.nashorn.internal.ir.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 960, H = 720;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    List<Shape> shapeList = new ArrayList<>();
    List<Color> shapecolorList = new ArrayList<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    //...NEXT SLIDE
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }

    private void drawShape(int x, int y) {
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        int opacity = random.nextInt(255);
        int radius = random.nextInt(200);
        int randomlineValue = random.nextInt(300);
        int sides = (int) frame.configPanel.getSidesField().getValue();
        //transparent random Color.
        Color color = new Color(red, green, blue, opacity);
        //black
        if ("Black".equals((String) frame.configPanel.colorCombo.getSelectedItem())) {
            graphics.setColor(new Color(0, 0, 0));
            shapecolorList.add(new Color(0,0,0));
        } else {
            //random
            graphics.setColor(color);
            shapecolorList.add(color);
        }
        //graphics.fill(new RegularPolygon(x, y, radius, sides));
        if ("Polygon".equals((String) frame.configPanel.shapeCombo.getSelectedItem())) {
            RegularPolygon polygon = new RegularPolygon(x, y, radius, sides);
            graphics.fill(polygon);
            shapeList.add(polygon);
        } else if ("Circle".equals((String) frame.configPanel.shapeCombo.getSelectedItem())) {
            NodeShape circle = new NodeShape(x, y, radius);
            graphics.fill(circle);
            shapeList.add(circle);
        } else if ("HorizontalLine".equals((String) frame.configPanel.shapeCombo.getSelectedItem())) {
            graphics.drawLine(x, y, x + randomlineValue, y);
            //shapeList.add(RegularPolygon);
        } else {
            graphics.drawLine(x, y, x, y + randomlineValue);
            //shapeList.add(RegularPolygon);
        }
    }

    public void repaintundo() {
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
        for(int i = 0 ; i< shapeList.size(); i++) {
            graphics.setColor(shapecolorList.get(i));
            graphics.fill(shapeList.get(i));
        }
        repaint();
    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
