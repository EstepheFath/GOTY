package Room;

import Character.*;
import java.util.List;
import java.util.Random;

public class CombatRoom extends Room {
    private Player player;
    private List<Enemy> enemies;

    public CombatRoom(Player player) {
        this.player = player;
        this.enemies = CharacterInitializer.createEnemies();
    }

    @Override
    public void enter() {
        System.out.println("Un ennemi apparaît !");
        Enemy enemy = generateEnemy();
        System.out.println("Vous combattez: " + enemy.getName());
        // Add combat logic here
    }

    private Enemy generateEnemy() {
        Random random = new Random();
        int enemyIndex = random.nextInt(enemies.size());
        return enemies.get(enemyIndex);
    }
}