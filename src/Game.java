import Character.*;
import Room.Room;
import Room.Shop;
import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
        player = new Player("Hero", 100, 10, 0, 1, 10); // Initialize player with gold
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
            System.out.println("4 - Aller au magasin");

            int choice = scanner.nextInt();
            if (choice == 3) {
                InventoryManager.openInventory(player, scanner);
                continue;
            } else if (choice == 4) {
                Shop shop = new Shop();
                shop.displayItems();
                System.out.println("Entrez le numéro de l'objet à acheter:");
                int itemIndex = scanner.nextInt() - 1;
                shop.buyItem(player, itemIndex);
                continue;
            } else if (choice != 1 && choice != 2) {
                System.out.println("Mauvais choix");
                continue;
            }

            // Utiliser la méthode statique pour générer une salle
            Room room = Room.generateRandomRoom(player);

            // Entrer dans la salle
            room.enter();
        }

        scanner.close();
    }
}