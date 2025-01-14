import Room.Room;
import Room.EventRoom;
import Room.CombatRoom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testGenerateRandomRoom() {
        Room room = Room.generateRandomRoom();
        assertNotNull(room);
        assertTrue(room instanceof CombatRoom || room instanceof EventRoom);
    }
}