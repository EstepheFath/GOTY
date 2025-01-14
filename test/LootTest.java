import Room.Loot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LootTest {

    @Test
    void testLootCreation() {
        Loot loot = new Loot("Sword", 100);
        assertEquals("Sword", loot.getName());
        assertEquals(100, loot.getValue());
    }

    @Test
    void testLootToString() {
        Loot loot = new Loot("Shield", 150);
        assertEquals("Shield (Value: 150)", loot.toString());
    }
}