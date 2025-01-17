package Room;

public class Loot {
    private String name;
    private int value;
    private int lootDamage;

    public Loot(String name, int value, int lootDamage) {
        this.name = name;
        this.value = value;
        this.lootDamage = lootDamage;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getLootDamage() {
        return lootDamage;
    }

    @Override
    public String toString() {
        return name + " (Value: " + value + ")";
    }
}