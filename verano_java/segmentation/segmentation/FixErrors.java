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

System.out.println(chain);ArrayList<String>arrayList=Fail.chains(chain,startCodon,endCodons);String[]stringArr=Segmentation.GetStringArray(arrayList);
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
		String path="C:\\Users\\miran\\Desktop\\Debug chains\\dna.txt";
		File textProteins=new File(path);
		Scanner sc = new Scanner(textProteins);
		String text = Archivo.multipleLine(sc);
		text = text.toLowerCase();
		final String startCodon = "atg";
		final String [] endCodons = {"taa","tag","tga"};
		final String char1 = "c";
		final String char2 = "g";
		sc.close();
		System.out.println(Segmentation.chains(text, startCodon, endCodons, char1, char2).size());
		/* Scanner debug = new Scanner(System.in);
		chain = Archivo.multipleLine(debug);
		debug.close(); */
		/* ArrayList <String> chains = Fail.proteinsInText(chain, startCodon, endCodons);
		int i = 1;
		for (String string : chains) {
			System.out.println("The protein " + i + " has a length of: " + string.length());
			i++;
		}
		System.out.println(chains.size());
		System.out.println(chains); */
    }
}