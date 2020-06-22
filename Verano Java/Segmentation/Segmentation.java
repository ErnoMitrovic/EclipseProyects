
//import java.util.Arrays;
import java.util.Scanner;
//import java.lang.Math;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/*
* Encontrar si la cadena tiene codon inicial, final y regresar la proteina
* Imprimir los �ndices de inicio y final
*/
//cccatggggtttaaataataataggagagagagagagagttt
//atgaataagtaa

//atgtagcgatgctaatgatagggtag
//Encuentra el archivo de texto

//69
//~400

public class Segmentation {

	public static String findProtein(String chain, final String startCodon, final String[] endCodons, final int endCodonIndex){
		String protein = "";
		if (chain.contains(startCodon)) {
			final int startIndex = chain.indexOf(startCodon);
			int stopIndex = chain.indexOf(endCodons[endCodonIndex], startIndex + startCodon.length());
				if (chain.contains(endCodons[endCodonIndex])) {
					protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
					while (true) {
						if (protein.length() % 3 != 0) {
							stopIndex = chain.indexOf(endCodons[endCodonIndex], stopIndex + startCodon.length());
						} else break;
						protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
					}
				} else System.out.println("No end codon found");
			} else return null;
		return protein;
	}

	public static ArrayList <String> proteinChains(String chain, final String startCodon, final String[] endCodons){
		ArrayList <String> proteins = new ArrayList<>();
		for (int endCodonIndex = 0; endCodonIndex < 3; endCodonIndex++){
			if (endCodonIndex == 0){
				String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
				chain = chain.replace(protein, "");
				proteins.add(protein);
			}
			else if (endCodonIndex == 1){
				String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
				chain = chain.replace(protein, "");
				proteins.add(protein);
			}
			else{
				String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
				chain = chain.replace(protein, "");
				proteins.add(protein);
			}
		}
		return proteins;
	}

	public static int longestGene(String [] chains){
		int lengthOfGene = 0;
		for (String gene : chains) {
				if (lengthOfGene < gene.length()) lengthOfGene = gene.length();
			}
		System.out.println("The largest gene has a length of: " + lengthOfGene);
		return lengthOfGene;
		}

	public static int proteinsLengthOver (String [] chains, final int majorLength){
		int count = 0;
		for (String protein : chains) {
				if (protein.length() > majorLength) count++;
		}
		System.out.println("The number of proteins that have a length of more than " + majorLength + " are: " + count);
		return count;
	}

	public static String[] GetStringArray(ArrayList<String> arr) {

		// declaration and initialise String Array
		String str[] = new String[arr.size()];

		// Convert ArrayList to object array
		Object[] objArr = arr.toArray();

		// Iterating and converting to String
		int i = 0;
		for (Object obj : objArr) {
			str[i++] = (String) obj;
		}

		return str;
	}

	public static int countInString(String stringToFind, String stringFinding) {
		stringToFind = stringToFind.toLowerCase();
		stringFinding = stringFinding.toLowerCase();
		int count = 0;
		boolean found = stringFinding.contains(stringToFind);
		if (found) {
			int index = stringFinding.indexOf(stringToFind);
			while (index != -1) {
				count++;
				stringFinding = stringFinding.substring(index + 1);
				index = stringFinding.indexOf(stringToFind);
			}
			return count;
		} else
			return count;
	}

	public static float ratioProtein(String[] chains, final String firstToExamine, final String lastToExamine){
		float value = 0f;
		String wholeText = "";
		for (String gen : chains) {
				wholeText = wholeText.concat(gen);
			}
		int times = countInString(firstToExamine, wholeText) + countInString(lastToExamine, wholeText);
		value = times / (float)wholeText.length();
		System.out.println("The ratio of appearance in the text is: " + value);
		return value;
	}
	public static void main(final String[] args)throws FileNotFoundException{
		File textProteins = new File("G:\\Mi unidad\\ESCUELA\\Tec 5° semestre\\Computer science\\IBProyects\\Verano Java\\segmentation/dna.txt");
		Scanner sc = new Scanner(textProteins);
		//Segmentation protein = new Segmentation(1);
		System.out.println("Insert chain: ");
		String chain = sc.next();
		final String startCodon = "atg";
		final String [] endCodons = {"taa", "tag", "tga"};

		System.out.println("Enter the major index to find: ");
		final int majorLength = 22;
		sc.close();
		//String empty = chain.replace(chain, "");

		//ArrayList <String> arrayList = find(chain, startCodon, endCodon, endCodon1, endCodon2);
		//System.out.println(arrayList);
		//String [] chains = GetStringArray(arrayList);
		//String protein = findProtein(chain, startCodon, endCodons, 1);

		//chain = "";

		ArrayList <String> arrayList = proteinChains(chain, startCodon, endCodons);
		System.out.println(proteinChains(chain, startCodon, endCodons));

		String [] chains = GetStringArray(arrayList);
		System.out.println("The number of proteins in the text is: " + arrayList.size());

		longestGene(chains);

		proteinsLengthOver(chains, majorLength);

		ratioProtein(chains, "a", "t");

		// int sizeOfList = find(chain, startCodon, endCodon, endCodon1, endCodon2).size();

		// Segmentation [] chains = new Segmentation[sizeOfList];
		// for(int i = 0; i < sizeOfList; i++){
		// 	Segmentation protein = new Segmentation(i);
		// 	protein.arn = find(chain, startCodon, endCodon, endCodon1, endCodon2).get(i);
		// 	chains[i] = protein;
		// 	System.out.println("The " + chains[i].nOfProtein + "° is " + chains[i].arn);
		// }
	}
}
