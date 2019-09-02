import java.awt.*;

public class Main{

    private ChangeMouse changeMouse;
    private int desired_x;
    private int desired_y;

    public static void main(String[] args) throws AWTException {
                LocationFromWhereItIsNot location = new LocationFromWhereItIsNot();
                ChangeMouse mouse = new ChangeMouse("hqdefault.jpg");
                MoveObject move = new MoveObject();
                int desired_y = mouse.createAndShowGUI(false, "");
                int desired_x = location.generate_end_loc(desired_y);
                mouse.moveToStart();
                System.out.println(desired_x + ", " + desired_y);

                while (true){ //loop until the missile reaches its destination
                    int where_it_is_x = location.loc_x();
                    int where_it_is_y = location.loc_y();
                    int where_it_isnt_x = where_it_is_x + 8;
                    int where_it_isnt_y;

                    int upvdown;
                    if (where_it_is_y < desired_y){
                        where_it_isnt_y = where_it_is_y + 8; //deviation is 8
                    }
                    else if (where_it_is_y > desired_y){
                        where_it_isnt_y = where_it_is_y - 8;
                    }
                    else{
                        where_it_isnt_y = where_it_is_y;
                    }
                    // the missile moves from a position where it isnt to a position where it is
                    move.move(4, where_it_isnt_x, where_it_isnt_y);

                    // if variation is considered to be a significant factor, then it too may be corrected by the GEA
                    int variation_x = Math.abs(location.loc_x() - where_it_isnt_x);
                    int variation_y = Math.abs(location.loc_y() - where_it_isnt_y);
                    int variation = variation_x + variation_y;

                    if (variation > 6){
                        move.move(1, where_it_isnt_x, where_it_isnt_y);
                    }

                    move.sleep(100);

                    //check if it is where it should be at the end:
                    if (Math.abs(location.loc_x() - desired_x) < 20 && Math.abs(location.loc_y() - desired_y) < 20){
                        int Show_results = mouse.createAndShowGUI(true, "The missile's final position was: (x: " + location.loc_x() + ", y: " + location.loc_y() + ")");
                        break;
                    }
                }

    }

}