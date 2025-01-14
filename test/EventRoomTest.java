import Room.EventRoom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventRoomTest {

    @Test
    void testEnter() {
        EventRoom eventRoom = new EventRoom();
        assertDoesNotThrow(eventRoom::enter);
    }
}