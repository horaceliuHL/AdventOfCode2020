import java.util.*;
public class Day12 {
    //find manhattan distance of just the boat moving
    public static int findManhattanDistance (ArrayList <String> temp){
        int x = 0;
        int y = 0;
        int direction = 90;
        for (int i = 0; i < temp.size(); i++){
            char action = temp.get(i).charAt(0);
            int number = Integer.parseInt(temp.get(i).substring(1));
            if (action == 'F'){
                if (direction == 90) x += number;
                else if (direction == 180) y -= number;
                else if (direction == 270) x -= number;
                else if (direction == 0) y += number;
            } else if (action == 'N') y += number;
            else if (action == 'E') x += number;
            else if (action == 'S') y -= number;
            else if (action == 'W') x -= number;
            else if (action == 'L'){
                direction -= number % 360;
                direction = direction < 0 ? (360 - -direction) % 360 : (direction % 360);
            }
            else if (action == 'R'){
                direction += number % 360;
                direction = direction % 360;
            }
        }
        return Math.abs(x) + Math.abs(y);
    }
    //find manhattan distance with the boat and the waypoint moving (different from part 1)
    public static int refindManhattanDistance (ArrayList <String> temp){
        int x = 0;
        int y = 0;
        int wpx = 10;
        int wpy = 1;
        for (int i = 0; i < temp.size(); i++){
            char action = temp.get(i).charAt(0);
            int number = Integer.parseInt(temp.get(i).substring(1));
            if (action == 'F'){
                x += wpx * number;
                y += wpy * number;
            }
            if (action == 'N') wpy += number;
            if (action == 'E') wpx += number;
            if (action == 'S') wpy -= number;
            if (action == 'W') wpx -= number;
            if (action == 'L'){
                while (number > 0){
                    int temp1 = wpx;
                    wpx = -wpy;
                    wpy = temp1;
                    number -= 90;
                }
            }
            if (action == 'R'){
                while (number > 0){
                    int temp1 = wpx;
                    wpx = wpy;
                    wpy = -temp1;
                    number -= 90;
                }
            }
        }
        return Math.abs(x) + Math.abs(y);
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <String> container = new ArrayList<>();
        String tempHolder = "";
        while (!(tempHolder = s.nextLine()).equals("")){
            container.add(tempHolder);
        }
        System.out.println(findManhattanDistance(container));
        System.out.println(refindManhattanDistance(container));
        s.close();
    }
    
}
