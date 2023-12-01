import java.util.*;

public class Tester {
        // The doTest() method where you will write code to test your system
        public void doTest() {
                FurnitureStore homeFurnishingsDepot = new FurnitureStore("Home Furnishings Depot",
                                "123 Furniture Street");
                Scanner enter = new Scanner(System.in);

                // Test 1: Add furniture items
                System.out.println("Test 1: Adding furniture items");
                homeFurnishingsDepot.addFurniture(new SofaItem("1", "Leather", 2, 500.0));
                homeFurnishingsDepot.addFurniture(new ChairItem("2", "Wood", 4, 150.0));
                homeFurnishingsDepot.addFurniture(new BedroomCollection("3", "Queen", 1, 800.0));
                System.out.println("Furniture items added successfully.");

                // Test 2: Add a purchaser
                System.out.println("\nTest 2: Adding a purchaser");
                homeFurnishingsDepot.addPurchaser(new Purchaser("4", "John Doe", "Sofa"));
                System.out.println("Purchaser added successfully.");

                // Test 3: Add a furniture category
                System.out.println("\nTest 3: Adding a furniture category");
                homeFurnishingsDepot.addCategory(new FurnitureCategory("3", "Sofa", 200.0, false));
                System.out.println("Furniture category added successfully.");

                // Test 4: View details of a furniture item
                System.out.println("\nTest 4: Viewing details of a furniture item");
                System.out.print("Enter the ID of the furniture item: ");
                String furnitureItemId = enter.nextLine();
                FurnitureBase furnitureItem = homeFurnishingsDepot.getFurnitureByID(furnitureItemId);
                if (furnitureItem != null) {
                        furnitureItem.displayDetails();
                } else {
                        System.out.println("Furniture item not found.");
                }

                // Test 5: View details of a purchaser
                System.out.println("\nTest 5: Viewing details of a purchaser");
                System.out.print("Enter the ID of the purchaser: ");
                String purchaserId = enter.nextLine();
                Purchaser purchaser = homeFurnishingsDepot.getPurchaserByID(purchaserId);
                if (purchaser != null) {

                        System.out.println("Purchaser found!");
                } else {
                        System.out.println("Purchaser not found.");
                }

                // Test 6: View details of a furniture category
                System.out.println("\nTest 6: Viewing details of a furniture category");
                System.out.print("Enter the ID of the furniture category: ");
                String categoryId = enter.nextLine();
                FurnitureCategory category = homeFurnishingsDepot.getCategoryByID(categoryId);
                if (category != null) {

                        System.out.println("Furniture category found!");
                } else {
                        System.out.println("Furniture category not found.");
                }

                // Additional tests can be added as needed

                enter.close(); // Close the scanner to prevent resource leak
        }

        // Main method to make the class executable
        // No need to change this
        public static void main(String[] args) {
                Tester tester = new Tester();
                tester.doTest();
        }
}
