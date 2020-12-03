import java.util.*;
public class Day3{
    //check if 3 right 1 down is a tree and repeat the pattern of each string horizontally infinitely until I get to the bottom
    public static int treesCrashedInto (ArrayList <String> temp){
        int crashedIntoTrees = 0;
        int keepTrack = 0;
        for (int i = 0; i < temp.size(); i++){
            if (keepTrack >= temp.get(i).length()){
                keepTrack = keepTrack - temp.get(i).length();
            }
            if (temp.get(i).charAt(keepTrack) == '#'){
                crashedIntoTrees+=3;
            }
            keepTrack+=7;
        }
        return crashedIntoTrees;
    }
    //check right 1 down 1 * right 3 down 1 * right 5 down 1 * right 7 down 1 * right 1 down 2
    public static int allTreesCrashedInto (ArrayList <String> temp){ //set on right 1 down 2 right now, manually do them
        int crashedIntoTrees = 0;
        int keepTrack = 0;
        for (int i = 0; i < temp.size(); i+=2){
            if (keepTrack >= temp.get(i).length()){
                keepTrack = keepTrack - temp.get(i).length();
            }
            if (temp.get(i).charAt(keepTrack) == '#'){
                crashedIntoTrees+=1;
            }
            keepTrack+=1;
        }
        return crashedIntoTrees;
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <String> container = new ArrayList<>();
        String tempHolder = "";
        while (!(tempHolder = s.nextLine()).equals("")){
            container.add(tempHolder);
        }
        System.out.println(treesCrashedInto(container));
        System.out.println(allTreesCrashedInto(container));
        s.close();
    }
}