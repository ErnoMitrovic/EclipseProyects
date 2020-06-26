package segmentation;
import java.util.Scanner;

import java.lang.Math;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import failcode.Fail;
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

//atg123456tagatg123456tgaatg12taa1taa

public class Segmentation {
	public static String findProtein(String chain, final String startCodon, final String[] endCodons, final int endCodonIndex){
		String protein = "";
		chain = chain.toLowerCase();
		if (chain.contains(startCodon)) {
			final int startIndex = chain.indexOf(startCodon);
			int stopIndex = chain.indexOf(endCodons[endCodonIndex], startIndex + startCodon.length());
				if (chain.contains(endCodons[endCodonIndex])) {
					protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
					while (true) {
						if (protein.length() % 3 != 0) {
							stopIndex = chain.indexOf(endCodons[endCodonIndex], stopIndex + startCodon.length());
							if (stopIndex > startIndex) {
								protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
							}
							else if (stopIndex < startIndex) {
								// System.out.println("Chain contains end codon " + endCodons[endCodonIndex] + "
								// but no proteins");
								protein = "";
								System.out.println("Start Index " + startIndex);
								System.out.println("Stop Index " + stopIndex);
								break;
							}
						}else break;
						protein = chain.substring(startIndex, stopIndex + endCodons[endCodonIndex].length());
						System.out.println(protein.length() % 3 != 0);
					}
				} //else System.out.println("No end codon found");
			} 
		return protein;
	}
	public static ArrayList <String> chains(String chain, final String startCodon, final String[] endCodons){
		ArrayList <String> proteins = new ArrayList<>();
		boolean hasEndCodons = minEndCodonIndex(chain, endCodons, 0) >= 0;
		while (hasEndCodons && chain.contains(startCodon)){
			int endCodonIndex = minEndCodonIndex(chain, endCodons, 0);
			boolean condition1 = findProtein(chain, startCodon, endCodons, endCodonIndex).equals("");
			boolean condition2 = endCodonIndex == -1; 
			if (Fail.logicalXor(condition1, condition2)) break;
			hasEndCodons = minEndCodonIndex(chain, endCodons, endCodonIndex) >= 0;
			boolean minCodon;
			if (endCodonIndex == 0){
				System.out.println(chain);
				minCodon = minEndCodonIndex(chain, endCodons, endCodonIndex) == 0;
				while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon){
					minCodon = minEndCodonIndex(chain, endCodons, endCodonIndex) == 0;
					String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
					chain = chain.replaceFirst(protein, "");
					proteins.add(protein);
					System.out.println("The end codon index in the while loop is: "+endCodonIndex);
				}
			}
			else if (endCodonIndex == 1){
				minCodon = minEndCodonIndex(chain, endCodons, endCodonIndex) == 1;
				while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon) {
					minCodon = minEndCodonIndex(chain, endCodons, endCodonIndex) == 1;
					String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
					chain = chain.replaceFirst(protein, "");
					proteins.add(protein);
				}
			}
			else {
				minCodon = minEndCodonIndex(chain, endCodons, endCodonIndex) == 2;
				while (!findProtein(chain, startCodon, endCodons, endCodonIndex).equals("") && minCodon) {
					minCodon = minEndCodonIndex(chain, endCodons, endCodonIndex) == 2;
					String protein = findProtein(chain, startCodon, endCodons, endCodonIndex);
					chain = chain.replaceFirst(protein, "");
					proteins.add(protein);
				}
			}
		}
		return proteins;
	}

	public static int minEndCodonIndex(String chain, final String[] endCodons, final int lastIndex){
		int minIndex = -1;
		String codon = "";
		chain = chain.toLowerCase();
		boolean existFirstCodon = chain.contains(endCodons[0]);
		boolean existSecondCodon = chain.contains(endCodons[1]);
		boolean existThirdCodon = chain.contains(endCodons[2]);
		final int firstCodonInd = chain.indexOf(endCodons[0], lastIndex);
		final int secondCodonInd = chain.indexOf(endCodons[1], lastIndex);
		final int thirdCodonInd = chain.indexOf(endCodons[2], lastIndex);
		if (existFirstCodon && existSecondCodon && existThirdCodon){
			minIndex = Math.min(firstCodonInd, secondCodonInd);
			minIndex = Math.min(minIndex,thirdCodonInd);
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			//System.out.println(codon);
			if (codon.equals(endCodons[0])) return 0;
			else if (codon.equals(endCodons[1])) return 1;
			else return 2;
		}
		else if (existFirstCodon && existSecondCodon) {
			minIndex = Math.min(firstCodonInd,secondCodonInd);
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			//System.out.println(codon);
			if (codon.equals(endCodons[0])) return 0;
			else return 1;
		}
		else if (existFirstCodon && existThirdCodon){
			minIndex = Math.min(firstCodonInd, thirdCodonInd);
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			//System.out.println(codon);
			if (codon.equals(endCodons[0])) return 0;
			else return 2;
		}
		else if(existSecondCodon && existThirdCodon) {
			minIndex = Math.min(secondCodonInd, thirdCodonInd);			
			codon = chain.substring(minIndex, minIndex + endCodons[0].length());
			System.out.println(codon);
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
	public static void main(final String[] args)throws FileNotFoundException{
		File textProteins = new File("G:\\Mi unidad\\ESCUELA\\Tec 5° semestre\\Computer science\\IBProyects\\Verano Java\\segmentation/dna.txt");
		Scanner sc = new Scanner(textProteins);
		//Segmentation protein = new Segmentation(1);
		System.out.println("Insert chain: ");
		String chain = sc.next();
		final String startCodon = "atg";
		final String [] endCodons = {"taa", "tag", "tga"};

		System.out.println("Enter the major index to find: ");
		// final int majorLength = 22;
		sc.close();
		//String empty = chain.replace(chain, "");

		//ArrayList <String> arrayList = find(chain, startCodon, endCodon, endCodon1, endCodon2);
		//System.out.println(arrayList);
		//String [] chains = GetStringArray(arrayList);
		//String protein = findProtein(chain, startCodon, endCodons, 1);

		//chain = "";

		Scanner debug = new Scanner(System.in);
		System.out.println("Insert the debug chain: ");
		chain = Archivo.multipleLine(debug);
		debug.close();

		System.out.println("The protein is: " + findProtein(chain, startCodon, endCodons, 0));
		System.out.println("The min index is: " + minEndCodonIndex(chain, endCodons, 0));
		System.out.println(chains(chain, startCodon, endCodons));
		//System.out.println(Fail.proteinChains(chain, startCodon, endCodons));

	}
}
