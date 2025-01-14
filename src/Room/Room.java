package Room;

import java.util.Random;

public abstract class Room {
    public abstract void enter();

    // Méthode statique pour générer une salle aléatoire
    public static Room generateRandomRoom() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new CombatRoom();
        } else {
            return new EventRoom();
        }
    }
}