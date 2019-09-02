import java.util.*;
import javax.swing.*;
import java.awt.*;

public class MoveObject {
    private int range;

    public void move( int range, int x, int y) throws AWTException {
        range = range;
        Random randx = new Random();
        Random randy = new Random();

        int rand_x = randx.nextInt((range*2));
        int rand_y = randy.nextInt((range*2));

        rand_x = rand_x - range;
        rand_y = rand_y - range;

        //move the missile from a position where it is to a position where it isnt

        Robot robot = new Robot();
        robot.mouseMove((x + rand_x), (y + rand_y));

    }

    public void sleep(int time){
        try{
            Thread.sleep(time);
        }catch (Exception e){}
    }

}
