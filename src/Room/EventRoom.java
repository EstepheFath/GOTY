package Room;

import java.util.Random;
import java.util.Scanner;

public class EventRoom extends Room {
    @Override
    public void enter() {
        System.out.println("Tu es dans une salle mystérieuse...");
        Random random = new Random();
        int eventType = random.nextInt(4); // 0: nothing, 1: treasure chest, 2: shop, 3: trap

        switch (eventType) {
            case 0 -> {
                System.out.println("Ptite Clime il fait bien froid ici");
                System.out.println("vous avez pris 10 dégats de froid ");
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
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choisissez un objet à acheter (entrez le numéro):");
                int choice = scanner.nextInt() - 1;
                Loot purchasedItem = shop.buyItem(choice);
                if (purchasedItem != null) {
                    System.out.println("Vous avez acheté: " + purchasedItem);
                }
            }
            case 3 -> System.out.println("Dommage vous êtes tombé dans un piège");
        }
    }

    private Loot generateLoot() {
        Random random = new Random();
        String[] lootNames = {"Rusted Sword", "Bow", "Glock", "HealthPotion", "XPpotion", "ManteauDeMarque", "ManteauDeContrefacon"};
        int[] lootValues = {5, 10, 50, 5, 10, 50, 5};
        int index = random.nextInt(lootNames.length);
        return new Loot(lootNames[index], lootValues[index]);
    }
}