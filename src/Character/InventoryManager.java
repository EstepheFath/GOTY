package Character;

import java.util.Scanner;

public class InventoryManager {

    public static void openInventory(Player player, Scanner scanner) {
        boolean inInventory = true;
        while (inInventory) {
            System.out.println("Inventaire:");
            String[] inventory = player.getInventory();
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null) {
                    System.out.println((i + 1) + " - " + inventory[i]);
                }
            }
            System.out.println("E - Équiper un objet");
            System.out.println("U - Déséquiper l'objet actuel");
            System.out.println("C - Utiliser un objet");
            System.out.println("Q - Quitter l'inventaire");

            String action = scanner.next();
            switch (action.toUpperCase()) {
                case "E":
                    System.out.println("Entrez le numéro de l'objet à équiper:");
                    int equipIndex = scanner.nextInt() - 1;
                    if (equipIndex >= 0 && equipIndex < inventory.length && inventory[equipIndex] != null) {
                        player.equipItem(inventory[equipIndex]);
                    } else {
                        System.out.println("Numéro d'objet invalide.");
                    }
                    break;
                case "U":
                    player.unequipItem();
                    break;
                case "C":
                    System.out.println("Entrez le numéro de l'objet à utiliser:");
                    int useIndex = scanner.nextInt() - 1;
                    if (useIndex >= 0 && useIndex < inventory.length && inventory[useIndex] != null) {
                        player.useItem(inventory[useIndex]);
                    } else {
                        System.out.println("Numéro d'objet invalide.");
                    }
                    break;
                case "Q":
                    inInventory = false;
                    break;
                default:
                    System.out.println("Action invalide.");
            }
        }
    }
}