package Character;

public class Player extends CharacterGame {
    private int xp;
    private int lvl;

    public Player(String name, int health, int strength, int xp, int lvl) {
        super(name, health, strength);
        if (xp < 0 || lvl < 1) {
            throw new IllegalArgumentException("L'expérience doit être positive et le niveau doit être supérieur ou égal à 1.");
        }
        this.xp = xp;
        this.lvl = lvl;
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

    @Override
    public String getDetails() {
        return "Player: " + name + " (Health: " + health + ", Strength: " + strength + ", XP: " + xp + ", Level: " + lvl + ")";
    }
}