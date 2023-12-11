package Monoluge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String inputFile = "D:\\@Books\\dictionary\\modified\\Filtered_txt\\A\\Ainput.txt";
        String outputFile = "D:\\@Books\\dictionary\\modified\\Filtered_txt\\A\\Aoutput.txt";
        
        Set<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (uniqueWords.add(word)) {
                        writer.write(word + " ");
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Duplicates removed from " + inputFile + " and saved to " + outputFile);
    }
}

