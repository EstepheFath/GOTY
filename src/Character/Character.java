package Character;

public abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected String[] inventory;

    private static final int INVENTORY_SIZE = 10;

    public Character(String name, int health, int strength) {
        if (health <= 0 || strength < 0) {
            throw new IllegalArgumentException("La santé doit être supérieure à 0 et la force doit être positive.");
        }
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.inventory = new String[INVENTORY_SIZE];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}