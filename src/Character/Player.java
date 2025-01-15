package Character;

public class Player extends CharacterGame {
    private int xp;
    private int lvl;
    private String equippedItem;

    public Player(String name, int health, int strength, int xp, int lvl) {
        super(name, health, strength);
        if (xp < 0 || lvl < 1) {
            throw new IllegalArgumentException("L'expérience doit être positive et le niveau doit être supérieur ou égal à 1.");
        }
        this.xp = xp;
        this.lvl = lvl;
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

    public String getEquippedItem() {
        return equippedItem;
    }

    public void equipItem(String item) {
        if (removeItemFromInventory(item)) {
            this.equippedItem = item;
            System.out.println(item + " a été équipé.");
        } else {
            System.out.println("L'objet " + item + " n'est pas dans l'inventaire.");
        }
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
            }
        } else {
            System.out.println("L'objet " + item + " n'est pas dans l'inventaire.");
        }
    }

    @Override
    public String getDetails() {
        return "Player: " + name + " (Health: " + health + ", Strength: " + strength + ", XP: " + xp + ", Level: " + lvl + ", Equipped Item: " + (equippedItem != null ? equippedItem : "None") + ")";
    }
}