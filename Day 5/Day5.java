import java.util.*;
public class Day5 {
    //find the highest seat Id in a list of seats where its ordered by binary space partitioning
    public static int findHighestSeatId (ArrayList <String> temp){
        int highestSeatId = 0;
        for (int i = 0; i < temp.size(); i++){
            String code = temp.get(i);
            int row = 0;
            int column = 0;
            int lower = 0;
            int higher = 127;
            for (int j = 0; j < 6; j++){
                if (code.charAt(j) == 'F'){
                    higher = (lower + higher)/2;
                } else if (code.charAt(j) == 'B'){
                    lower = (lower + higher)/2 + 1;
                }
            }
            if (code.charAt(6) == 'F') row = lower;
            else { row = higher; }
            lower = 0;
            higher = 7;
            for (int j = 7; j < code.length(); j++){
                if (code.charAt(j) == 'L'){
                    higher = (lower + higher)/2;
                } else if (code.charAt(j) == 'R'){
                    lower = (lower + higher)/2 + 1;
                }
            }
            if (code.charAt(9) == 'L') column = lower;
            else {column = higher; }

            int seatId = (row*8) + column;
            if (seatId > highestSeatId) highestSeatId = seatId;
        }
        return highestSeatId;
    }
    //find my seat on the plane
    public static int findMySeat (ArrayList <String> temp){
        int mySeat = 0;
        int [] seatsList = new int [temp.size()];
        for (int i = 0; i < temp.size(); i++){
            String code = temp.get(i);
            int row = 0;
            int column = 0;
            int lower = 0;
            int higher = 127;
            for (int j = 0; j < 6; j++){
                if (code.charAt(j) == 'F'){
                    higher = (lower + higher)/2;
                } else if (code.charAt(j) == 'B'){
                    lower = (lower + higher)/2 + 1;
                }
            }
            if (code.charAt(6) == 'F') row = lower;
            else { row = higher; }
            lower = 0;
            higher = 7;
            for (int j = 7; j < code.length(); j++){
                if (code.charAt(j) == 'L'){
                    higher = (lower + higher)/2;
                } else if (code.charAt(j) == 'R'){
                    lower = (lower + higher)/2 + 1;
                }
            }
            if (code.charAt(9) == 'L') column = lower;
            else {column = higher; }

            int seatId = (row*8) + column;
            seatsList[i] = seatId;
        }
        Arrays.sort(seatsList);
        for (int i = 0; i < seatsList.length - 1; i++){
            if (seatsList[i] + 2 == seatsList[i+1]){
                mySeat = seatsList[i] + 1;
                break;
            }
        }
        return mySeat;

    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <String> container = new ArrayList<>();
        String tempHolder = "";
        while (!(tempHolder = s.nextLine()).equals("")){
            container.add(tempHolder);
        }
        System.out.println(findHighestSeatId(container));
        System.out.println(findMySeat(container));
        s.close();
    }
    
}
