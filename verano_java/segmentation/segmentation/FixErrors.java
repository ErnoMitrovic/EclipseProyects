import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import Segmentation;
public class FixErrors{
    public static void main(String[] args) {
    String path = "C:\\Users\\miran\\Desktop\\Debug chains\\dna.txt";
		File textProteins = new File(path);
		Scanner sc = new Scanner(textProteins);
		//Segmentation protein = new Segmentation(1);
		System.out.println("Insert chain: ");
		String chain = sc.next();
		final String startCodon = "atg";
		final String [] endCodons = {"taa", "tag", "tga"};

		//System.out.println("Enter the major index to find: ");
		// final int majorLength = 22;
		sc.close();

		chain = "AACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTCACCCTTCTAACTGGACTCTGACCCTGATTGTTGAGGGCTGCAAAGAGGAAGAATTTTATTTACCGTCGCTGTGGCCCCGAGTTGTCCCAAAGCGAGGTAATGCCCGCAAGGTCTGTGCTGATCAGGACGCAGCTCTGCCTTCGGGGTGCCCCTGGACTGCCCGCCCGCCCGGGTCTGTGCTGAGGAGAACGCTGCTCCGCCTCCGCGGTACTCCGGACATATGTGCAGAGAAGAACGCAGCTGCGCCCTCGCCATGCTCTGCGAGTCTCTGCTGATGAGAACACAGCTTCACTTTCGCAAAGGCGCAGCGCCGGCGCAGGCGCGGAGGGGCGCGCAGCGCCGGCGCAGGCGCGGAGGGGCGCGCCCGAACCCGAACCCTAATGCCGTCATAAGAGCCCTAGGGAGACCTTAGGGAACAAGCATTAAACTGACACTCGATTCTGTAGCCGGCTCTGCCAAGAGACATGGCGTTGCGGTGATATGAGGGCAGGGGTCATGGAAGAAAGCCTTCTGGTTTTAG";
    System.out.println(chain);
		ArrayList <String> arrayList = Segmentation.chains(chain, startCodon, endCodons);
		//System.out.println(arrayList);
		System.out.println("The number of proteins in the text is: " + arrayList.size());
		//String [] chains = GetStringArray(arrayList);
		//String protein = findProtein(chain, startCodon, endCodons, 1);

		//chain = "";

		/* Scanner debug = new Scanner(System.in);
		System.out.println("Insert the debug chain: ");
		chain = Archivo.multipleLine(debug);
		debug.close(); */

		//System.out.println(chains(chain, startCodon, endCodons));
		//System.out.println(Fail.proteinChains(chain, startCodon, endCodons));
    }
}
