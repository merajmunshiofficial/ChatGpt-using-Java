package ChatGpt_Api;



import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class OpenAIGPTClient2 {
    private static final String API_ENDPOINT = "https://api.openai.com/v1/engines/davinci-codex/completions";
    private static final ObjectMapper mapper = new ObjectMapper();
    private final String apiKey;

    public OpenAIGPTClient2(String apiKey) {
        this.apiKey = apiKey;
    }

    public String generateText(String prompt) throws IOException {
        // Build the request payload
        JsonNodeFactory factory = JsonNodeFactory.instance;
        ObjectNode requestBody = factory.objectNode();
        requestBody.put("prompt", prompt);
        requestBody.put("temperature", 0.8);
        requestBody.put("max_tokens", 2000);
        requestBody.put("top_p", 1);
        requestBody.put("frequency_penalty", 0);
        requestBody.put("presence_penalty", 0);
        requestBody.put("stop", "\n");

        // Send the request
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(API_ENDPOINT);
        httppost.addHeader("Content-Type", "application/json");
        httppost.addHeader("Authorization", "Bearer " + apiKey);
        httppost.setEntity(new StringEntity(requestBody.toString()));

        HttpResponse response = httpclient.execute(httppost);
        String responseData = EntityUtils.toString(response.getEntity());

        // Parse the response
        JsonNode responseJson = mapper.readTree(responseData);
        JsonNode choices = responseJson.get("choices");
        JsonNode text = choices.get(0).get("text");

        return text.asText();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the API key
        System.out.print("Enter the OpenAI API key: ");
        String apiKey = scanner.nextLine();

        // Initialize the OpenAI GPT-3 client
        OpenAIGPTClient2 client = new OpenAIGPTClient2(apiKey);

        // Generate text based on user input
        System.out.print("Enter a prompt: ");
        String prompt = scanner.nextLine();
        try {
            String generatedText = client.generateText(prompt);
            System.out.println("Generated text: " + generatedText);
        } catch (IOException e) {
            System.out.println("Error generating text: " + e.getMessage());
        }
    }
}
