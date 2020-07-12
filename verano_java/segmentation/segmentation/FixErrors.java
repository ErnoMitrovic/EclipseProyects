import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

/* 
String path="C:\\Users\\miran\\Desktop\\Debug chains\\dna.txt";File textProteins=new File(path);Scanner sc=new Scanner(textProteins);
//Segmentation protein = new Segmentation(1);
System.out.println("Insert chain: ");String chain=sc.next();final String startCodon="atg";final String[]endCodons={"taa","tag","tga"
};

//System.out.println("Enter the major index to find: ");
// final int majorLength = 22;
sc.close();

chain="AACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTAACCCTCACCCTTCTAACTGGACTCTGACCCTGATTGTTGAGGGCTGCAAAGAGGAAGAATTTTATTTACCGTCGCTGTGGCCCCGAGTTGTCCCAAAGCGAGGTAATGCCCGCAAGGTCTGTGCTGATCAGGACGCAGCTCTGCCTTCGGGGTGCCCCTGGACTGCCCGCCCGCCCGGGTCTGTGCTGAGGAGAACGCTGCTCCGCCTCCGCGGTACTCCGGACATATGTGCAGAGAAGAACGCAGCTGCGCCCTCGCCATGCTCTGCGAGTCTCTGCTGATGAGAACACAGCTTCACTTTCGCAAAGGCGCAGCGCCGGCGCAGGCGCGGAGGGGCGCGCAGCGCCGGCGCAGGCGCGGAGGGGCGCGCCCGAACCCGAACCCTAATGCCGTCATAAGAGCCCTAGGGAGACCTTAGGGAACAAGCATTAAACTGACACTCGATTCTGTAGCCGGCTCTGCCAAGAGACATGGCGTTGCGGTGATATGAGGGCAGGGGTCATGGAAGAAAGCCTTCTGGTTTTAG";System.out.println(chain);ArrayList<String>arrayList=Fail.chains(chain,startCodon,endCodons);String[]stringArr=Segmentation.GetStringArray(arrayList);
//System.out.println(arrayList);
System.out.println(arrayList);System.out.println("The number of proteins in the text is: "+arrayList.size());System.out.println("The longest protein has "+Segmentation.longestGene(stringArr)+" letters.");String chainFound=Segmentation.findProtein(chain,startCodon,endCodons,0);System.out.println("Debug chain found "+endCodons[0]+": "+chainFound+"\nWith length: "+chainFound.length());
//String [] chains = GetStringArray(arrayList);
//String protein = findProtein(chain, startCodon, endCodons, 1);

//chain = "";

/* Scanner debug = new Scanner(System.in);
System.out.println("Insert the debug chain: ");
chain = Archivo.multipleLine(debug);
debug.close(); */

//System.out.println(chains(chain, startCodon, endCodons));
//System.out.println(Fail.proteinChains(chain, startCodon, endCodons)); */

public class FixErrors {
	public static void main(String[] args) throws FileNotFoundException{
		String path = "C:\\Users\\miran\\Desktop\\Debug chains\\dna.txt";
		File textProteins = new File(path);
		Scanner debug = new Scanner(textProteins);
		final String chain = debug.next();
		final String startCodon = "atg";
		final String [] endCodons = {"taa","tag","tga"};
		debug.close();
		System.out.println(Segmentation.proteinsInText(chain, startCodon, endCodons).size());
    }
}
//atga123tgaatg123tag