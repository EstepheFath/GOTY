package Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterInitializer {

    public static Player createHero() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez entrer le nom de votre héros :");
        String heroName = scanner.nextLine();

        Player hero = new Player(heroName, 20, 20, 2, 19, 1, 10);

        hero.addItemToInventory("Arc");
        hero.addItemToInventory("Potion de soin");

        return hero;
    }

    public static List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();

        Enemy gobelin = new Enemy("Gobelin", 5, 2, 3, 20, 2, 5);
        Enemy skeleton = new Enemy("Skeleton", 8, 3, 2, 30, 4, 8);
        Enemy tRex = new Enemy("T-rex", 15, 5, 1, 20, 30, 15);

        Enemy jeff = new Enemy("Jeff", 999999999, 33, 1, 999999999, 999999999, 999999999);
        jeff.addItemToInventory("Chaussette");

        enemies.add(gobelin);
        enemies.add(skeleton);
        enemies.add(tRex);
        enemies.add(jeff);

        return enemies;
    }
}