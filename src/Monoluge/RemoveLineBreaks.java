package Monoluge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveLineBreaks {
    public static void main(String[] args) {
        String inputFilePath = "D:\\@Books\\dictionary\\modified\\input.txt";
        String outputFilePath = "D:\\@Books\\dictionary\\modified\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove new line breaks from the line
                String lineWithoutBreaks = line.replaceAll("\\r\\n|\\r|\\n", "");

                // Write the modified line to the output file
                writer.write(lineWithoutBreaks);

                // Add a newline character to the output file
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file.");
            e.printStackTrace();
        }

        System.out.println("New line breaks removed from " + inputFilePath + " and saved to " + outputFilePath);
    }
}
