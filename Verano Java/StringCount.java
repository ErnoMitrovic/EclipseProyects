package Verano_Java;
import java.util.Scanner;
public class StringCount{
    public static int countInString(String stringToFind, String stringFinding){
        stringToFind = stringToFind.toLowerCase();
        stringFinding = stringFinding.toLowerCase();
        int count = 0;
        boolean found = stringFinding.contains(stringToFind);
        if (found){
            int index = stringFinding.indexOf(stringToFind);
            while (index != -1){
                count ++;
                stringFinding = stringFinding.substring(index + 1);
                index = stringFinding.indexOf(stringToFind);
            }
            return count;
        }else return count;
    }
    public static void main(String[] args) {
        final String stringToFind = "sope";
        final String stringFinding = "";
        System.out.println("The count of string 1 in string 2 is: " + countInString(stringToFind, stringFinding));
    }
}