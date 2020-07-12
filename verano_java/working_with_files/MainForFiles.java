import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class MainForFiles {
    public static void main(String[] args) throws IOException {
        CSVParser parser = csvFiles.fileToAnalyze();
        CSVParser parserCloned = csvFiles.fileToAnalyze();
        Scanner sc = new Scanner(System.in);
        //csvFiles.findExporters(parser, "COFFEE");
        String country = sc.next();
        sc.close();
        countryInfo(parserCloned, country);
        System.out.println(parser.getRecords());
    }

    /*
     * Buscar nombre de país, el país, lo que exporta y el precio. No debe de fallar
     * con mayúsculas o minúsculas. Si no está el país, país no encontrado.
     */

    //Just in case a getter

    private static void countryInfo(CSVParser parser, String country){
        for (CSVRecord csvRecord : parser) {
            String name = csvRecord.get("Country");
            System.out.println(name);
            if (country.equalsIgnoreCase(name)) {
                String export = csvRecord.get("Exports");
                String value = csvRecord.get("Value (dollars)");
                System.out.println(name + "\n" + export + "\n" + value);
            } else {
                System.out.println("input a valid country, please");
            }
        }
    }
}