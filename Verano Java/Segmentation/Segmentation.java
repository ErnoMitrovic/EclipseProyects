//package claseSegmentation;
import java.util.Scanner;
import java.util.ArrayList;

/*
* Encontrar si la cadena tiene codon inicial, final y regresar la proteina
* Imprimir los �ndices de inicio y final
*/
//cccatggggtttaaataataataggagagagagagagagttt
//atgaataagtaa

public class Segmentation {
	/*
	int nOfProtein;
	String arn;
	public Segmentation(int nOfProtein){
		arn = "empty";
		this.nOfProtein = nOfProtein;
	}
	*/

	public static String find(final String chain, final String startCodon, final String endCodon) {
		String protein = "Not found";
		final int start = chain.indexOf(startCodon);
		if (start < 0) return protein + " start.";
		//else if (end < 0) return protein + " end.";
		else {
			int end = chain.indexOf(endCodon, start + startCodon.length());
			protein = chain.substring(start,end + endCodon.length());
			while (protein.length() % 3 != 0 && end > 0) {
				end = chain.indexOf(endCodon, end + endCodon.length());
				protein = chain.substring(start, end + endCodon.length());
				if (protein.length() % 3 != 0) end = -1;
			}
			if (end < 0) return "Not found" + " end. \nIn the text there are no proteins";
			else System.out.println("The index of start is: " + start + "\nThe index of end is: " + (end + endCodon.length()-1));
			return protein;
		}
	}
	public static void main(final String[] args){
		Scanner sc = new Scanner(System.in);
		//ArrayList<Segmentation> proteins = new ArrayList<>();
		Segmentation protein = new Segmentation(1);
		System.out.println("Insert chain: ");
		String chain = sc.next();
		final String startCodon = "atg";
		final String endCodon = "taa";
		sc.close();
		System.out.println(find(chain, startCodon, endCodon));
		/*
		proteins.add(protein);
		proteins.get(0).arn = find(chain,startCodon,endCodon);
		if (chain.substring(lastIndex(chain,startCodon,endCodon), chain.length()).length() < startCodon.length()*2){
			System.out.println("The protein is " + proteins.get(0).arn);
		}
		*/
	}
	/*
	protected static int lastIndex(final String chain, final String startCodon, final String endCodon){
		final int start = chain.indexOf(startCodon);
		int lastInd = -1;
		if (start < 0) return -1;
		else {
			lastInd = chain.indexOf(endCodon, start + startCodon.length());
			String protein = chain.substring(start, lastInd + endCodon.length());
			while (protein.length() % 3 != 0 && lastInd > 0){
				lastInd = chain.indexOf(endCodon, lastInd + endCodon.length());
				protein = chain.substring(start, lastInd + endCodon.length());
				if (protein.length() % 3 != 0) lastInd = -1;
			}
		}
		return lastInd;
	}
	*/
}
