import Character.*;
import java.util.List;
import Room.Room;
import Character.Character;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = CharacterInitializer.createHero();

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

            int choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("Mauvais choix");
                continue;
            }

            // Utiliser la méthode statique pour générer une salle
            Room room = Room.generateRandomRoom();

            // Entrer dans la salle
            room.enter();


        }

        scanner.close();
    }
}
//    public static void main(String[] args) {
//
//        Player hero = CharacterInitializer.createHero();
//
//        System.out.println("\n=== Détails du Héros ===");
//        System.out.println(hero.getDetails());
//        System.out.println("Inventaire :");
//        displayInventory(hero.getInventory());
//
//        List<Enemy> enemies = CharacterInitializer.createEnemies();
//
//        System.out.println("\n=== Détails des Ennemis ===");
//        for (Enemy enemy : enemies) {
//            System.out.println(enemy.getDetails());
//            System.out.println("Inventaire :");
//            displayInventory(enemy.getInventory());
//            System.out.println(); // Ligne vide pour séparer les ennemis
//        }



    // Méthode pour afficher les éléments d'un inventaire
//    private static void displayInventory(String[] inventory) {
//        boolean isEmpty = true;
//        for (String item : inventory) {
//            if (item != null) {
//                System.out.println("- " + item);
//                isEmpty = false;
//            }
//        }
//        if (isEmpty) {
//            System.out.println("L'inventaire est vide.");
//        }
//    }

