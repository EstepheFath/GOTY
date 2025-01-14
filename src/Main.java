import Character.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Initialiser le héros
        Player hero = CharacterInitializer.createHero();

        // Afficher les détails du héros
        System.out.println("\n=== Détails du Héros ===");
        System.out.println(hero.getDetails());
        System.out.println("Inventaire :");
        displayInventory(hero.getInventory());

        // Initialiser les ennemis
        List<Enemy> enemies = CharacterInitializer.createEnemies();

        // Afficher les détails de chaque ennemi
        System.out.println("\n=== Détails des Ennemis ===");
        for (Enemy enemy : enemies) {
            System.out.println(enemy.getDetails());
            System.out.println("Inventaire :");
            displayInventory(enemy.getInventory());
            System.out.println(); // Ligne vide pour séparer les ennemis
        }
    }

    // Méthode pour afficher les éléments d'un inventaire
    private static void displayInventory(String[] inventory) {
        boolean isEmpty = true;
        for (String item : inventory) {
            if (item != null) {
                System.out.println("- " + item);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("L'inventaire est vide.");
        }
    }
}
