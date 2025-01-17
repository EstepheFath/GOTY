import Character.*;
import Room.Room;
import Room.Shop;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner;
    private static String OPENAI_API_KEY;
    private static String OPENAI_URL;
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public Game() {
        scanner = new Scanner(System.in);
        loadApiKey();
    }

    private void loadApiKey() {
        Properties props = new Properties();
        try (InputStream input = getClass().getResourceAsStream("/config.properties")) {
            if (input == null) {
                System.out.println("Fichier config.properties introuvable !");
                return;
            }
            props.load(input);
            OPENAI_API_KEY = props.getProperty("openai.api.key");
            OPENAI_URL = props.getProperty("openai.api.url", "https://api.openai.com/v1/chat/completions");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void start() {
        // Utilisation de la méthode createHero de CharacterInitializer
        System.out.println("Bienvenue dans le jeu !");
        player = CharacterInitializer.createHero(); // Appel à la méthode pour initialiser le joueur
        System.out.println("Personnage créé :");
        System.out.println(player.getDetails());
        narrateStory("Décrivez le début d'une aventure épique dans un donjon étrange.");

        // Boucle principale du jeu
        boolean continueGame = true;

        while (continueGame) {
            System.out.println("Choisis une porte:");
            System.out.println("1 - Porte gauche");
            System.out.println("2 - Porte droite");
            System.out.println("3 - Ouvrir l'inventaire");
            System.out.println("0 - Quitter le jeu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    Room room = Room.generateRandomRoom(player);
                    narrateStory("Décrivez " + room.getDescription() + " que le joueur vient d'entrer.");
                    room.enter();
                    break;

                case 3:
                    narrateStory("Décrivez l'inventaire du joueur.");
                    InventoryManager.openInventory(player, scanner);
                    break;

                case 0:
                    System.out.println("Merci d'avoir joué !");
                    continueGame = false;
                    break;

                default:
                    System.out.println("Mauvais choix, veuillez réessayer.");
            }
        }

        scanner.close();
    }

    private String getNarration(String prompt) throws IOException {
        JsonObject requestBodyJson = new JsonObject();
        requestBodyJson.addProperty("model", "gpt-3.5-turbo");

        JsonArray messagesArray = new JsonArray();
        JsonObject userMessage = new JsonObject();
        userMessage.addProperty("role", "user");
        userMessage.addProperty("content", prompt);
        messagesArray.add(userMessage);

        requestBodyJson.add("messages", messagesArray);
        String jsonString = gson.toJson(requestBodyJson);

        RequestBody body = RequestBody.create(
                jsonString,
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(OPENAI_URL)
                .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            JsonObject responseJson = gson.fromJson(responseBody, JsonObject.class);
            JsonArray choicesArray = responseJson.getAsJsonArray("choices");

            if (choicesArray != null && choicesArray.size() > 0) {
                JsonObject firstChoice = choicesArray.get(0).getAsJsonObject();
                JsonObject messageObject = firstChoice.getAsJsonObject("message");
                return messageObject.get("content").getAsString();
            } else {
                return "No response from GPT.";
            }
        }
    }

    public void narrateStory(String prompt) {
        try {
            String narration = getNarration(prompt);
            System.out.println(formatText(narration, 80));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatText(String text, int lineLength) {
        StringBuilder formattedText = new StringBuilder();
        String[] words = text.split(" ");
        int currentLineLength = 0;

        for (String word : words) {
            if (currentLineLength + word.length() + 1 > lineLength) {
                formattedText.append("\n");
                currentLineLength = 0;
            }
            formattedText.append(word).append(" ");
            currentLineLength += word.length() + 1;
        }

        return formattedText.toString().trim();
    }
}