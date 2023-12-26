
/**
 * The FurnitureBaseTester class is responsible for validating and demonstrating
 * the functionality of the FurnitureBase class and its subclasses.
 * It creates different FurnitureBase objects, calls their methods to ensure
 * that the core furniture functionality is intact, and displays the results.
 */

public class FurnitureBaseTester {
    public static void main(String[] args) {
        // Create FurnitureBase Items
        FurnitureBase Sofa = new SofaItem("1", "Leather Sofa", 2, 800);
        FurnitureBase Bed = new BedroomCollection("2", "King Size Bed", 1, 1200);
        FurnitureBase Chair = new ChairItem("3", "Wooden Chair", 5, 100);
        FurnitureBase Table = new TableItem("4", "Dining Table", 3, 300);
        FurnitureBase Wardrobe = new WardrobeItem("5", "3-door Wooden Wardrobe", 4, 900);

        // Display details of individual furniture items
        Sofa.displayDetails();
        System.out.println("-----------------------------");
        Bed.displayDetails();
        System.out.println("-----------------------------");
        Chair.displayDetails();
        System.out.println("-----------------------------");
        Table.displayDetails();
        System.out.println("-----------------------------");
        Wardrobe.displayDetails();

    }
}
