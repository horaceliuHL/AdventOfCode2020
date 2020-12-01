import java.util.*;
public class Day1{
    //find 2 entries in a list that sum to 2020
    public static int[] twoSum (HashMap <Integer, Integer> temp){
        int[] result = new int[2];
        for (int keys: temp.keySet()){
            if (temp.containsKey(2020 - keys)){
                result[0] = keys;
                result[1] = 2020 - keys;
            }
        }
        return result;
    }
    //find 3 entries in a list that sum to 2020
    public static int[] threeSum (ArrayList<Integer> temp){
        int []result = new int [3];
        Collections.sort(temp);
        for (int i = 0; i < temp.size() - 2; i++){
            int lowIndex = i+1;
            int highIndex = temp.size() - 1;
            boolean flag = false;
            while (lowIndex < highIndex){
                if (temp.get(i) + temp.get(lowIndex) + temp.get(highIndex) == 2020){
                    result[0] = temp.get(i);
                    result[1] = temp.get(lowIndex);
                    result[2] = temp.get(highIndex);
                    flag = true;
                    break;
                } else if (temp.get(i) + temp.get(lowIndex) + temp.get(highIndex) < 2020){
                    lowIndex++;
                } else {
                    highIndex--;
                }
            }
            if (flag == true) break;
        }
        return result;
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter the list of integers: ");
        HashMap <Integer, Integer> forTwoSum = new HashMap<>();
        ArrayList<Integer> forThreeSum = new ArrayList<>();
        while (s.hasNextInt()){
            int i = s.nextInt();
            forTwoSum.put(i, 1);
            forThreeSum.add(i);
            s.nextLine();
        }
        int [] twoSum = twoSum(forTwoSum);
        System.out.println(twoSum[0] + " " + twoSum[1]);
        int [] threeSum = threeSum(forThreeSum);
        System.out.println(threeSum[0] + " " + threeSum[1] + " " + threeSum[2]);
        s.close();
    }
}