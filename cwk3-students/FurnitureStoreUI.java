import java.util.*;

/**
 * The FurnitureStoreUI class represents the user interface for interacting with
 * the FurnitureStore system.
 * It provides options to add furniture, purchasers, and categories, as well as
 * view details for furniture,
 * purchasers, and categories. The UI is designed to interact with the
 * FurnitureStore class and various
 * FurnitureBase subclasses to manage the store's inventory and customer
 * information.
 * 
 * The UI presents a menu with different options and takes user input to perform
 * the desired actions.
 */
public class FurnitureStoreUI {
    private Scanner reader = new Scanner(System.in);
    private FurnitureStore store = new FurnitureStore("Home FMS", "Downtown");

    /**
     * Runs the main user interface loop, allowing users to interact with the
     * FurnitureStore system.
     */
    public void runUI() {
        int choice = getOption();

        while (choice != 0) {

            switch (choice) {
                case 1:
                    addFurniture();
                    break;
                case 2:
                    addPurchaser();
                    break;
                case 3:
                    addCategory();
                    break;
                case 4:
                    viewFurniture();
                    break;
                case 5:
                    viewPurchaser();
                    break;
                case 6:
                    viewCategory();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            choice = getOption();
        }
        System.out.println("\nThank you for using Fortune Furnitures System.");
        reader.close();
    }

    /**
     * Displays the main menu and retrieves the user's choice.
     * 
     * @return The user's choice as an integer.
     */
    private int getOption() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("0. Quit");
        System.out.println("1. Add furniture");
        System.out.println("2. Add purchaser");
        System.out.println("3. Add category");
        System.out.println("4. View furniture details by ID");
        System.out.println("5. View purchaser details by ID");
        System.out.println("6. View category details by ID");
        System.out.print("Enter your choice: ");

        int option = reader.nextInt();
        reader.nextLine(); // Consume the newline character
        return option;
    }

    /**
     * Adds a new furniture item to the store's inventory based on user input.
     */
    private void addFurniture() {
        try {
            System.out.print("Enter furniture ID: ");
            String id = reader.nextLine();

            System.out.print("Enter furniture category: ");
            String category = reader.nextLine();

            System.out.print("Enter item count: ");
            int itemCount = 0;

            try {
                itemCount = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for item count. Please enter a valid integer.");
                reader.nextLine(); // Consume the invalid input
                return; // Exit the method
            }

            System.out.print("Enter price: ");
            double price = 0.0;

            try {
                price = reader.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for price. Please enter a valid number.");
                reader.nextLine(); // Consume the invalid input
                return; // Exit the method
            }

            FurnitureBase furniture = null;

            // Prompt user to select the type of furniture
            System.out.println("Select furniture type:");
            System.out.println("1. Chair");
            System.out.println("2. Sofa");
            System.out.println("3. Bedroom Collection");
            System.out.println("4. Wardrobe");
            System.out.println("5. Table");

            int furnitureTypeChoice = 0;

            try {
                furnitureTypeChoice = reader.nextInt();
                reader.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for furniture type choice. Please enter a valid integer.");
                reader.nextLine(); // Consume the invalid input
                return; // Exit the method
            }

            switch (furnitureTypeChoice) {
                case 1:
                    furniture = new ChairItem(id, category, itemCount, price);
                    break;
                case 2:
                    furniture = new SofaItem(id, category, itemCount, price);
                    break;
                case 3:
                    furniture = new BedroomCollection(id, category, itemCount, price);
                    break;
                case 4:
                    furniture = new WardrobeItem(id, category, itemCount, price);
                    break;
                case 5:
                    furniture = new TableItem(id, category, itemCount, price);
                    break;
                default:
                    System.out.println("Invalid furniture type choice.");
                    return; // Exit the method if the choice is invalid
            }

            store.addFurniture(furniture);
            System.out.println("Furniture added successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Adds a new purchaser to the store's customer database based on user input.
     */
    private void addPurchaser() {
        System.out.print("Enter purchaser ID: ");
        String id = reader.nextLine();
        System.out.print("Enter purchaser name: ");
        String name = reader.nextLine();
        System.out.print("Enter furniture type: ");
        String furnitureType = reader.nextLine();
        System.out.print("Enter contact details: ");
        String contactDetails = reader.nextLine();

        Purchaser purchaser1 = new Purchaser(id, name, furnitureType, contactDetails, null);
        store.addPurchaser(purchaser1);
        System.out.println("Purchaser added successfully!");
    }

    /**
     * Adds a new furniture category to the store based on user input.
     */
    private void addCategory() {
        System.out.print("Enter ID Number: ");
        String id = reader.nextLine();
        System.out.print("Enter category name: ");
        String typeName = reader.nextLine();
        System.out.print("Enter maximum load: ");
        double maxLoad = reader.nextDouble();
        System.out.print("Is outdoor (true/false): ");
        boolean isOutdoor = reader.nextBoolean();
        reader.nextLine(); // Consume the newline character

        FurnitureCategory category = new FurnitureCategory(id, typeName, maxLoad, isOutdoor, null);
        store.addCategory(category);
        System.out.println("Category added successfully!");
    }

    /**
     * Displays details for a specific furniture item based on user input.
     */
    private void viewFurniture() {
        System.out.print("Enter furniture ID: ");
        String id = reader.nextLine();

        FurnitureBase furniture = store.getFurnitureByID(id);
        if (furniture != null) {
            furniture.displayDetails();
        } else {
            System.out.println("Furniture not found!");
        }
    }

    /**
     * Displays details for a specific purchaser based on user input.
     */
    private void viewPurchaser() {
        System.out.print("Enter purchaser ID: ");
        String id = reader.nextLine();

        Purchaser purchaser = store.getPurchaserByID(id);
        if (purchaser != null) {
            purchaser.displayDetails();
        } else {
            System.out.println("Purchaser not found!");
        }
    }

    /**
     * Displays details for a specific furniture category based on user input.
     */
    private void viewCategory() {
        System.out.print("Enter category ID: ");
        String id = reader.nextLine();

        FurnitureCategory category = store.getCategoryByID(id);
        if (category != null) {
            category.displayDetails();
        } else {
            System.out.println("Category not found!");
        }
    }

    /**
     * The main method to run the FurnitureStoreUI.
     * 
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        FurnitureStoreUI ui = new FurnitureStoreUI();
        ui.runUI();
    }
}
