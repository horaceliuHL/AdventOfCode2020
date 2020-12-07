import java.util.*;
public class Day7 {
    public static int bagColorsContainingShinyGoldBag (ArrayList <String> temp){
        String pattern = "(.*)shiny gold(.*)";
        Set <String> patterns = new HashSet<>();
        patterns.add(pattern);
        
        int bagCounter = 0;
        while (bagCounter < patterns.size()){
            bagCounter = patterns.size();
            Set <String> newPattern = new HashSet<>();
            for (String pat: patterns){
                for (String bag: temp){
                    if (bag.split(" ", 3)[2].matches(pat)){
                        String newPat = "(.*)" + bag.split(" ")[0] + " " + bag.split(" ")[1] + "(.*)";
                        newPattern.add(newPat);
                    }
                }
            }
            patterns.addAll(newPattern);
        }
        return patterns.size() - 1;
    }
    private static ArrayList <String> part2 = new ArrayList <>();
    public static int howManyBagsIsShinyGoldHolding (String patterns){
        int result = 0;
        for (int i = 0; i < part2.size(); i++){
            String line = part2.get(i);
            if (line.startsWith(patterns)){
                String [] words = line.split(" ");
                if (words.length == 7) return 0; // "contains no other bags"
                else {
                    for (int j = 6; j < words.length; j+=4){
                        String c = words[j - 1] + " " + words[j];
                        result += Integer.parseInt(words[j-2]) * (howManyBagsIsShinyGoldHolding(c) + 1);
                    }
                }
            }
        }
        return result;
    }
    public static void main (String [] args){
        Scanner s = new Scanner (System.in);
        System.out.println("Enter here: ");
        ArrayList <String> container = new ArrayList<>();
        String tempHolder = "";
        while (!(tempHolder = s.nextLine()).equals("//")){
            container.add(tempHolder);
        }
        System.out.println(bagColorsContainingShinyGoldBag(container));
        part2 = container;
        System.out.println(howManyBagsIsShinyGoldHolding("shiny gold"));
        s.close();
    }
    
}
