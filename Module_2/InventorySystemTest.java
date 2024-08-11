import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventorySystemTest {
    private InventorySystem inventorySystem;

    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
    }

    @Test
    public void testAddItem() {
        inventorySystem.addItem("apple", 10);
        assertEquals(10, inventorySystem.checkQuantity("apple"));

        inventorySystem.addItem("apple", 5);
        assertEquals(15, inventorySystem.checkQuantity("apple"));
    }

    @Test
    public void testRemoveItem() {
        inventorySystem.addItem("apple", 10);
        inventorySystem.removeItem("apple", 5);
        assertEquals(5, inventorySystem.checkQuantity("apple"));

        inventorySystem.removeItem("apple", 5);
        assertEquals(0, inventorySystem.checkQuantity("apple"));

        // Test removing more than available
        assertThrows(IllegalArgumentException.class, () -> {
            inventorySystem.removeItem("apple", 1);
        });
    }

    @Test
    public void testCheckQuantity() {
        assertEquals(0, inventorySystem.checkQuantity("banana"));

        inventorySystem.addItem("banana", 10);
        assertEquals(10, inventorySystem.checkQuantity("banana"));
    }

    @Test
    public void testAddItemNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventorySystem.addItem("apple", -5);
        });
    }

    @Test
    public void testRemoveItemNotExist() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventorySystem.removeItem("banana", 1);
        });
    }
}

