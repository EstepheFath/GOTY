import Character.*;
import Room.Room;
import Room.Shop;
import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        // Demander le nom du joueur au début
        System.out.println("Bienvenue dans le jeu !");
        System.out.println("Veuillez entrer un nom pour votre personnage :");
        String characterName = "";

        // Validation de saisie : le nom ne doit pas être vide
        while (characterName == null || characterName.trim().isEmpty()) {
            characterName = scanner.nextLine();
            if (characterName.trim().isEmpty()) {
                System.out.println("Le nom ne peut pas être vide. Veuillez entrer un nom valide :");
            }
        }

        // Initialiser le joueur une fois le nom défini
        player = new Player(characterName, 100, 10, 0, 1, 10); // Init avec des stats par défaut
        System.out.println("Personnage créé :");
        System.out.println(player.getDetails());

        // Boucle principale du jeu
        boolean continueGame = true;

        while (continueGame) {
            System.out.println("Choisis une porte:");
            System.out.println("1 - Porte gauche");
            System.out.println("2 - Porte droite");
            System.out.println("3 - Ouvrir l'inventaire");
            System.out.println("4 - Aller au magasin");
            System.out.println("0 - Quitter le jeu");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    // Utiliser la méthode statique pour générer une salle
                    Room room = Room.generateRandomRoom(player);

                    // Entrer dans la salle
                    room.enter();
                    break;

                case 3:
                    InventoryManager.openInventory(player, scanner);
                    break;

                case 4:
                    Shop shop = new Shop();
                    shop.displayItems();
                    System.out.println("Entrez le numéro de l'objet à acheter:");
                    int itemIndex = scanner.nextInt() - 1;
                    shop.buyItem(player, itemIndex);
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
}