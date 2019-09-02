import java.awt.*;

public class LocationFromWhereItIsNot {

    public int loc_x(){
        Point p = MouseInfo.getPointerInfo().getLocation();
        int isnot = p.x - 1; //this is the missile's distance to the sides of the screen, or the space in which it is not
        int x_val = isnot + 1; //The missile knows where it is at all times.  It knows this because it knows where it isn't.
        return x_val;
    }
    public int loc_y(){
        Point p = MouseInfo.getPointerInfo().getLocation();
        int isnot = p.y - 1; //this is the missile's distance to the top of the screen, or the space in which it is not
        int y_val = isnot + 1; //The missile knows where it is at all times.  It knows this because it knows where it isn't.
        return y_val;
    }
    //method to specify the desired end location
    public int generate_end_loc (int yval) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(10000, yval);
        Point p = MouseInfo.getPointerInfo().getLocation();
        int isnot = p.x - 1; //this is the missile's distance to the sides of the screen, or the space in which it is not
        int x_val = isnot + 1; //The missile knows where it is at all times.  It knows this because it knows where it isn't.
        return x_val;

    }
}
