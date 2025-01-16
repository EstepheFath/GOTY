package Room;


import java.util.Random;
import Character.Player;

public abstract class Room {
    private String description;

    public Room(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void enter();

    private static int roomCount = 0;

    // Méthode statique pour générer une salle aléatoire
    public static Room generateRandomRoom(Player player) {
        Random random = new Random();
        roomCount++;
        System.out.println("Salle numéro: " + roomCount);
        if (roomCount == 10) {
            System.out.println("Vous avez gagné");
            System.exit(0);
        }
        if (random.nextBoolean()) {
            return new CombatRoom(player);
        } else {
            return new EventRoom(player);
        }
    }
}