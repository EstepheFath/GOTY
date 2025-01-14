package Room;

import java.util.Random;

public class EventRoom extends Room {
    @Override
    public void enter() {
        System.out.println("You are in an event room...");
        Random random = new Random();
        int eventType = random.nextInt(4); // 0: nothing, 1: treasure chest, 2: shop, 3: trap

        switch (eventType) {
            case 0 -> System.out.println("Ptite Clime il fait bien froid ici");
            case 1 -> System.out.println("Coffre au centre de la pièce");
            case 2 -> System.out.println("Un marchand chelou vous propose des objets");
            case 3 -> System.out.println("Dommage vous êtes tombé dans un piège");
        }
    }
}