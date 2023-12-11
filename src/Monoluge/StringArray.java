package Monoluge;

import java.util.Scanner;

public class StringArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Split the input string into an array of strings using whitespace as the delimiter
        String[] stringArray = inputString.split("\\s+");

        // Print the string array
        for (String s : stringArray) {
            System.out.println("write me a \" " +s+ "\" monologue  in hinglish\r\n"
            		+ "");
        }
    }
}
