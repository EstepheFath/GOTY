import Room.Loot;
import Room.Shop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void testDisplayItems() {
        Shop shop = new Shop();
        assertDoesNotThrow(shop::displayItems);
    }

    @Test
    void testBuyItemValid() {
        Shop shop = new Shop();
        Loot loot = shop.buyItem(0);
        assertNotNull(loot);
        assertEquals("Rusted Sword", loot.getName());
    }

    @Test
    void testBuyItemInvalid() {
        Shop shop = new Shop();
        Loot loot = shop.buyItem(-1);
        assertNull(loot);
    }
}