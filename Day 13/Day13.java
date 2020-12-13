import java.util.*;
public class Day13 {
    //find the earliest bus available from my time
    public static int earliestBusAvail (int num, int [] buses){
        int difference = Integer.MAX_VALUE;
        int busNum = 0;
        for (int i = 0; i < buses.length; i++){
            int tempNum = num/buses[i];
            tempNum += 1;
            tempNum *= buses[i];
            if (tempNum - num < difference){
                difference = tempNum - num;
                busNum = buses[i];
            }
        }
        return difference*busNum;
    }
    //find earliest time stamp where all bus times are consecutive (could use Chinese Remainder Theorem here but 
    //there's no package implementing CRT so I just used Wolfram Alpha, input/output is below)
    //this method is used to sort the data
    public static int[][] earliestTimeStamp (int [] buses){
        int [][] result = new int [9][2];
        int counter = 0;
        for (int i = 0; i < buses.length; i++){
            if (buses[i] != -1){
                result[counter][0] = buses[i];
                result[counter][1] = i;
                counter += 1;
            }
        }
        return result;
    }
    public static void main (String [] args){
        int num = 1007153;
        int [] buses = {29, 37, 433, 13, 17, 19, 23, 977, 41};
        System.out.println(earliestBusAvail(num, buses));
        int [] buses1 = {29,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,37,-1,-1,-1,-1,-1,433,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,13,17,-1,-1,-1,-1,19,-1,-1,-1,23,-1,-1,-1,-1,-1,-1,-1,977,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,41};
        System.out.println(Arrays.deepToString(earliestTimeStamp(buses1)));
        //(t+0) mod 29 = 0, (t+23) mod 37 = 0, (t+29) mod 433 = 0, (t+42) mod 13 = 0, (t+43) mod 17 = 0, (t+48) mod 19 = 0, (t+52) mod 23 = 0, (t+60) mod 977 = 0, (t+101) mod 41 = 0
        //in wolfram alpha: 534035653563227 + 1797379356693401(n) therefore when n = 0, that's the smallest number
        
    }
    
}
