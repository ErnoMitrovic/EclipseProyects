import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class csvFiles{
    public static CSVParser fileToAnalyze () throws IOException{
        String stringPath = "G:\\Mi unidad\\ESCUELA\\Tec 5° semestre\\Computer science\\IBProyects\\verano_java\\working_with_files\\test_files\\exportsmall.csv";
        Reader reader = Files.newBufferedReader(Paths.get(stringPath));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        return parser;
    }
    
    public static void printNames(CSVParser parser){
        for (CSVRecord record : parser){
            String name = record.get(1);
            System.out.println(name);
        }
    }
    
    public static int countHowManyColors(CSVParser file, String stringToFind){
        int count = 0;
        for (CSVRecord record : file){
            String color = record.get("Color favorito");
            if (color.contains(stringToFind)){
                count ++;
            }            
        }
        return count;
    }

    public static int findLikes(CSVParser file, String toFind){
        int count = 0;
        toFind = toFind.toUpperCase();
        for (CSVRecord record : file) {
            String like = record.get("Favorite Foods and Drinks");
            like = like.toUpperCase();
            if (like.contains(toFind)){
                count++;
            }
        }
        return count;
    }
    
    public static void findExporters(CSVParser parser, String toFind) {
        for (CSVRecord record : parser) {
            String inFileText = record.get("Exports");
            inFileText = inFileText.toUpperCase();
            if (inFileText.equals(toFind)){
                System.out.println(record.get(0));
            }
        }
    }
    
    public static void countExports(CSVParser parser, String toFind){
        int count = 0;
        for (CSVRecord record : parser) {
            String inFileText = record.get("Exports");
            inFileText = inFileText.toUpperCase();
            if (inFileText.equals(toFind)) {
                count++;
            }
        }
        System.out.println(count + " country exports " + toFind.toLowerCase());
    }
}