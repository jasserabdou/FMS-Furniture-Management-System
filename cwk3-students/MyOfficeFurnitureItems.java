/**
 * MyOfficeFurnitureItems is a specific implementation of the OfficeFurniture
 * class.
 * It represents personalized office furniture items within the FurnitureStore
 * system.
 * MyOfficeFurnitureItems inherits attributes and methods from the
 * OfficeFurniture class.
 */
public class MyOfficeFurnitureItems extends OfficeFurniture {
    // Attributes
    private String id;
    private int itemCount;
    private double price;

    // Constructors
    /**
     * Default constructor for MyOfficeFurnitureItems.
     * Initializes attributes to default values.
     */
    public MyOfficeFurnitureItems() {
        super(); // Call the constructor of the superclass (OfficeFurniture)
        this.id = "";
        this.itemCount = 0;
        this.price = 0.0;
    }

    /**
     * Parameterized constructor for MyOfficeFurnitureItems.
     * Initializes attributes with provided values.
     * 
     * @param id                The ID of the office furniture item.
     * @param furnitureCategory The category of the office furniture item.
     * @param isErgonomic       Whether the furniture is ergonomic.
     * @param material          The material used in the furniture item.
     * @param itemCount         The number of items in the furniture item.
     * @param price             The price of the furniture item.
     */
    public MyOfficeFurnitureItems(String id, String furnitureCategory, boolean isErgonomic, String material,
            int itemCount, double price) {
        super(furnitureCategory, isErgonomic, material, price); // Call the constructor of the superclass
                                                                // (OfficeFurniture)
        this.id = id;
        this.itemCount = itemCount;
        this.price = price;
    }

    // Methods
    /**
     * Gets the ID of the office furniture item.
     * 
     * @return The ID of the office furniture item.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the office furniture item.
     * 
     * @param id The ID to set for the office furniture item.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the item count of the office furniture item.
     * 
     * @return The item count of the office furniture item.
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Sets the item count of the office furniture item.
     * 
     * @param itemCount The item count to set for the office furniture item.
     */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * Adjusts the price of the office furniture item based on item count.
     * Overrides the adjustPrice method from the OfficeFurniture class.
     */
    @Override
    public void adjustPrice() {
        super.adjustPrice(); // Call the adjustPrice method of the superclass (OfficeFurniture)
        if (getItemCount() > 5) {
            price -= price * 0.1; // 10% discount for office furniture items with more than 5 items
        }
    }

    /**
     * Calculates the discount for the office furniture item.
     * Overrides the calculateDiscount method from the OfficeFurniture class.
     * 
     * @return The discount amount for the office furniture item.
     */
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount for MyOfficeFurnitureItems
    }

    /**
     * Associates a purchaser with the purchase of the office furniture item.
     * Overrides the associatePurchaser method from the OfficeFurniture class.
     * 
     * @param buyer The name of the purchaser.
     */
    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Office Furniture (ID: " + id + ") purchased by: " + buyer);
    }

    /**
     * Gets the type of furniture, which is "Office Furniture" for
     * MyOfficeFurnitureItems.
     * Overrides the getFurnitureType method from the OfficeFurniture class.
     * 
     * @return The type of furniture.
     */
    @Override
    public String getFurnitureType() {
        return "Office Furniture";
    }

    /**
     * Displays the details of the MyOfficeFurnitureItems.
     * Overrides the displayDetails method from the OfficeFurniture class.
     * Calls the displayDetails method of the superclass (OfficeFurniture) to
     * include
     * the common details.
     */
    @Override
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Item Count: " + itemCount);
        super.displayDetails(); // Call the displayDetails method of the superclass (OfficeFurniture)
    }
}
