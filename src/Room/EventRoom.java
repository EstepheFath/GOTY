package Room;

import Character.Player;
import java.util.Random;
import java.util.Scanner;

public class EventRoom extends Room {
    private Player player;

    public EventRoom(Player player) {
        super("a mysterious room with unknown events");
        this.player = player;
    }

    @Override
    public void enter() {
        System.out.println("Tu es dans une salle mystérieuse...");
        Random random = new Random();
        int eventType = random.nextInt(4); // 0: nothing, 1: treasure chest, 2: shop, 3: combat

        switch (eventType) {
            case 0 -> {
                System.out.println("Ptite Clime il fait bien froid ici");
                player.setHealth(player.getHealth() - 10);
                System.out.println("Vous avez pris 10 dégâts de froid. Santé actuelle: " + player.getHealth());
            }
            case 1 -> {
                System.out.println("Coffre au centre de la pièce");
                Loot loot = generateLoot();
                System.out.println("Vous trouvez: " + loot);
            }
            case 2 -> {
                System.out.println("Un marchand chelou vous propose des objets");
                Shop shop = new Shop();
                shop.displayItems();
                handlePurchase(shop);
            }
        }
    }

    private void handlePurchase(Shop shop) {
        Scanner scanner = new Scanner(System.in);
        boolean shopping = true;

        while (shopping) {
            shop.displayItems();
            System.out.println("Choisissez un objet à acheter (entrez le numéro), 0 pour quitter le shop, ou -1 pour attaquer le marchand:");
            int choice = scanner.nextInt() - 1;

            if (choice == -1) {
                shopping = false;
                System.out.println("Vous avez quitté le shop.");
            } else if (choice == -2) {
                shopping = false;
                System.out.println("Vous avez attaqué le marchand !");
                initiateCombatWithMerchant();
            } else {
                shop.buyItem(player, choice);
            }
        }
    }

    private void initiateCombatWithMerchant() {
        Scanner scanner = new Scanner(System.in);
        int merchantHealth = 100;
        int playerHealth = player.getHealth();
        Random random = new Random();

        System.out.println("Combat avec le marchand commence !");
        while (merchantHealth > 0 && playerHealth > 0) {
            System.out.println("1. Attaquer");
            System.out.println("2. Fuir");
            int choice = scanner.nextInt();

            if (choice == 1) {
                int playerDamage = random.nextInt(20) + 1;
                int merchantDamage = random.nextInt(15) + 1;

                merchantHealth -= playerDamage;
                playerHealth -= merchantDamage;

                System.out.println("Vous avez infligé " + playerDamage + " dégâts au marchand.");
                System.out.println("Le marchand vous a infligé " + merchantDamage + " dégâts.");
                System.out.println("Santé du marchand: " + merchantHealth);
                System.out.println("Votre santé: " + playerHealth);
            } else if (choice == 2) {
                System.out.println("Vous avez fui le combat.");
                break;
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        if (merchantHealth <= 0) {
            System.out.println("Vous avez vaincu le marchand !");
        } else if (playerHealth <= 0) {
            System.out.println("Vous avez été vaincu par le marchand...");
            player.setHealth(0); // Set player health to 0 if defeated
        } else {
            player.setHealth(playerHealth); // Update player health if they fled
        }
    }

    private Loot generateLoot() {
        Random random = new Random();
        String[] lootNames = {"Epée rouillée", "Arc", "Glock", "Potion de vie", "Potion d'xp", "ManteauDeMarque", "ManteauDeContrefacon"};
        int[] lootValues = {5, 10, 50, 5, 10, 50, 5};
        int[] lootDamages = {10, 15, 40, 0, 0, 0, 0}; // Damage for each loot item, 0 for items without damage.

        int index = random.nextInt(lootNames.length);
        return new Loot(lootNames[index], lootValues[index], lootDamages[index]);
    }
}