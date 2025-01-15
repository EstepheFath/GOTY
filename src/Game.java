import Character.*;
import Room.Room;
import Room.Shop;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner;
    private Shop shop;

    public Game() {
        scanner = new Scanner(System.in);
        player = new Player("Hero", 100, 10, 0, 1, 10); // Initialize player with gold
        shop = new Shop(); // Initialize the shop
    }

    public void start() {
        if (player.getName() == null || player.getName().isEmpty()) {
            System.out.println("Aucun nom de personnage n'a été défini. Veuillez entrer un nom pour votre personnage :");
            String characterName = scanner.nextLine();
            player.setName(characterName);
        }

        System.out.println("Personnage créé :");
        System.out.println(player.getDetails());

        boolean continueGame = true;

        while (continueGame) {
            System.out.println("Choisis une porte:");
            System.out.println("1 - Porte gauche");
            System.out.println("2 - Porte droite");
            System.out.println("3 - Ouvrir l'inventaire");

            int choice = scanner.nextInt();
            if (choice == 3) {
                InventoryManager.openInventory(player, scanner);
                continue;
            } else if (choice != 1 && choice != 2) {
                System.out.println("Mauvais choix");
                continue;
            }

            // Utiliser la méthode statique pour générer une salle
            Room room = Room.generateRandomRoom(player);

            // Entrer dans la salle
            room.enter();

            // Randomly trigger the shop event
            if (new Random().nextInt(4) == 0) { // 25% chance to trigger the shop event
                handleShopEvent();
            }
        }

        scanner.close();
    }

    private void handleShopEvent() {
        boolean shopping = true;
        while (shopping) {
            shop.displayItems();
            System.out.println("Entrez le numéro de l'objet à acheter ou 0 pour quitter:");
            int itemIndex = scanner.nextInt() - 1;
            if (itemIndex == -1) {
                shopping = false;
            } else {
                shop.buyItem(player, itemIndex);
            }
        }
    }
}