package Room;

import Character.Player;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Loot> itemsForSale;

    public Shop() {
        itemsForSale = new ArrayList<>();
        String[] lootNames = {"Rusted Sword", "Bow", "Glock", "HealthPotion", "XPpotion", "ManteauDeMarque", "ManteauDeContrefacon"};
        int[] lootValues = {5, 10, 50, 5, 10, 50, 5};
        int[] lootDamages = {10, 15, 40, 0, 0, 0, 0};
        for (int i = 0; i < lootNames.length; i++) {
            itemsForSale.add(new Loot(lootNames[i], lootValues[i], lootDamages[i]));
        }
    }

    public void displayItems() {
        System.out.println("Item dispo à la vente :");
        for (int i = 0; i < itemsForSale.size(); i++) {
            System.out.println((i + 1) + ". " + itemsForSale.get(i));
        }
    }

    public void buyItem(Player player, int index) {
        if (index >= 0 && index < itemsForSale.size()) {
            Loot item = itemsForSale.get(index);
            if (player.getGold() >= item.getValue()) {
                player.subtractGold(item.getValue());
                player.addItemToInventory(item.getName());
                itemsForSale.remove(index);
                System.out.println("Vous avez acheté " + item.getName() + " pour " + item.getValue() + " or.");
            } else {
                System.out.println("Vous n'avez pas assez d'or pour acheter cet objet.");
            }
        } else {
            System.out.println("Sélection d'objet invalide.");
        }
    }
}