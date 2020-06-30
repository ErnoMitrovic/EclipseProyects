import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class csvFiles{
    public static void main(String[] args) throws IOException{
        CSVParser file = fileToAnalyze();
        int cuantos = countHowManyColors(file, "Orange");
        System.out.println("A " + cuantos + " les gusta el color naranja.");
    }
    public static CSVParser fileToAnalyze () throws IOException{
        Reader reader = Files.newBufferedReader(Paths.get("C:\\Desktop\\ClassResponses.csv"));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        return parser;
    }
    public static void printNames(CSVParser parser){
        for (CSVRecord record : parser){
            String name = record.get(2);
            String birthday = record.get("Birthday");
            System.out.println(name + " " + birthday);
        }
    }
    public static int countHowManyColors(CSVParser file, String stringToFind){
        int count = 0;
        for (CSVRecord record : file){
            String color = record.get("Favorite Color");
            if (color.contains(stringToFind)){
                count ++;
            }            
        }
        return count;
    }
}