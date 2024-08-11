public class Main {
    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();

        // Adding items to the inventory
        inventorySystem.addItem("apple", 10);
        inventorySystem.addItem("banana", 20);

        // Checking quantities
        System.out.println("Quantity of apples: " + inventorySystem.checkQuantity("apple"));
        System.out.println("Quantity of bananas: " + inventorySystem.checkQuantity("banana"));

        // Removing items
        inventorySystem.removeItem("apple", 5);
        System.out.println("Quantity of apples after removal: " + inventorySystem.checkQuantity("apple"));

        // Attempt to remove more than available
        try {
            inventorySystem.removeItem("banana", 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Checking quantities again
        System.out.println("Quantity of bananas: " + inventorySystem.checkQuantity("banana"));
    }
}

