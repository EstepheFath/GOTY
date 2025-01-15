package Room;

import Character.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CombatRoom extends Room {
    private Player player;
    private List<Enemy> enemies;

    public CombatRoom(Player player) {
        this.player = player;
        this.enemies = CharacterInitializer.createEnemies();
    }

    public CombatRoom() {

    }

    @Override
    public void enter() {
        System.out.println("Un ennemi apparaît !");
        Enemy enemy = generateEnemy();
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
                    performAttack(player, enemy);
                    if (enemy.getHealth() > 0) {
                        performAttack(enemy, player);
                    }
                    break;

                case "2": // Inventaire
                    System.out.println("Vous ouvrez votre inventaire... (Rien ne se passe pour l'instant).");
                    break;

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
        } else if (player.getHealth() <= 0) {
            System.out.println(enemy.getName() + " vous a vaincu...");
        }
    }
    
    private void performAttack(CharacterGame attacker, CharacterGame target) {
        attacker.attack(target);
        System.out.printf("%s attaque %s. La santé restante de %s est de %d.%n",
                attacker.getName(), target.getName(), target.getName(), target.getHealth());
    }
}

