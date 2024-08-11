import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    private Map<String, Integer> inventory;

    public InventorySystem() {
        this.inventory = new HashMap<>();
    }

    // Add an item to the inventory
    public void addItem(String item, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    // Remove an item from the inventory
    public void removeItem(String item, int quantity) {
        if (!inventory.containsKey(item)) {
            throw new IllegalArgumentException("Item does not exist");
        }
        int currentQuantity = inventory.get(item);
        if (quantity > currentQuantity) {
            throw new IllegalArgumentException("Not enough quantity to remove");
        }
        inventory.put(item, currentQuantity - quantity);
        if (inventory.get(item) == 0) {
            inventory.remove(item);
        }
    }

    // Check the quantity of an item in the inventory
    public int checkQuantity(String item) {
        return inventory.getOrDefault(item, 0);
    }
}
