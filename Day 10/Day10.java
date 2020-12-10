import java.util.*;
public class Day10 {
    public static int numJoltsMultiplied (ArrayList <Integer> temp){
        Collections.sort(temp);
        int diff1 = 1;
        int diff3 = 1;
        for (int i = 1; i < temp.size(); i++){
            if ((temp.get(i) - temp.get(i-1)) == 1){
                diff1+=1;
            } else if ((temp.get(i) - temp.get(i-1)) == 3){
                diff3+=1;
            }
        }
        return diff1*diff3;

    }
    public static long findAllWays (ArrayList <Integer> temp){
        Collections.sort(temp);
        temp.add(temp.get(temp.size() - 1) + 3);
        temp.add(0, 0);
        long [] storage = new long [temp.get(temp.size() - 1) + 1];
        storage[temp.get(temp.size() - 1)] = 1;
        for (int i = temp.size() - 2; i >= 0; i--){
            storage[temp.get(i)] = 0;
            for (int j = i+1; j < temp.size() && j <= i+3; j++){
                if (temp.get(j) - temp.get(i) <= 3){
                    storage[temp.get(i)] += storage[temp.get(j)];
                }
            }
        }
        System.out.println(Arrays.toString(storage));
        return storage[0];

    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <Integer> container = new ArrayList<>();
        String tempHolder = "";
        while (!(tempHolder = s.nextLine()).equals("")){
            container.add(Integer.parseInt(tempHolder));
        }
        System.out.println(numJoltsMultiplied(container));
        System.out.println(findAllWays(container));
        s.close();
    }
    
}
