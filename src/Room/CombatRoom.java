package Room;

public class CombatRoom extends Room {
    @Override
    public void enter() {
        System.out.println("Tu est dans une salle de combat force à toi !");
        // Add combat logic here
    }
}