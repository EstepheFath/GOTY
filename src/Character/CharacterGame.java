package Character;

import Room.Loot;

import java.util.ArrayList;
import java.util.List;

public abstract class CharacterGame {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int strength;
    protected String[] inventory;

    private static final int INVENTORY_SIZE = 10;

    public CharacterGame(String name, int health, int maxHealth, int strength) {
        if (health <= 0 || strength < 0) {
            throw new IllegalArgumentException("La santé doit être supérieure à 0 et la force doit être positive.");
        }
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.inventory = new String[INVENTORY_SIZE];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("La santé ne peut pas être négative.");
        }
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException("La force ne peut pas être négative.");
        }
        this.strength = strength;
    }

    public String[] getInventory() {
        return inventory;
    }

    public boolean addItemToInventory(String item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return true;
            }
        }
        return false;
    }

    public boolean removeItemFromInventory(String item) {
        for (int i = 0; i < inventory.length; i++) {
            if (item.equals(inventory[i])) {
                inventory[i] = null;
                return true;
            }
        }
        return false;
    }

    public abstract String getDetails();

    public void attack(CharacterGame target) {
        if (this.strength > 0 && target.getHealth() > 0) {
            int totalDamage = this.strength;

            if (this instanceof Player) {
                Player player = (Player) this;

                // Liste globale des objets Loot possibles
                Loot[] allAvailableLoot = {
                        new Loot("Epée rouillée", 5, 10),
                        new Loot("Arc", 10, 15),
                        new Loot("Glock", 50, 40),
                        new Loot("Potion de vie", 5, 0),
                        new Loot("Potion d'xp", 10, 0)
                };

                // Mapper les objets de l’inventaire (facultatif selon vos besoins)
                Loot[] mappedInventory = player.mapInventoryNamesToLoot(allAvailableLoot);

                // Ajouter les dégâts de l'arme équipée
                totalDamage += player.getEquippedItemDamageFromInventory(mappedInventory);
            }

            // Réduire la santé de la cible
            target.setHealth(Math.max(0, target.getHealth() - totalDamage));
            System.out.println(this.name + " inflige " + totalDamage + " dégâts à " + target.getName());
        }
    }

    public void increaseMaxHealth(int additionalHealth) {
        if (additionalHealth > 0) {
            this.maxHealth += additionalHealth;
            // Ajouter la vie supplémentaire au joueur
            this.health = Math.min(this.maxHealth, this.health + additionalHealth);
            System.out.println("Votre vie maximale a augmenté de " + additionalHealth + " !");
        } else {
            throw new IllegalArgumentException("La valeur supplémentaire doit être positive.");
        }
    }
}

