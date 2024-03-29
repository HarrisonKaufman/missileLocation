import javax.swing.*;
import java.awt.*;
import java.awt.Robot;

public class ChangeMouse extends JFrame {

    private String path;
    public int y_val;
    public JTextField inputs = new JTextField("Replace Me With Y Coordinate");
    public JButton button = new JButton("Enter");
    public JLabel results;

    public int createAndShowGUI(boolean last, String text) {

        if (last == true){
            setTitle("Missile Performance");
            getContentPane().setBackground(Color.red);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            remove(inputs);
            remove(button);
            revalidate();
            repaint();
            results = new JLabel(text);
            add(results);
            revalidate();
            repaint();
            return 0;

        }
        else {
            setTitle("It Knows Where It Is");
            getContentPane().setBackground(Color.blue);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            add(inputs);
            add(button);


            try {
                setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(path).getImage(), new Point(0, 0), "custom cursor"));
            } catch (Exception e) {
            }

            setSize(10000, 10000);
            setVisible(true);

            while (true) {
                System.out.println("...");
                if (button.getModel().isPressed()) {
                    break;
                }
            }
            String input = String.valueOf(inputs.getText());

            System.out.println(input);
            try {
                y_val = Integer.valueOf(input);
            } catch (Exception e) {
            }
            System.out.println(y_val);
            return y_val;
        }
    }

    public void moveToStart() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(0, 10000);
    }


    //add field in gui to set end coordinates
    public ChangeMouse(String path){

        this.path = path;

    }
}
