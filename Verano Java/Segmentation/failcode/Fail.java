package failcode;
import java.util.ArrayList;

import segmentation.Segmentation;

public class Fail extends Segmentation{
    public static ArrayList<String> proteinChains(String chain, final String startCodon, final String[] endCodons) {
        ArrayList<String> proteins = new ArrayList<>();
        chain = chain.toLowerCase();
        String noProtein = chain;
        while (minEndCodonIndex(chain, endCodons) != -1 && chain.contains(startCodon)) {
            int endCodonIndex = minEndCodonIndex(chain, endCodons);
            int minimum = minEndCodonIndex(chain, endCodons);
            if ((chain.indexOf(startCodon) + chain.indexOf(endCodons[endCodonIndex]) % 3 != 0)
                    && (chain.indexOf(startCodon) < chain.indexOf(endCodons[endCodonIndex]))) {
                noProtein = chain.substring(chain.indexOf(startCodon),
                        chain.indexOf(endCodons[endCodonIndex]) + endCodons[0].length());
                if (noProtein.equals(chain))
                    break;
            }

            if (endCodonIndex == 0) {
                while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minimum == 0) {
                    String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
                    chain = chain.replaceFirst(protein, "");
                    proteins.add(protein);
                    System.out.println(chain);
                }
            } else if (endCodonIndex == 1) {
                while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minimum == 1) {
                    String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
                    chain = chain.replaceFirst(protein, "");
                    proteins.add(protein);
                    System.out.println(chain);
                }
            } else {
                while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minimum == 2) {
                    String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
                    chain = chain.replaceFirst(protein, "");
                    proteins.add(protein);
                    System.out.println(chain);
                }
            }
            System.out.println("The chain for the debug is: " + chain);
            minimum = minEndCodonIndex(chain, endCodons);
            endCodonIndex = minEndCodonIndex(chain, endCodons);
        }
        return proteins;
    }
}