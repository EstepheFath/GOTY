package Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    private List<Loot> itemsForSale;

    public Shop() {
        itemsForSale = new ArrayList<>();
        String[] lootNames = {"Rusted Sword", "Bow", "Glock", "HealthPotion", "XPpotion", "ManteauDeMarque", "ManteauDeContrefacon"};
        int[] lootValues = {5, 10, 50, 5, 10, 50, 5};
        for (int i = 0; i < lootNames.length; i++) {
            itemsForSale.add(new Loot(lootNames[i], lootValues[i]));
        }
    }

    public void displayItems() {
        System.out.println("Items available for sale:");
        for (int i = 0; i < itemsForSale.size(); i++) {
            System.out.println((i + 1) + ". " + itemsForSale.get(i));
        }
    }

    public Loot buyItem(int index) {
        if (index >= 0 && index < itemsForSale.size()) {
            return itemsForSale.remove(index);
        } else {
            System.out.println("Invalid item selection.");
            return null;
        }
    }
}