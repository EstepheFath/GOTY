import Room.Room;
import Room.EventRoom;
import Room.CombatRoom;
import Character.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testGenerateRandomRoom() {
        Player player = new Player("Hero", 100, 10, 0, 1);
        Room room = Room.generateRandomRoom(player);
        assertNotNull(room);
        assertTrue(room instanceof CombatRoom || room instanceof EventRoom);
    }
}