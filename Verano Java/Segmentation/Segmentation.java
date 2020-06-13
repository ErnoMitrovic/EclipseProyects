
//import java.util.Arrays;
import java.util.Scanner;
//import java.lang.Math;
import java.util.ArrayList;;

/*
* Encontrar si la cadena tiene codon inicial, final y regresar la proteina
* Imprimir los �ndices de inicio y final
*/
//cccatggggtttaaataataataggagagagagagagagttt
//atgaataagtaa

public class Segmentation {
	
	// int nOfProtein;
	// String arn;
	// public Segmentation(int nOfProtein){
	// 	arn = "empty";
	// 	this.nOfProtein = nOfProtein + 1;
	// }

	public static ArrayList<String> find(String chain, final String startCodon, final String endCodon, final String
	endCodon1, final String endCodon2) {
		ArrayList<String> proteins = new ArrayList<String>();
		chain = chain.toLowerCase();
		String protein = "Not found";
		int start = chain.indexOf(startCodon);
		if (start < 0){
			System.out.println(protein + " start.");
			return null;
		}
		else {
			chain = chain.substring(start, chain.length());
			start = chain.indexOf(startCodon);
			int end = chain.indexOf(endCodon, start + startCodon.length());
			int end1 = chain.indexOf(endCodon1, start + startCodon.length());
			int end2 = chain.indexOf(endCodon2, start + startCodon.length());

			if (end < 0 && end1 < 0 && end2 < 0){
				System.out.println("Not found" + " end. \nIn the text there are no proteins");
				return null;
			}
			else{
				end = 0; end1 = 0; end2 = 0;
				int indexForArray = 0;
				//int flag = 0;
				int indexStartRepeat, indexEndRepeat;
				while (!chain.isEmpty()){
					indexStartRepeat = 0;
					indexEndRepeat = 0;
					if (chain.contains(startCodon)){
						start = chain.indexOf(startCodon);
					}
					else break;
					if (chain.contains(endCodon)){
						end = chain.indexOf(endCodon, start + startCodon.length());
						start = chain.lastIndexOf(startCodon, end);
						System.out.println("end " + end);
						while (chain.substring(start, end + endCodon.length()).length() % 3 != 0 && start >= 0){
							start = chain.lastIndexOf(startCodon, start);
							end = chain.indexOf(endCodon, end + startCodon.length());
							System.out.println("Start " + start + "End " + end);
							if (indexStartRepeat == start || indexEndRepeat == end) break;
							indexEndRepeat = end;
							indexStartRepeat = start;
						}
						protein = chain.substring(start, end + endCodon.length());
						proteins.add(protein);
						//indexForArray++;
						chain = chain.replace(protein, "");
					}else if (chain.contains(endCodon1)){
						end1 = chain.indexOf(endCodon1, end1 + endCodon1.length());
						start = chain.lastIndexOf(startCodon, end1);
						while (chain.substring(start, end1 + endCodon1.length()).length() % 3 != 0 && start >= 0) {
							start = chain.lastIndexOf(startCodon, start);
							end1 = chain.indexOf(endCodon1, end1 + endCodon1.length());
							System.out.println("Start " + start);
							System.out.println("Start " + start + " End1 " + end1);
							if (indexStartRepeat == start || indexEndRepeat == end1) break;
							indexEndRepeat = end1;
							indexStartRepeat = start;
						}
						protein = chain.substring(start, end1 + endCodon1.length());
						proteins.add(protein);
						//indexForArray++;
						chain = chain.replace(protein,"");
					}else if (chain.contains(endCodon2)){
						end2 = chain.indexOf(endCodon2, start + startCodon.length());
						start = chain.lastIndexOf(startCodon, end2);
						while (chain.substring(start, end2 + endCodon2.length()).length() % 3 != 0 && start >= 0) {
							start = chain.lastIndexOf(startCodon, start);
							end2 = chain.indexOf(endCodon2, end2 + startCodon.length());
							System.out.println("Start " + start + " End2 " + end2);
							if (indexStartRepeat == start || indexEndRepeat == end2) break;
							indexEndRepeat = end2;
							indexStartRepeat = start;
						}
						protein = chain.substring(start, end2 + endCodon1.length());
						proteins.add(protein);
						//aindexForArray++;
						chain = chain.replace(protein, "");
					}
					if (proteins.get(indexForArray).equals("at")) proteins.remove(indexForArray);
					indexForArray++;
				}
				//System.out.println(protein);
				/*
				 * while (protein.length() % 3 != 0) { end = chain.indexOf(endCodon, end +
				 * endCodon.length()); protein = chain.substring(start, end +
				 * endCodon.length()); if (protein.length() % 3 != 0) end = -1; }
				 */
			System.out.println("The index of start is: " + start + "\nThe index of end is: " + (end + endCodon.length()-1));
			}
			return proteins;
		}
	}

	public static int longestGene(String [] chains){
			int lengthOfGene = chains[0].length();
			if (lengthOfGene == -1) return lengthOfGene;
			else{
				for (String gene : chains) {
					if (lengthOfGene < gene.length()) lengthOfGene = gene.length();
				}
			}
			System.out.println("The largest gene has a length of: " + lengthOfGene);
			return lengthOfGene;
		}

	public static int proteinsLengthOver (String [] chains, final int majorLength){
		int count = 0;
		if (!chains[0].isEmpty()){
			for (String protein : chains) {
				if (protein.length() > majorLength) count++;
			}
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
		String wholeText;
		if (chains[0].length() >= 0){
			wholeText = "";
			for (String gen : chains) {
				wholeText.concat(gen);
			}
			int times = countInString(firstToExamine, wholeText) + countInString(lastToExamine, wholeText);
			value = times / (float)wholeText.length();
		} 
		System.out.println("The ratio of appearance in the text is: " + value);
		return value;
	}
	public static void main(final String[] args){
		Scanner sc = new Scanner(System.in);
		//Segmentation protein = new Segmentation(1);
		System.out.println("Insert chain: ");
		String chain = sc.next();
		final String startCodon = "atg";
		final String endCodon = "taa";
		final String endCodon1 = "tag";
		final String endCodon2 = "tga";

		System.out.println("Enter the major index to find: ");
		final int majorLength = sc.nextInt();
		sc.close();
		//String empty = chain.replace(chain, "");

		ArrayList <String> arrayList = find(chain, startCodon, endCodon, endCodon1, endCodon2);
		System.out.println(arrayList);
		String [] chains = GetStringArray(arrayList);

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
