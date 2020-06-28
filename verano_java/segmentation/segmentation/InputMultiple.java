import java.util.Scanner;
//import java.util.Arrays;
/* import java.io.File;
import java.io.FileNotFoundException; */

public class InputMultiple{
  public static String multipleLine(Scanner sc){
        String chain = "";
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split("\\s");
            //System.out.println(Arrays.toString(tokens));
            for (String word:tokens) {
              chain = chain.concat(word);
            }
            if (tokens[0].equals("")) break;
        }
        return chain;
    }
    /* public static void main(String[] args) throws FileNotFoundException{
      String path = "C:\\Users\\miran\\Desktop\\Debug chains\\archivo.txt";
      File text = new File(path);
      Scanner sc = new Scanner(text);
      String chain = multipleLine(sc);
      System.out.println(chain);
      sc.close();
      System.out.println();
    } */
}
