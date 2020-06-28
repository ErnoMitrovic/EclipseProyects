
import java.lang.Math;
import java.util.ArrayList;


//cccatggggtttaaataataataggagagagagagagagttt
//atgaataagtaa

//atgtagcgatgctaatgatagggtag
//Encuentra el archivo de texto

//69
//~400

//atg123456tagatg123456tgaatg12taa1taa

public class Segmentation {

	public static String cutProtein(final String chain, final String startCodon){
		String cuttedProt = chain;
		int startIndex = chain.indexOf(startCodon);
		cuttedProt = cuttedProt.substring(startIndex);
		return cuttedProt;
	}

	public static String findProtein(String chain, final String startCodon, final String[] endCodons, final int endCodonIndex){
		String protein = "";
		chain = chain.toLowerCase();
		chain = cutProtein(chain, startCodon);
		if (endCodonIndex >= 0){
			if (chain.contains(startCodon)) {
				final int startIndex = chain.indexOf(startCodon);
				if (chain.contains(endCodons[endCodonIndex])) {
					int stopIndex = chain.indexOf(endCodons[endCodonIndex], startIndex + startCodon.length());
					protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
					while (true) {
						if (protein.length() % 3 != 0) {
							stopIndex = chain.indexOf(endCodons[endCodonIndex], stopIndex + startCodon.length());
							if (stopIndex > startIndex) {
								protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
							} else if (stopIndex < startIndex) {
								protein = "";
								break;
							}
						} else
							break;
						protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
						//System.out.println(protein.length() % 3 != 0);
					}
				}
			}
		}
		return protein;
	}
	public static ArrayList <String> chains(String chain, final String startCodon, final String[] endCodons){
		ArrayList <String> proteins = new ArrayList<>();
		chain = chain.toLowerCase();
		int lastIndex = 0;
		boolean hasEndCodons = minEndCodonIndex(chain, endCodons, lastIndex) >= 0;
		int endCodonIndex = minEndCodonIndex(chain, endCodons, lastIndex);
		boolean minCodon;
		//System.out.println("Has end Codons: " + hasEndCodons + " Chain contains startCodon: " + chain.contains(startCodon));
		int flag = 0;
		while (hasEndCodons && chain.contains(startCodon)){
			if (flag > 10) break;
			flag ++;
			boolean condition1 = findProtein(chain, startCodon, endCodons, endCodonIndex).equals("");
			boolean condition2 = endCodonIndex == -1;
			if (findProtein(chain, startCodon, endCodons, endCodonIndex).equals("")) {
				lastIndex = chain.indexOf(endCodons[endCodonIndex]);
				endCodonIndex = minEndCodonIndex(chain, endCodons, lastIndex);
			}
			System.out.println("Condition 1: " + condition1 + "\tCondition 2: " + condition2);

			if (condition1 && condition2) break;
			hasEndCodons = minEndCodonIndex(chain, endCodons, lastIndex) >= 0;
			if (endCodonIndex == 0){
				minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 0;
				while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon){
					minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 0;
					//System.out.println("Min codon condition taa: " + minCodon);
					String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
					chain = chain.replaceFirst(protein, "");
					proteins.add(protein);
					//System.out.println("New chain taa: " + chain);
				}
			}
			else if (endCodonIndex == 1){
				minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 1;
				while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon) {
					minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 1;
					//System.out.println("Min codon condition tag: " + minCodon);
					String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
					chain = chain.replaceFirst(protein, "");
					proteins.add(protein);
					//System.out.println("New chain tag: " + chain);
				}
			}
			else {
				minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 2;
				while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon) {
					minCodon = minEndCodonIndex(chain, endCodons, lastIndex) == 2;
					//System.out.println("Min codon condition tga: " + minCodon);
					String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
					chain = chain.replaceFirst(protein, "");
					proteins.add(protein);
					//System.out.println("New chain tga: " + chain);
				}
				condition1 = findProtein(chain, startCodon, endCodons, endCodonIndex).equals("");
				condition2 = endCodonIndex == -1;
			}
			//System.out.println("The chain in the while chains is: " + chain);
		}
		return proteins;
	}

	public static int minEndCodonIndex(String chain, final String[] endCodons, final int lastIndex){
		int minIndex = -1;
		String codon = "";
		chain = chain.toLowerCase();
		chain = chain.substring(lastIndex + endCodons[0].length(), chain.length());
		boolean existFirstCodon = chain.contains(endCodons[0]);
		boolean existSecondCodon = chain.contains(endCodons[1]);
		boolean existThirdCodon = chain.contains(endCodons[2]);

		if (existFirstCodon && existSecondCodon && existThirdCodon){
			final int firstCodonInd = chain.indexOf(endCodons[0]);
			final int secondCodonInd = chain.indexOf(endCodons[1]);
			final int thirdCodonInd = chain.indexOf(endCodons[2]);
			minIndex = Math.min(firstCodonInd, secondCodonInd);
			minIndex = Math.min(minIndex,thirdCodonInd);
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			//System.out.println(codon);
			if (codon.equals(endCodons[0])) return 0;
			else if (codon.equals(endCodons[1])) return 1;
			else return 2;
		}
		else if (existFirstCodon && existSecondCodon) {
			final int firstCodonInd = chain.indexOf(endCodons[0]);
			final int secondCodonInd = chain.indexOf(endCodons[1]);
			minIndex = Math.min(firstCodonInd,secondCodonInd);
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			//System.out.println(codon);
			if (codon.equals(endCodons[0])) return 0;
			else return 1;
		}
		else if (existFirstCodon && existThirdCodon){
			final int firstCodonInd = chain.indexOf(endCodons[0]);
			final int thirdCodonInd = chain.indexOf(endCodons[2]);
			minIndex = Math.min(firstCodonInd, thirdCodonInd);
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			//System.out.println(codon);
			if (codon.equals(endCodons[0])) return 0;
			else return 2;
		}
		else if(existSecondCodon && existThirdCodon) {
			final int secondCodonInd = chain.indexOf(endCodons[1]);
			final int thirdCodonInd = chain.indexOf(endCodons[2]);
			minIndex = Math.min(secondCodonInd, thirdCodonInd);
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			if (codon.equals(endCodons[1])) return 1;
			else return 2;
		}
		else if (existFirstCodon) return 0;
		else if (existSecondCodon) return 1;
		else if (existThirdCodon) return 2;
		else return minIndex;
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
}
