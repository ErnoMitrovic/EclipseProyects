import java.util.ArrayList;

public class Fail extends Segmentation{

    public static ArrayList<String> chains(String chain, final String startCodon, final String[] endCodons) {
        ArrayList<String> proteins = new ArrayList<>();
        chain = chain.toLowerCase();
        int lastIndex = 0;
        boolean hasEndCodons = minEndCodonIndex(chain, endCodons, lastIndex) >= 0;
        int endCodonIndex = minEndCodonIndex(chain, endCodons, lastIndex);
        boolean minCodon;
        // System.out.println("Has end Codons: " + hasEndCodons + " Chain contains
        // startCodon: " + chain.contains(startCodon));
        int flag = 0;
        while (hasEndCodons && chain.contains(startCodon)) {
            if (flag > 6)
                break;
            flag++;
            boolean condition1 = findProtein(chain, startCodon, endCodons, endCodonIndex).equals("");
            boolean condition2 = endCodonIndex == -1;
            if (findProtein(chain, startCodon, endCodons, endCodonIndex).equals("")) {
                lastIndex = chain.indexOf(endCodons[endCodonIndex]);
                endCodonIndex = minEndCodonIndex(chain, endCodons, lastIndex);
            }
            System.out.println("Condition 1: " + condition1 + "\tCondition 2: " + condition2);
            System.out.println("Last index: " + lastIndex);
            System.out.println("End Codon Index: " + endCodonIndex);

            if (condition1 && condition2)
                break;
            hasEndCodons = minEndCodonIndex(chain, endCodons, lastIndex) >= 0;
            if (endCodonIndex == 0) {
                minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 0;
                while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon) {
                    minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 0;
                    // System.out.println("Min codon condition taa: " + minCodon);
                    String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
                    chain = chain.replaceFirst(protein, "");
                    proteins.add(protein);
                    // System.out.println("New chain taa: " + chain);
                }
            } else if (endCodonIndex == 1) {
                minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 1;
                while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon) {
                    minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 1;
                    // System.out.println("Min codon condition tag: " + minCodon);
                    String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
                    chain = chain.replaceFirst(protein, "");
                    proteins.add(protein);
                    // System.out.println("New chain tag: " + chain);
                }
            } else {
                minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 2;
                while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon) {
                    minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 2;
                    // System.out.println("Min codon condition tga: " + minCodon);
                    String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
                    chain = chain.replaceFirst(protein, "");
                    proteins.add(protein);
                    // System.out.println("New chain tga: " + chain);
                }
                condition1 = findProtein(chain, startCodon, endCodons, endCodonIndex).equals("");
                condition2 = endCodonIndex == -1;
            }
            // System.out.println("The chain in the while chains is: " + chain);
        }
        return proteins;
    }

    public static ArrayList<String> proteinChains(String chain, final String startCodon, final String[] endCodons) {
        ArrayList<String> proteins = new ArrayList<>();
        chain = chain.toLowerCase();
        String noProtein = chain;
        while (minEndCodonIndex(chain, endCodons, 0) != -1 && chain.contains(startCodon)) {
            int endCodonIndex = minEndCodonIndex(chain, endCodons, 0);
            int minimum = minEndCodonIndex(chain, endCodons, 0);
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
            minimum = minEndCodonIndex(chain, endCodons, 0);
            endCodonIndex = minEndCodonIndex(chain, endCodons, 0);
        }
        return proteins;
    }
    public static boolean logicalXor(final boolean condition1, final boolean condition2){
        boolean condition = false;
        if (condition1 || condition2){
            if (!(condition1 && condition2)) condition = true;
        }
        return condition;
    }
}