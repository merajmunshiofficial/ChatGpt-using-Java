package Monoluge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalAWordExtractor {
    public static void main(String[] args) {
        String filePath = "D:\\@Books\\dictionary\\modified\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String regex = "\\bA[A-Za-z]*\\b";
            Pattern pattern = Pattern.compile(regex);

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String word = matcher.group();
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
