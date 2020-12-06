import java.util.*;
public class Day6 {
    //find all unique answers answerd yes in each group
    public static int sumOfAnswers (ArrayList <String> temp){
        int counter = 0;
        for (int i = 0; i < temp.size(); i++){
            String str = temp.get(i);
            str = str.replaceAll(" ", "");
            String tempString = "";
            for (int j = 0; j < str.length(); j++){
                if (tempString.indexOf(str.charAt(j)) == -1){
                    tempString += str.charAt(j);
                }
            }
            //System.out.println(tempString.length());
            counter += tempString.length();
        }
        return counter;

    }
    //find all answers to which everyone in a group answered yes
    public static int questionsEveryoneAnswered (ArrayList <ArrayList <String>> temp){
        //System.out.println(temp.toString().toString());
        int counter = 0;
        for (int i = 0; i < temp.size(); i++){
            boolean [] commonCharactersInAll = new boolean [26];
            Arrays.fill(commonCharactersInAll, true);
            for (int j = 0; j < temp.get(i).size(); j++){
                boolean [] uniqueCharactersInString = new boolean [26];
                Arrays.fill(uniqueCharactersInString, false);
                String str = temp.get(i).get(j);
                for (int k = 0; k < str.length(); k++){
                    if (commonCharactersInAll[str.charAt(k) - 'a'] == true){
                        uniqueCharactersInString[str.charAt(k) - 'a'] = true;
                    }
                }
                System.arraycopy(uniqueCharactersInString, 0, commonCharactersInAll, 0, 26);
            }
            int counterWithin = 0;
            for (int j = 0; j < 26; j++){
                if (commonCharactersInAll[j] == true){
                    counterWithin += 1;
                }
            }
            counter += counterWithin;
        }
        return counter;
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <String> container = new ArrayList<>();
        ArrayList <ArrayList <String>> container2 = new ArrayList<ArrayList<String>>();
        container2.add(new ArrayList <String>());
        String tempHolder = "";
        String storeIntoContainer = "";
        int arraylistSize = 0;
        while (!(tempHolder = s.nextLine()).equals("//")){
            if (tempHolder.equals("")){
                container.add(storeIntoContainer);
                storeIntoContainer = "";
                container2.add(new ArrayList<String>());
                arraylistSize+=1;
            } else {
                storeIntoContainer += tempHolder + " ";
                container2.get(arraylistSize).add(tempHolder);
            }
        }
        if (!storeIntoContainer.equals("")){
            container.add(storeIntoContainer);
        }
        //System.out.println(container);
        System.out.println(sumOfAnswers(container));
        System.out.println(questionsEveryoneAnswered(container2));
        s.close();
    }
    
}
