package Character;

import Room.Loot;

public class Player extends CharacterGame {
    private int xp;
    private int lvl;
    private String equippedItem;
    private int gold;

    public Player(String name, int health, int strength, int xp, int lvl, int gold) {
        super(name, health, strength);
        if (xp < 0 || lvl < 1 || gold < 0) {
            throw new IllegalArgumentException("L'expérience, le niveau et l'or doivent être positifs.");
        }
        this.xp = xp;
        this.lvl = lvl;
        this.gold = gold; // Initialize gold
        this.equippedItem = null;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        if (xp < 0) {
            throw new IllegalArgumentException("L'expérience ne peut pas être négative.");
        }
        this.xp = xp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        if (lvl < 1) {
            throw new IllegalArgumentException("Le niveau doit être supérieur ou égal à 1.");
        }
        this.lvl = lvl;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("L'or ne peut pas être négatif.");
        }
        this.gold = gold;
    }

    public void addGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Le montant ajouté ne peut pas être négatif.");
        }
        this.gold += amount;
    }

    public void subtractGold(int amount) {
        if (amount < 0 || amount > this.gold) {
            throw new IllegalArgumentException("Le montant soustrait est invalide.");
        }
        this.gold -= amount;
    }

    public void addXp(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Le montant ajouté ne peut pas être négatif.");
        }

        this.xp += amount;

        // Vérifie si le joueur doit gagner un niveau
        while (this.xp >= 100) { // Niveau atteint, ajustons XP et niveau
            this.xp -= 100; // Réduction du surplus d'XP (reste après level-up)
            this.lvl += 1; // Augmente le niveau du joueur
            System.out.println("Félicitations ! Vous avez atteint le niveau " + this.lvl + " !");
        }

        System.out.println("XP actuel: " + this.xp + ". Niveau: " + this.lvl);
    }

    public String getEquippedItem() {
        return equippedItem;
    }

    public void equipItem(String item) {
        for (String inventoryItem : inventory) {
            if (item != null && item.equals(inventoryItem)) {
                this.equippedItem = item; // Attribue directement l'objet équipé
                System.out.println(item + " a été équipé.");
                return;
            }
        }
        System.out.println("L'objet " + item + " n'est pas dans l'inventaire.");
    }

    public void unequipItem() {
        if (this.equippedItem != null) {
            addItemToInventory(this.equippedItem);
            System.out.println(this.equippedItem + " a été déséquipé.");
            this.equippedItem = null;
        } else {
            System.out.println("Aucun objet n'est équipé.");
        }
    }

    public void useItem(String item) {
        if (removeItemFromInventory(item)) {
            switch (item) {
                case "Potion de soin":
                    setHealth(getHealth() + 20);
                    System.out.println("Vous avez utilisé une Potion de soin. Santé actuelle: " + getHealth());
                    break;
                case "Potion d'XP":
                    setXp(getXp() + 10);
                    System.out.println("Vous avez utilisé une Potion d'XP. XP actuel: " + getXp());
                    break;
                default:
                    System.out.println("L'objet " + item + " ne peut pas être utilisé.");
                    addItemToInventory(item); // Re-add the item to the inventory if it cannot be used
            }
        } else {
            System.out.println("L'objet " + item + " n'est pas dans l'inventaire.");
        }
    }

    @Override
    public String getDetails() {
        return "Player: " + name + " (Health: " + health + ", Strength: " + strength + ", XP: " + xp + ", Level: " + lvl + ", Gold: " + gold + ", Equipped Item: " + (equippedItem != null ? equippedItem : "None") + ")";
    }

    public int getEquippedItemDamageFromInventory(Loot[] inventoryLoot) {
        if (this.equippedItem == null) {
            System.out.println("Aucun objet équipé.");
            return 0; // Pas de dégâts supplémentaires si aucun objet n'est équipé
        }

        for (Loot loot : inventoryLoot) {
            if (loot != null && loot.getName().equals(this.equippedItem)) {
                System.out.println("Objet équipé trouvé : " + loot.getName() + " avec " + loot.getLootDamage() + " dégâts.");
                return loot.getLootDamage(); // Retourne les dégâts
            }
        }

        System.out.println("L'objet équipé (" + this.equippedItem + ") n'est pas associé à un loot.");
        return 0; // Aucun bonus si l'objet n'est pas trouvé
    }

    public Loot[] getInventoryItemsMappedToLoot(Loot[] availableLoot) {
        Loot[] inventoryLoot = new Loot[this.inventory.length];

        for (int i = 0; i < this.inventory.length; i++) {
            if (this.inventory[i] != null) {
                for (Loot loot : availableLoot) {
                    if (loot.getName().equals(this.inventory[i])) {
                        inventoryLoot[i] = loot; // Associe l'élément d'inventaire au Loot
                        break;
                    }
                }
            }
        }
        return inventoryLoot;
    }

    public Loot[] mapInventoryNamesToLoot(Loot[] allAvailableLoot) {
        Loot[] inventoryLoot = new Loot[this.inventory.length]; // Créer une liste pour stocker les objets Loot de l'inventaire

        for (int i = 0; i < this.inventory.length; i++) {
            if (this.inventory[i] != null) { // Si un objet est dans l'inventaire
                for (Loot loot : allAvailableLoot) { // Parcourir tous les objets possibles (`Loot`)
                    if (loot != null && loot.getName().equals(this.inventory[i])) {
                        inventoryLoot[i] = loot; // Associer l'objet par nom
                        break;
                    }
                }
            }
        }
        return inventoryLoot; // Retourne les objets Loot correspondant à l'inventaire
    }
}