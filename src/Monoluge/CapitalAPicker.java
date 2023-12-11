package Monoluge;

import java.util.ArrayList;

public class CapitalAPicker {
    public static void main(String[] args) {
        String inputString = "The quick brown fox\nJumps over the lazy dog.\nArtificial Intelligence\nis the Abstract future.";
        String[] words = inputString.split("\\s+"); // Splitting the input string by whitespace
        ArrayList<String> capitalAwords = new ArrayList<>(); // Creating an ArrayList to store words starting with 'A'
        for (String word : words) {
            if (word.length() > 0 && word.charAt(0) == 'A') { // Checking if the first letter of the word is 'A'
                capitalAwords.add(word);
            }
        }
        System.out.println("Words starting with 'A': " + capitalAwords);
    }
}
