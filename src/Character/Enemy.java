package Character;

public class Enemy extends CharacterGame {
    private int spawnNumber;
    private int XPdrop;
    private int POdrop;

    public Enemy(String name, int health, int strength, int spawnNumber, int XPdrop, int POdrop) {
        super(name, health, strength);
        if (spawnNumber < 0 || XPdrop < 0 || POdrop < 0) {
            throw new IllegalArgumentException("Les valeurs spawnNumber, XPdrop et POdrop doivent être positives.");
        }
        this.spawnNumber = spawnNumber;
        this.XPdrop = XPdrop;
        this.POdrop = POdrop;
    }

    public int getSpawnNumber() {
        return spawnNumber;
    }

    public void setSpawnNumber(int spawnNumber) {
        if (spawnNumber < 0) {
            throw new IllegalArgumentException("Le nombre d'apparitions doit être positif.");
        }
        this.spawnNumber = spawnNumber;
    }

    public int getXPdrop() {
        return XPdrop;
    }

    public void setXPdrop(int XPdrop) {
        if (XPdrop < 0) {
            throw new IllegalArgumentException("Les points XP drop doivent être positifs.");
        }
        this.XPdrop = XPdrop;
    }

    public int getPOdrop() {
        return POdrop;
    }

    public void setPOdrop(int POdrop) {
        if (POdrop < 0) {
            throw new IllegalArgumentException("La valeur de PO drop doit être positive.");
        }
        this.POdrop = POdrop;
    }

    @Override
    public String getDetails() {
        return "Enemy: " + name + " (Health: " + health + ", Strength: " + strength + ", Spawn Number: " + spawnNumber + ", XP Drop: " + XPdrop + ", PO Drop: " + POdrop + ")";
    }
}