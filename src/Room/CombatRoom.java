package Room;

import Character.*;
import Fight.Fight; // Importation de la classe Fight
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CombatRoom extends Room {
    private Player player;
    private List<Enemy> enemies;
    private Fight fightHandler; // Instance pour gérer les attaques et l'affichage ASCII

    public CombatRoom(Player player) {
        this.player = player;
        this.enemies = CharacterInitializer.createEnemies();
        this.fightHandler = new Fight(); // Initialisation de l'instance Fight
    }

    public CombatRoom() {
        this.fightHandler = new Fight(); // Initialisation de l'instance Fight
    }

    @Override
    public void enter() {
        System.out.println("Un ennemi apparaît !");
        Enemy enemy = generateEnemy();

        // Utiliser l'instance de Fight pour afficher l'ASCII de l'ennemi
        fightHandler.displayEnemyAscii(enemy);

        System.out.println("Vous combattez: " + enemy.getName());
        startCombat(enemy);
    }

    private Enemy generateEnemy() {
        Random random = new Random();
        int enemyIndex = random.nextInt(enemies.size());
        return enemies.get(enemyIndex);
    }

    private void startCombat(Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Le combat commence !");

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Inventaire");
            System.out.println("3. Fuir");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": // Attaquer
                    // Utiliser l'instance de Fight pour effectuer une attaque
                    fightHandler.performAttack(player, enemy);
                    if (enemy.getHealth() > 0) {
                        fightHandler.performAttack(enemy, player);
                    }
                    break;

                case "2": // Inventaire
                    InventoryManager.openInventory(player, scanner);
                    continue;

                case "3": // Fuir
                    System.out.println("Vous avez choisi de fuir le combat !");
                    System.out.println("Vous quittez la salle de combat...");
                    return;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }

        // Conclusion du combat
        if (player.getHealth() > 0 && enemy.getHealth() <= 0) {
            System.out.println("Vous avez vaincu " + enemy.getName() + " !");

            // Récupérer et ajouter les PO de l'ennemi au joueur
            int gainedGold = enemy.getPOdrop();
            player.addGold(gainedGold); // Ajouter l'or au joueur
            System.out.println("Vous avez gagné " + gainedGold + " PO !");
            System.out.println("Vous avez maintenant " + player.getGold() + " PO.");

            // Récupérer et ajouter l'XP de l'ennemi au joueur
            int gainedXp = enemy.getXPdrop();
            player.addXp(gainedXp); // Ajouter l'expérience au joueur
            System.out.println("Vous avez gagné " + gainedXp + " XP !");
            System.out.println("Vous avez maintenant " + player.getXp() + " XP.");

            // Utilisation de XpManager pour gérer le potentiel changement de niveau
            XpManager xpManager = new XpManager(player); // Crée un gestionnaire d'XP pour ce joueur
            xpManager.checkXpAndLevelUp(player); // Vérifie et applique les montées de niveau si nécessaire

        } else if (player.getHealth() <= 0) {
            System.out.println(enemy.getName() + " vous a vaincu...");
        }
    }
}