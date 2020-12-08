import java.util.*;
public class Day8 {
    //runs through the instructions, returns a map containing an instruction order array, a boolean visited array, and the accumulator
    //for both parts
    public static Map<ArrayList<Boolean>, ArrayList<Integer>>  forBothParts (ArrayList<String> temp){
        int accumulator = 0;
        boolean [] visited = new boolean [temp.size()];
        Arrays.fill(visited, false);
        ArrayList <Integer> order = new ArrayList<>();
        int i = 0;
        while (visited[i] != true){
            order.add(i);
            String a = temp.get(i);
            visited[i] = true;
            String instruction = a.substring(0, 3);
            if (instruction.equals("acc")){
                accumulator += Integer.parseInt(a.substring(4));
                i+=1;
            } else if (instruction.equals("jmp")){
                i += Integer.parseInt(a.substring(4));
            } else {
                i+=1;
            }
            if (i >= temp.size()) break;
        }
        order.add(accumulator);
        ArrayList <Boolean> soComplicated = new ArrayList<>();
        for (boolean a: visited){
            soComplicated.add(a);
        }
        Map <ArrayList<Boolean>, ArrayList<Integer>> returnMap = new HashMap<>();
        returnMap.put(soComplicated, order);
        return returnMap;
    }
    //part 1: find the accumulator value before the program hits an infinite loop
    public static int accumulatorValue (ArrayList <String> temp){
        Map <ArrayList<Boolean>, ArrayList<Integer>> returnMap = forBothParts(temp);
        Map.Entry<ArrayList<Boolean>, ArrayList<Integer>> entry = returnMap.entrySet().iterator().next();
        ArrayList <Integer> returnValue = entry.getValue();
        return returnValue.get(returnValue.size() - 1);
    }
    //part 2: fix one line of code to make the program run and get the accumulator value at the end
    public static int fixError (ArrayList <String> temp){
        Map <ArrayList<Boolean>, ArrayList<Integer>> returnMap = forBothParts(temp);
        Map.Entry<ArrayList<Boolean>, ArrayList<Integer>> entry = returnMap.entrySet().iterator().next();
        //ArrayList <Boolean> checkedInstructions = entry.getKey();
        ArrayList <Integer> orderList = entry.getValue();
        orderList.remove(orderList.size() - 1);
        int accumulator = 0;

        ArrayList <String> temp1 = temp;
        for (int i = orderList.size() - 1; i >= 0; i--){
            temp1 = temp;
            if (temp1.get(orderList.get(i)).substring(0, 3).equals("jmp")) temp1.set(orderList.get(i), "nop " + temp1.get(orderList.get(i)).substring(4));
            else if (temp1.get(orderList.get(i)).substring(0, 3).equals("nop")) temp1.set(orderList.get(i), "jmp " + temp1.get(orderList.get(i)).substring(4));

            Map <ArrayList<Boolean>, ArrayList<Integer>> testing = forBothParts(temp1);
            Map.Entry<ArrayList<Boolean>, ArrayList<Integer>> testing1 = testing.entrySet().iterator().next();
            ArrayList <Boolean> checkIfValid = testing1.getKey();
            ArrayList <Integer> checkIfValid1 = testing1.getValue();
            if (checkIfValid.get(checkIfValid.size() - 1) == true){
                accumulator = checkIfValid1.get(checkIfValid1.size() - 1);
                break;
            }
            
        }
        return accumulator;
        
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <String> container = new ArrayList<>();
        String tempHolder = "";
        while (!(tempHolder = s.nextLine()).equals("")){
            container.add(tempHolder);
        }
        System.out.println(accumulatorValue(container));
        System.out.println(fixError(container));
        s.close();
    }
    
}
