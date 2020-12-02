import java.util.*;
import java.net.*;
import java.io.*;
public class Day2{
    //count number of valid passwords where ex. "1-3 a: aasb" is 'a' occurring in "aasb" between 1-3 times
    public static int countValidPassword (ArrayList <String> temp){
        int counter = 0;
        for (int i = 0; i < temp.size(); i++){
            String password = temp.get(i);
            int indexDash = password.indexOf("-");
            int indexSpace = password.indexOf(" ");
            int indexPass = password.indexOf(":");
            String atLeastNum = password.substring(0, indexDash);
            int atLeast = Integer.parseInt(atLeastNum);
            String atMostNum = password.substring(indexDash+1, indexSpace);
            int atMost = Integer.parseInt(atMostNum);
            String letterChar = password.substring(indexPass-1, indexPass);
            char letter = letterChar.charAt(0);
            String code = password.substring(indexPass+2);
            int numberOfTimesOccurred = 0;
            for (int j = 0; j < code.length(); j++){
                if (code.charAt(j) == letter){
                    numberOfTimesOccurred +=1;
                }
            }
            if (numberOfTimesOccurred >= atLeast && numberOfTimesOccurred <= atMost){
                counter += 1;
            }
        }
        return counter;
    }
    //count number of valid passwords where ex. "1-3 a: aasb" is 'a' occurring in either position 1 (true) or 3 (false) but not both
    public static int correctionCountValidPassword (ArrayList <String> temp){
        int counter = 0;
        for (int i = 0; i < temp.size(); i++){
            String password = temp.get(i);
            int indexDash = password.indexOf("-");
            int indexSpace = password.indexOf(" ");
            int indexPass = password.indexOf(":");
            String atLeastNum = password.substring(0, indexDash);
            int atLeast = Integer.parseInt(atLeastNum);
            String atMostNum = password.substring(indexDash+1, indexSpace);
            int atMost = Integer.parseInt(atMostNum);
            String letterChar = password.substring(indexPass-1, indexPass);
            char letter = letterChar.charAt(0);
            String code = password.substring(indexPass+2);
            if (code.charAt(atLeast - 1) == letter && code.charAt(atMost - 1) == letter){
                continue;
            } else if (code.charAt(atLeast - 1) == letter || code.charAt(atMost - 1) == letter){
                counter++;
            }
        }
        return counter;
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <String> container = new ArrayList<>();
        String tempHolder = "";
        while (!(tempHolder = s.nextLine()).equals("")){
            container.add(tempHolder);
        }
        System.out.println(countValidPassword(container));
        System.out.println(correctionCountValidPassword(container));
        s.close();
    }
}