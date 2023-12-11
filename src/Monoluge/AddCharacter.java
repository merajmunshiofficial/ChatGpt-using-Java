package Monoluge;

import java.util.Scanner;

public class AddCharacter {
    
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter multiple lines of sentences
        System.out.println("Enter multiple lines of sentences (press enter twice to finish):");

        // Create an empty string to store the input lines
        String inputString = "";

        // Read input lines until an empty line is entered
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputString += line + "\n";
        }

        // Split the input string into an array of sentences
        String[] sentences = inputString.split("\\.");

        // Display the sentences to the user
        System.out.println("The entered sentences are:");
        for (String sentence : sentences) {
            System.out.println(sentence.trim() + ".");
        }
    }
}
