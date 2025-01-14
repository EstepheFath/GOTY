import Room.CombatRoom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CombatRoomTest {

    @Test
    void testEnter() {
        CombatRoom combatRoom = new CombatRoom();
        assertDoesNotThrow(combatRoom::enter);
    }
}