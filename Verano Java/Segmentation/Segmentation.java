import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;;

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
				//int indexForArray = 0;
				int flag = 0;
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
							flag++;
							if (flag > 7) break;
							if (indexStartRepeat == start && indexEndRepeat == end) break;
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
							flag++;
							if (flag > 7) break;
							if (indexStartRepeat == start && indexEndRepeat == end1) break;
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
							flag++;
							if (flag > 7) break;
							if (indexStartRepeat == start && indexEndRepeat == end2) break;
							indexEndRepeat = end2;
							indexStartRepeat = start;
						}
						protein = chain.substring(start, end2 + endCodon1.length());
						proteins.add(protein);
						//aindexForArray++;
						chain = chain.replace(protein, "");
					}
					if (flag == 4) break;
					flag++;
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
	public static void main(final String[] args){
		Scanner sc = new Scanner(System.in);
		//ArrayList<Segmentation> proteins = new ArrayList<>();
		//Segmentation protein = new Segmentation(1);
		System.out.println("Insert chain: ");
		String chain = sc.next();
		final String startCodon = "atg";
		final String endCodon = "taa";
		final String endCodon1 = "tag";
		final String endCodon2 = "tga";
		sc.close();
		//String empty = chain.replace(chain, "");
		System.out.println(find(chain, startCodon, endCodon,endCodon1,endCodon2));

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
