package txt_Merger;

import java.io.*;

public class MergeTxtFiles {

    public static void main(String[] args) {

        // Set the path of the directory that contains files to merge
        String inputDir = "D:\\@Books\\dictionary\\modified\\Filtered_txt\\A\\output\\";

        // Set the path for the output file
        String outputFile = "D:\\@Books\\dictionary\\modified\\Filtered_txt\\A\\output\\merged\\merged_file.txt";

        try {

            // Create a new output file
            File mergedFile = new File(outputFile);
            mergedFile.createNewFile();

            // Open the output file for writing
            FileWriter writer = new FileWriter(mergedFile);

            // Get a list of all files in the directory
            File[] fileList = new File(inputDir).listFiles();

            // Loop over each file in the list
            for (File file : fileList) {

                if (file.isFile() && file.getName().endsWith(".txt")) {
                    // Open the file for reading
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    // Write the contents of the file to the output file
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line + "\n");
                    }

                    // Close the file
                    reader.close();
                }
            }

            // Close the output file
            writer.close();

            System.out.println("Merged files successfully.");

        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }
}
