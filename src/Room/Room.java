package Room;

import java.util.Random;

public abstract class Room {
    public abstract void enter();

    private static int roomCount = 0;
    // Méthode statique pour générer une salle aléatoire
    public static Room generateRandomRoom() {
        Random random = new Random();
        roomCount++;
        System.out.println("Salle numéro: " + roomCount);
        if (roomCount==10){
            System.out.println("Vous avez gagné");
            System.exit(0);
        }
        if (random.nextBoolean()) {
            return new CombatRoom();
        } else {
            return new EventRoom();
        }
    }
}