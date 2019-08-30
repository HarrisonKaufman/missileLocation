import java.awt.*;

public class Main{

    private ChangeMouse changeMouse;

    public static void main(String[] args) throws AWTException {

                ChangeMouse mouse = new ChangeMouse("hqdefault.jpg");
                int y_value = mouse.createAndShowGUI();
                mouse.moveToStart();

    }

}