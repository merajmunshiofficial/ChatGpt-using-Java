package Monoluge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiLineSentenceInput {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Prompt the user to enter a sentence that may contain multiple lines
        System.out.println("Enter a sentence that may contain multiple lines:");

        // Read the input sentence
        StringBuilder inputSentence = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            inputSentence.append(line).append("\n");
            if (line.isEmpty()) {
                break;
            }
        }

        // Display the input sentence to the user
        System.out.println("The entered sentence is:");
        System.out.println(inputSentence.toString());
    }
}
