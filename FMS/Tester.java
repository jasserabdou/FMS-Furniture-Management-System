import java.util.*;

/**
 * The Tester class is responsible for testing the functionality of the
 * Furniture Management System (FMS).
 * It allows users to interact with the system through a command-line interface,
 * adding furniture items, purchasers,
 * and furniture categories, as well as simulating interactions between
 * purchasers, furniture, and furniture categories.
 */

public class Tester {
    private FurnitureStore homeFurnishingsDepot;

    public Tester() {
        homeFurnishingsDepot = new FurnitureStore("Home Furnishings Depot", "Downtown");
    }

    // The doTest() method where you will write code to test your system
    public void doTest() {
        Scanner enter = new Scanner(System.in);

        // Test 1: Add furniture items
        System.out.println("1: Adding furniture items");
        addFurnitureFromUserInput();

        // Test 2: Add a purchaser
        System.out.println("\n2: Adding a purchaser");
        addPurchaserFromUserInput();

        // Test 3: Add a furniture category
        System.out.println("\n3: Adding a furniture category");
        addCategoryFromUserInput();

        // Test 4: Simulate interactions between purchaser, furniture, and furniture
        simulateInteractions(enter);

        enter.close();
    }

    private void simulateInteractions(Scanner input) {
        System.out.println("\nWelcome to the FMS (Furniture Management System)");

        System.out.print("Enter the ID of the purchaser to simulate interactions: ");
        String purchaserId = input.nextLine();
        Purchaser purchaser = homeFurnishingsDepot.getPurchaserByID(purchaserId);

        if (purchaser != null) {

            FurnitureBase furnitureItem = homeFurnishingsDepot.getFurnitureByID(purchaserId);
            FurnitureCategory category = homeFurnishingsDepot.getCategoryByID(purchaserId);

            System.out.println("\nInteraction Details:");

            System.out.println("Purchaser Details:");
            purchaser.displayDetails();

            if (furnitureItem != null) {
                System.out.println("\nFurniture Item Details:");
                furnitureItem.displayDetails();
            } else {
                System.out.println("\nFurniture Item not found.");
            }

            if (category != null) {

                category.setRecentPurchaser(purchaser);

                System.out.println("\nFurniture Category Details:");
                category.displayDetails();
            } else {
                System.out.println("\nFurniture Category not found.");
            }
        } else {
            System.out.println("Purchaser not found.");
        }
    }

    private void addFurnitureFromUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter furniture ID: ");
        String id = input.nextLine();
        System.out.print("Enter furniture material: ");
        String material = input.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        System.out.print("Enter price: ");
        double price = input.nextDouble();

        System.out.print("Enter furniture type (bed, sofa, chair): ");
        String furnitureType = input.next();

        FurnitureBase furnitureItem;

        if ("bed".equalsIgnoreCase(furnitureType)) {
            furnitureItem = new BedroomCollection(id, material, quantity, price);
        } else if ("sofa".equalsIgnoreCase(furnitureType)) {
            furnitureItem = new SofaItem(id, material, quantity, price);
        } else if ("chair".equalsIgnoreCase(furnitureType)) {
            furnitureItem = new ChairItem(id, material, quantity, price);
        } else {
            System.out.println("Invalid furniture type.");
            return;
        }

        homeFurnishingsDepot.addFurniture(furnitureItem);
        System.out.println("Furniture item added successfully.");

        Purchaser purchaser = homeFurnishingsDepot.getPurchaserByPreferredType(furnitureItem.getFurnitureType());
        if (purchaser != null) {
            purchaser.addToPurchaseHistory(furnitureType + " purchased by: " + purchaser.getName());
        }
    }

    private void addPurchaserFromUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter purchaser ID: ");
        String id = input.nextLine();
        System.out.print("Enter purchaser name: ");
        String name = input.nextLine();
        System.out.print("Enter preferred furniture type: ");
        String preferredFurnitureType = input.nextLine();
        System.out.print("Enter contact details: ");
        String contactDetails = input.nextLine();

        Purchaser purchaser = new Purchaser(id, name, preferredFurnitureType);
        purchaser.setContactDetails(contactDetails);
        homeFurnishingsDepot.addPurchaser(purchaser);

        FurnitureBase furnitureItem = homeFurnishingsDepot.getFurnitureByType(preferredFurnitureType);
        if (furnitureItem != null) {
            purchaser.addToPurchaseHistory(furnitureItem.getID() + " purchased by: " + purchaser.getName());
        }

        System.out.println("Purchaser added successfully.");
    }

    private void addCategoryFromUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter category ID: ");
        String id = input.nextLine();
        System.out.print("Enter category name: ");
        String name = input.nextLine();
        System.out.print("Enter Max Load: ");
        double maximumLoad = input.nextDouble();
        System.out.print("Is Is Outdoor ? (true/false): ");
        boolean isOutdoor = input.nextBoolean();

        homeFurnishingsDepot.addCategory(new FurnitureCategory(id, name, maximumLoad, isOutdoor));
        System.out.println("Furniture category added successfully.");
    }

    // Main method to make the class executable
    // No need to change this
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.doTest();
    }
}
