public class OfficeFurnitureTester {

    public static void main(String[] args) {
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