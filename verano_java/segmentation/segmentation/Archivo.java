import java.util.Arrays;
import java.util.Scanner;

public class Archivo {
    public static String multipleLine(Scanner sc){
        String chain = "";
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split("\\s");
            System.out.println(Arrays.toString(tokens));
            if (tokens[0].equals("")) break;
            chain = chain.concat(tokens[0]);
            System.out.println(chain);
        }
        return chain;
    }
    /* public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        multipleLine(scanner);
        scanner.close();
    } */
}