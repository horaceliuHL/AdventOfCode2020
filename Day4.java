import java.util.*;
public class Day4{
    //check if the passport contains the fields checked below
    public static int checkIfValidPassport (ArrayList <String> temp){
        int counter = 0;
        for (int i = 0; i < temp.size(); i++){
            if (temp.get(i).contains("byr:") && temp.get(i).contains("iyr:") && temp.get(i).contains("eyr:") &&
            temp.get(i).contains("hgt:") && temp.get(i).contains("hcl:") && temp.get(i).contains("ecl:") &&
            temp.get(i).contains("pid:")){
                counter++;
            }
        }
        return counter;
    }
    //check if the passport contains the fields, and within each field contains valid numbers 
    public static int checkStrictStandardsPassport (ArrayList <String> temp){
        int counter = 0;
        for (int i = 0; i < temp.size(); i++){
            boolean flag = false;
            if (temp.get(i).contains("byr:") && temp.get(i).contains("iyr:") && temp.get(i).contains("eyr:") &&
            temp.get(i).contains("hgt:") && temp.get(i).contains("hcl:") && temp.get(i).contains("ecl:") &&
            temp.get(i).contains("pid:")){
                String passport = temp.get(i);
                String [] split = passport.split(" ");
                //System.out.println(Arrays.toString(split));
                for (int j = 0; j < split.length; j++){
                    if (split[j].charAt(0) == ' '){
                        split[j] = split[j].substring(1);
                    }
                    if (split[j].charAt(0) == 'b' && split[j].charAt(1) == 'y'){
                        String checkYear = split[j].substring(4);
                        int checkYearNum = Integer.parseInt(checkYear);
                        if (checkYearNum < 1920 || checkYearNum > 2002){
                            flag = true;
                            break;
                        }
                    } else if (split[j].charAt(0) == 'i'){
                        String checkYear = split[j].substring(4);
                        int checkYearNum = Integer.parseInt(checkYear);
                        if (checkYearNum < 2010 || checkYearNum > 2020){
                            flag = true;
                            break;
                        }
                    } else if (split[j].charAt(0) == 'e' && split[j].charAt(1) == 'y'){
                        String checkYear = split[j].substring(4);
                        int checkYearNum = Integer.parseInt(checkYear);
                        if (checkYearNum < 2020 || checkYearNum > 2030){
                            flag = true;
                            break;
                        }
                    } else if (split[j].charAt(0) == 'h' && split[j].charAt(1) == 'g'){
                        String checkHeight = split[j].substring(4, split[j].length() - 2);
                        int checkHeightNum = Integer.parseInt(checkHeight);
                        if (split[j].charAt(split[j].length() - 2) == 'c' && split[j].charAt(split[j].length() - 1) == 'm'){
                            if (checkHeightNum < 150 || checkHeightNum > 193){
                                flag = true;
                                break;
                            }
                        } else if (split[j].charAt(split[j].length() - 2) == 'i' && split[j].charAt(split[j].length() - 1) == 'n'){
                            if (checkHeightNum < 59 || checkHeightNum > 76){
                                flag = true;
                                break;
                            }
                        } else {
                            flag = true;
                            break;
                        }
                    } else if (split[j].charAt(0) == 'h' && split[j].charAt(1) == 'c'){
                        String checkHair = split[j].substring(4);
                        if (!(checkHair.charAt(0) == '#')){
                            flag = true;
                            break;
                        }
                        checkHair = checkHair.substring(1);
                        if (checkHair.length() != 6){
                            flag = true;
                            break;
                        }
                        for (int k = 0; k < checkHair.length(); k++){
                            if (!Character.isLetterOrDigit(checkHair.charAt(k))){
                                flag = true;
                                break;
                            }
                        }
                    } else if (split[j].charAt(0) == 'e' && split[j].charAt(1) == 'c'){
                        String checkEye = split[j].substring(4);
                        if (!checkEye.equals("amb") && !checkEye.equals("blu") && !checkEye.equals("brn") &&
                        !checkEye.equals("gry") && !checkEye.equals("grn") && !checkEye.equals("hzl") &&
                        !checkEye.equals("oth")){
                            flag = true;
                            break;
                        }
                    } else if (split[j].charAt(0) == 'p'){
                        String checkId = split[j].substring(4);
                        if (checkId.length() != 9){
                            flag = true;
                            break;
                        }
                        for (int k = 0; k < checkId.length(); k++){
                            if (!Character.isDigit(checkId.charAt(k))){
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag == true){
                        break;
                    }
                }
            } else {
                flag = true;
            }
            if (flag == false){
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
        String storeIntoContainer = "";
        while (!(tempHolder = s.nextLine()).equals("//")){
            if (tempHolder.equals("")){
                container.add(storeIntoContainer);
                storeIntoContainer = "";
            } else {
                storeIntoContainer += tempHolder + " ";
            }
        }
        System.out.println(checkIfValidPassport(container));
        System.out.println(checkStrictStandardsPassport(container));
        s.close();
    }
}