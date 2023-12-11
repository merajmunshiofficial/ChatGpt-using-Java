package Monoluge;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstWordExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String sentence = scanner.nextLine();

        // Define a regular expression to match words that start with a capital letter A
        String regex = "\\bA[A-Za-z]*\\b";

        // Create a pattern object from the regular expression
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object to match the pattern against the sentence
        Matcher matcher = pattern.matcher(sentence);

        // Extract all words from the sentence that start with a capital letter A
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        System.out.println(sb.toString().trim()); // Prints the output on a single line
    }
}
