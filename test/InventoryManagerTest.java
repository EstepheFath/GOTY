
import Character.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Hero", 100, 10, 0, 1);
    }

    @Test
    void testOpenInventoryDisplaysItems() {
        player.addItemToInventory("Health Potion");
        player.addItemToInventory("Sword");

        Scanner scanner = new Scanner("Q\n"); // Simulate user quitting inventory
        InventoryManager.openInventory(player, scanner);

        assertEquals("Health Potion", player.getInventory()[0]);
        assertEquals("Sword", player.getInventory()[1]);
    }

    @Test
    void testEquipItem() {
        player.addItemToInventory("Sword");

        Scanner scanner = new Scanner("E\n1\nQ\n"); // Simulate equipping item and quitting
        InventoryManager.openInventory(player, scanner);

        assertEquals("Sword", player.getEquippedItem());
    }

    @Test
    void testUnequipItem() {
        player.addItemToInventory("Sword");
        player.equipItem("Sword");

        Scanner scanner = new Scanner("U\nQ\n"); // Simulate unequipping and quitting
        InventoryManager.openInventory(player, scanner);

        assertNull(player.getEquippedItem());
        assertEquals("Sword", player.getInventory()[0]);
    }

    @Test
    void testUseItem() {
        player.addItemToInventory("Health Potion");

        Scanner scanner = new Scanner("C\n1\nQ\n"); // Simulate using item and quitting
        InventoryManager.openInventory(player, scanner);

        assertEquals(120, player.getHealth()); // Assuming the potion adds 20 HP
        assertNull(player.getInventory()[0]);
    }

    @Test
    void testInvalidAction() {
        player.addItemToInventory("Health Potion");

        Scanner scanner = new Scanner("X\nQ\n"); // Simulate invalid action and quitting
        InventoryManager.openInventory(player, scanner);

        assertEquals("Health Potion", player.getInventory()[0]); // No changes expected
    }

    @Test
    void testInvalidEquipIndex() {
        player.addItemToInventory("Sword");

        Scanner scanner = new Scanner("E\n3\nQ\n"); // Simulate invalid equip index and quitting
        InventoryManager.openInventory(player, scanner);

        assertNull(player.getEquippedItem()); // No item equipped
        assertEquals("Sword", player.getInventory()[0]);
    }

    @Test
    void testInvalidUseIndex() {
        player.addItemToInventory("Health Potion");

        Scanner scanner = new Scanner("C\n5\nQ\n"); // Simulate invalid use index and quitting
        InventoryManager.openInventory(player, scanner);

        assertEquals("Health Potion", player.getInventory()[0]); // Item not used
        assertEquals(100, player.getHealth()); // Health unchanged
    }
}