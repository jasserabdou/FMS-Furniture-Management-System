/**
 * OfficeFurnitureTester is a class for testing the functionality of the
 * MyOfficeFurnitureItems class.
 * It creates an instance of MyOfficeFurnitureItems, performs adjustments, and
 * displays the details.
 */
public class OfficeFurnitureTester {

    public static void main(String[] args) {
        // Create an instance of MyOfficeFurnitureItems
        MyOfficeFurnitureItems officeFurniture = new MyOfficeFurnitureItems("001", "Chair", true, "metal", 1, 30.2);

        // Display details before adjustment
        System.out.println("**Before Adjustment**");
        officeFurniture.displayDetails();

        // Adjust price and display details again
        System.out.println("\n**After Adjustment**");
        officeFurniture.adjustPrice();
        officeFurniture.displayDetails();
    }
}
