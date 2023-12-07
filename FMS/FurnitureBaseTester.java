
import java.util.*;

/**
 * The FurnitureBaseTester class is responsible for validating and demonstrating
 * the functionality of the FurnitureBase class and its subclasses.
 * It creates different FurnitureBase objects, calls their methods to ensure
 * that the core furniture functionality is intact, and displays the results.
 */

public class FurnitureBaseTester {
    public static void main(String[] args) {
        // Test the FurnitureBase class
        FurnitureBase sofa = new SofaItem("1", "Leather", 2, 500.0);
        FurnitureBase bed = new BedroomCollection("2", "King Size", 1, 1200.0);
        FurnitureBase chair = new ChairItem("3", "Wooden", 4, 200.0);

        // Display details of individual furniture items
        sofa.displayDetails();
        System.out.println("-----------------------------");
        bed.displayDetails();
        System.out.println("-----------------------------");
        chair.displayDetails();

        // Display details of all furniture items
        System.out.println("\nAll Furniture Details:");
        FurnitureBase.showAllFurnitureDetails();
    }
}
