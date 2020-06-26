import java.util.Scanner;
import java.util.Arrays;
import java.io.Files;
import java.io.FileNotFoundException;

public class InputMultiple{
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
    public static void main(String[] args) throws FileNotFoundException{
      String path = "G:\\Mi unidad\\ESCUELA\\Tec 5° semestre\\Computer science\\IBProyects\\Verano Java\\segmentation\\HomoSapiensDNA.txt";
      File text = new File(path);
      Scanner sc = new Scanner(text);
      multipleLine(sc);
      sc.close();
    }
}
