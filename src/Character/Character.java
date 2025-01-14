package Character;

public class Character {
    String name;
    int health;
    int strength;
    int speed;
    int xp;
    int lvl;
    enum status{};
    //Item[] i =[];


    public Character(String name, int health, int strength, int speed, int xp, int lvl) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.xp = xp;
        this.lvl = lvl;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLvl(int lvl) {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
