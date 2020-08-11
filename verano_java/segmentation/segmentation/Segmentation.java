import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Segmentation {
	static ArrayList<String> chains(String text, final String startCodon, final String[] endCodons, String char1, String char2){
		ArrayList<String> proteins = new ArrayList<>();
		boolean conditional = true;
		while (conditional == true){
			String protein = find(text, startCodon, endCodons);
			if (protein.isEmpty()) conditional = false;
			else {
				text = newChainsText(protein, text);
				ratiosList(protein, char1, char2);
				proteins.add(protein);
			}
		}
		return proteins;
	}
	static ArrayList<Double> ratiosList(String protein, String char1, String char2){
		ArrayList<Double> ratList = new ArrayList<>();
		int char1Times = howMany(protein, char1);
		int char2Times = howMany(protein, char2);
		int charsInProtein = char1Times + char2Times;
		double ratio = ratio(charsInProtein, protein);
		ratList.add(ratio);
		return ratList;
	}
	public static void main(String[] args) throws IOException {
		Path path = Path.of("C:\\Users\\miran\\Desktop\\Debug chains\\dna.txt");
		String rawText = Files.readString(path);
		// System.out.println(rawText);
		String text = rawText.toLowerCase();
		String startCodon = "atg";
		String [] endCodons = {"taa", "tag", "tga"};
		String char1 = "c";
		String char2 = "g";
		List<String> proteinList = new ArrayList<String>();
		List<Double> ratioList = new ArrayList<Double>();

		boolean status = true;

		while (status == true) {

			String validProtein = find(text, startCodon, endCodons);
			if (validProtein.contentEquals("")) {
				status = false;
			} else {
				int char1Times = howMany(validProtein, char1);
				int char2Times = howMany(validProtein, char2);
				int charsInProtein = char1Times + char2Times;
				double ratio = ratio(charsInProtein, validProtein);
				text = newChainsText(validProtein, text);
				proteinList.add(validProtein);
				ratioList.add(ratio);
			}
		}

		// System.out.println("Lista de proteinas");

		// for (String i : proteinList) {
		// System.out.println(i);
		// }

		// System.out.println("Lista de ratios");

		// for (double i : ratioList) {
		// System.out.println(i);
		// }

		for (int i = 0; i <= proteinList.size() - 1; i++) {
			System.out.println("Proteina " + (i + 1) + ": [" + proteinList.get(i) + "] Ratio de " + char1 + " y "
					+ char2 + ": {" + ratioList.get(i) + "}");
		}

		System.out.println(proteinList.size());

	}

	public static int howMany(String word1, String word2) {

		int count = 0;
		int start = word1.indexOf(word2);
		// System.out.println("Proteina: " + word1);
		// System.out.println("Car�ctere buscado; " + word2);
		boolean status = true;
		while (status) {
			if (start == -1) {
				status = false;
			} else {
				count++;
				start = word1.indexOf(word2, start + word2.length());
			}

		}
		// System.out.print("Numero de veces en la proteina: ");
		// System.out.println(count);
		return count;
	}

	public static double ratio(double value1, String text) {
		double ratio = value1 / text.length();
		// System.out.println("Ratio: " + ratio);
		return ratio;
	}

	public static String newChainsText(String replacement, String completeText) {
		String finalReplacement = completeText.substring(0, completeText.indexOf(replacement) + replacement.length());
		completeText = completeText.replaceFirst(finalReplacement, "");
		return completeText;
	}

	public static String find(String word, String startCodon, String [] endCodons) {
		// System.out.println("ADN: " + word);
		int start = word.indexOf(startCodon);
		int end = 0;
		int end1 = word.indexOf(endCodons[0], start + startCodon.length());
		int end2 = word.indexOf(endCodons[1], start + startCodon.length());
		int end3 = word.indexOf(endCodons[2], start + startCodon.length());
		int currentIndex1 = 0;
		int currentIndex2 = 0;
		int currentIndex3 = 0;
		String protein = "";

		while ((end1 - start) % 3 != 0 && end1 != -1 && start != -1) {
			// String protein1 = word.substring(start, end1+endCodon1.length());
			String wholeWord1 = word.substring(0, end1 + endCodons[0].length());
			currentIndex1 = wholeWord1.length();

			// System.out.println("El ADN " + protein1 + " no es m�ltiplo de tres");
			// System.out.println(protein1.length());
			// System.out.println(currentIndex1);
			// System.out.println(end1);
			end1 = word.indexOf(endCodons[0], currentIndex1);
			// System.out.println(end1);

		}
		while ((end2 - start) % 3 != 0 && end2 != -1 && start != -1) {
			// String protein2 = word.substring(start, end2+endCodon2.length());
			String wholeWord2 = word.substring(0, end2 + endCodons[1].length());
			currentIndex2 = wholeWord2.length();

			// System.out.println("El ADN " + protein2 + " no es m�ltiplo de tres");
			// System.out.println(protein2.length());
			// System.out.println(currentIndex2);
			// System.out.println(end2);
			end2 = word.indexOf(endCodons[1], currentIndex2);
			// System.out.println(end2);

		}

		while ((end3 - start) % 3 != 0 && end3 != -1 && start != -1) {
			// String protein3 = word.substring(start, end3+endCodon3.length());
			String wholeWord3 = word.substring(0, end3 + endCodons[2].length());
			currentIndex3 = wholeWord3.length();

			// System.out.println("El ADN " + protein3 + " no es m�ltiplo de tres");
			// System.out.println(protein3.length());
			// System.out.println(currentIndex3);
			// System.out.println(end3);
			end3 = word.indexOf(endCodons[2], currentIndex3);
			// System.out.println(end3);

		}

		if (end1 == -1 && end2 == -1 && end3 == -1) {
			end = -1;
		}

		else {
			if (end1 == -1)
				end1 = word.length() + 1;
			if (end2 == -1)
				end2 = word.length() + 1;
			if (end3 == -1)
				end3 = word.length() + 1;

			if (end1 >= 0 && end1 < end2 && end1 < end3) {
				end = end1;
			} else if (end2 >= 0 && end2 < end1 && end2 < end3) {
				end = end2;
			} else if (end3 >= 0 && end3 < end1 && end3 < end2) {
				end = end3;
			} else {
				System.out.println("Idk");
			}
		}

		if (start >= 0 && end >= 0) {
			protein = word.substring(start, end + 3);

			// System.out.println("La proteina es: " + protein + " y es m�ltiplo de tres");
			return protein;

		}

		else if (start == -1 && end == -1) {
			System.out.println("No more proteins were found.");
			System.out.println("Reason:\n Neither codon was found.");
			return "";
		} else if (start == -1) {
			System.out.println("No more proteins were found.");
			System.out.println("Reason:\nFirst codon wasn't found.");
			return "";
		} else if (end == -1) {
			System.out.println("No more proteins were found");
			System.out.println("Reason:\nNo end codons were found.");
			return "";
		} else {
			return "";
		}
	}
}