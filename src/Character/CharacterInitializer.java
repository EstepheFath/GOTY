package Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterInitializer {

    public static Player createHero() {
        Player hero = new Player("Hero", 20, 2, 0, 1);

        hero.addItemToInventory("Épée de rouillée");
        hero.addItemToInventory("Potion de soin");

        return hero;
    }

    public static List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();

        // Création et ajout des ennemis avec inventaire
        Enemy gobelin = new Enemy("Gobelin", 5, 2, 3, 2, 2);

        Enemy skeleton = new Enemy("Skeleton", 8, 3, 2, 3, 4);

        Enemy tRex = new Enemy("T-rex", 15, 5, 1, 10, 30);

        Enemy jeff = new Enemy("Jeff", 999999999, 33, 1, 999999999, 999999999);
        jeff.addItemToInventory("Chaussette");

        // Ajouter les ennemis à la liste
        enemies.add(gobelin);
        enemies.add(skeleton);
        enemies.add(tRex);
        enemies.add(jeff);

        return enemies;
    }
}