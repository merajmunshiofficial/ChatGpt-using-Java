package Monoluge;

import java.util.Scanner;

public class ParagraphInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a paragraph
        System.out.println("Enter a paragraph:");

        // Read the input paragraph
        String inputParagraph = scanner.nextLine();

        // Read any remaining lines until there are none left
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputParagraph += "\n" + line;
        }

        // Display the input paragraph to the user
        System.out.println("The entered paragraph is:");
        System.out.println(inputParagraph);
    }
}
