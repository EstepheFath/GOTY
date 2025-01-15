import Room.CombatRoom;
import Character.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CombatRoomTest {

    @Test
    void testEnter() {
        Player player = new Player("Hero", 100, 10, 0, 1);
        CombatRoom combatRoom = new CombatRoom(player);
        assertDoesNotThrow(combatRoom::enter);
    }
}