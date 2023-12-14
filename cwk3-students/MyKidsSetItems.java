/**
 * MyKidsSetItems is a specific implementation of the KidsSet class.
 * It represents personalized kids' furniture items within the FurnitureStore
 * system.
 * MyKidsSetItems inherits attributes and methods from the KidsSet class.
 */
public class MyKidsSetItems extends KidsSet {

    /**
     * Default constructor for MyKidsSetItems.
     * Initializes attributes to default values.
     */
    public MyKidsSetItems() {
        super(); // Call the constructor of the superclass (KidsSet)
    }

    /**
     * Parameterized constructor for MyKidsSetItems.
     * Initializes attributes with provided values.
     * 
     * @param id                The ID of the kids' furniture set.
     * @param furnitureCategory The category of the furniture set.
     * @param itemCount         The number of items in the furniture set.
     * @param price             The price of the furniture set.
     * @param kidsId            The ID specific to kids' furniture.
     * @param furName           The name of the kids' furniture.
     */
    public MyKidsSetItems(String id, String furnitureCategory, int itemCount, double price, String kidsId,
            String furName) {
        super(id, furnitureCategory, itemCount, price, kidsId, furName);
    }

    /**
     * Calculates the discount for the MyKidsSetItems.
     * Overrides the calculateDiscount method from the KidsSet class.
     * 
     * @return The discount amount for the kids' furniture set.
     */
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount for MyKidsSetItems
    }

    /**
     * Associates a purchaser with the purchase of the MyKidsSetItems.
     * Overrides the associatePurchaser method from the KidsSet class.
     * 
     * @param buyer The name of the purchaser.
     */
    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Kids Set purchased by: " + buyer);
    }

    /**
     * Gets the type of furniture, which is "Kids Set" for MyKidsSetItems.
     * Overrides the getFurnitureType method from the KidsSet class.
     * 
     * @return The type of furniture.
     */
    @Override
    public String getFurnitureType() {
        return "Kids Set";
    }

    /**
     * Displays the details of the MyKidsSetItems.
     * Overrides the displayDetails method from the KidsSet class.
     * Calls the displayDetails method of the superclass (KidsSet) to include
     * the common details.
     */
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the displayDetails method of the superclass (KidsSet)
    }
}
