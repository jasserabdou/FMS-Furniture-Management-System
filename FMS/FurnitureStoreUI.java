import java.util.*;

/**
 * Write a description of class FurnitureStoreUI here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */

public class FurnitureStoreUI {
    private Scanner reader = new Scanner(System.in);
    private FURNITUREInterface store = new FurnitureStore("Fortune Furnitures", "Downtown");

    public void runUI() {

        int choice = getOption();

        // process choice
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

            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank you for using Fortune Furnitures System.");
    }

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

        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }

    private void addFurniture() {
        System.out.print("Enter furniture ID: ");
        String id = reader.nextLine();
        System.out.print("Enter furniture category: ");
        String category = reader.nextLine();
        System.out.print("Enter item count: ");
        int itemCount = reader.nextInt();
        System.out.print("Enter price: ");
        double price = reader.nextDouble();

        FurnitureBase furniture1 = new ChairItem(id, category, itemCount, price);
        FurnitureBase furniture2 = new SofaItem(id, category, itemCount, price);
        FurnitureBase furniture3 = new BedroomCollection(id, category, itemCount, price);
        store.addFurniture(furniture1);
        store.addFurniture(furniture2);
        store.addFurniture(furniture3);
        System.out.println("Furniture added successfully!");
        ;

    }

    private void addPurchaser() {

        System.out.print("Enter purchaser ID: ");
        String id = reader.nextLine();
        System.out.print("Enter purchaser name: ");
        String name = reader.nextLine();
        System.out.print("Enter furniture type: ");
        String furnitureType = reader.nextLine();

        Purchaser purchaser1 = new Purchaser(id, name, furnitureType);
        store.addPurchaser(purchaser1);
        System.out.println("Purchaser added successfully!");

    }

    private void addCategory() {
        System.out.print("Enter ID Number: ");
        String id = reader.nextLine();
        System.out.print("Enter category name: ");
        String typeName = reader.nextLine();
        System.out.print("Enter maximum load: ");
        double maxLoad = reader.nextDouble();
        System.out.print("Is outdoor (true/false): ");
        boolean isOutdoor = reader.nextBoolean();
        while (true) {
            String input = reader.next().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                isOutdoor = Boolean.parseBoolean(input);
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }

        FurnitureCategory category = new FurnitureCategory(id, typeName, maxLoad, isOutdoor);
        store.addCategory(category);
        System.out.println("Category added successfully!");

    }

    private void viewFurniture() {
        System.out.print("Enter furniture ID: ");
        String id = reader.nextLine();
        reader.nextLine();

        FurnitureBase furniture = store.getFurnitureByID(id);
        if (furniture != null) {
            furniture.displayDetails();
        } else {
            System.out.println("Furniture not found!");
        }

    }

    private void viewPurchaser() {
        System.out.print("Enter purchaser ID: ");
        String id = reader.nextLine();
        reader.nextLine();

        Purchaser purchaser = store.getPurchaserByID(id);
        if (purchaser != null) {

            System.out.println("Purchaser found!");
        } else {
            System.out.println("Purchaser not found!");
        }

    }

    private void viewCategory() {
        System.out.print("Enter category ID: ");
        String id = reader.nextLine();
        reader.nextLine();

        FurnitureCategory category = store.getCategoryByID(id);
        if (category != null) {

            System.out.println("Category found!");
        } else {
            System.out.println("Category not found!");
        }
       System.out.println();

    }

    public static void main(String[] args) {
        FurnitureStoreUI ui = new FurnitureStoreUI();
        ui.runUI();
    }
}
