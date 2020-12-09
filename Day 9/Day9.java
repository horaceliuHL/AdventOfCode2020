import java.util.*;
public class Day9 {
    //find the invalid number in the list which isn't a sum of two number in the most previous contiguous 25 numbers
    public static Long findInvalid (ArrayList <Long> excess, ArrayList <Long> list){
        long number = 0;
        while (!excess.isEmpty()){
            boolean flag = false;
            HashMap <Integer, Long> check = new HashMap <>();
            long compare = excess.get(0);
            excess.remove(0);
            for (int j = 0; j < list.size(); j++){
                if (check.containsValue(compare - list.get(j))){
                    list.remove(0);
                    list.add(compare);
                    flag = true;
                    break;
                } else {
                    check.put(j, list.get(j));
                }
            }
            if (flag == false){
                number = compare;
                break;
            }
        }
        return number;
    }
    //take the invalid number and find the contiguous numbers before it that add up to it
    public static long findWeakness (ArrayList <Long> list, long invalid){
        for (int i = 0; i < list.size() - 1; i++){
            long temp = 0;
            long min = Integer.MAX_VALUE;
            long max = 0;
            for (int j = i; j < list.size(); j++){
                if (list.get(j) < min) min = list.get(j);
                else if (list.get(j) > max) max = list.get(j);
                temp += list.get(j);
                if (temp == invalid){
                    return min + max;
                } else if (temp > invalid) break;
            }
        }
        return -1;
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <Long> container = new ArrayList<>();
        ArrayList <Long> container2 = new ArrayList<>();
        ArrayList <Long> container3 = new ArrayList<>();
        String tempHolder = "";
        int i = 0;
        while (!(tempHolder = s.nextLine()).equals("")){
            if (i < 25) container2.add(Long.parseLong(tempHolder));
            else container.add(Long.parseLong(tempHolder));
            i+=1;
            container3.add(Long.parseLong(tempHolder));
        }
        long invalid = findInvalid(container, container2);
        System.out.println(invalid);
        System.out.println(findWeakness(container3, invalid));
        s.close();
    }
    
}
