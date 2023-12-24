/**
 * OfficeFurniture represents a specialized subset of furniture items within the
 * FurnitureStore system.
 * This type of furniture is tailored for use in office environments, be it home
 * offices, corporate settings,
 * or other professional areas. Each OfficeFurniture item might possess
 * attributes like ergonomic design,
 * adjustability features, durability specifications, and more. Examples include
 * office chairs, desks,
 * conference tables, file cabinets, and partitions.
 * 
 * The distinction of OfficeFurniture is crucial as these items prioritize
 * functionality, comfort, and
 * durability for long working hours. They play a pivotal role in ensuring a
 * conducive and productive work environment.
 * Furthermore, this classification helps in streamlining product
 * recommendations for businesses and professionals
 * and enables the store to target specific marketing and sales strategies
 * towards corporate clients or remote workers.
 */

public abstract class OfficeFurniture extends FurnitureBase {
    // Attributes
    private String furnitureCategory; // Category of the office furniture
    private boolean isErgonomic; // Indicates if the furniture is ergonomic
    private String material; // Material used in the office furniture
    private double price; // Price of the office furniture
    // Constructors

    /**
     * Constructs a new OfficeFurniture with default values.
     */
    public OfficeFurniture() {

        this.furnitureCategory = "";

        this.isErgonomic = false;
        this.material = "";
        this.price = 0.0;
    }

    /**
     * Constructs a new OfficeFurniture with the given parameters.
     * 
     * @param category  The category of the office furniture.
     * @param ergonomic Indicates if the furniture is ergonomic.
     * @param material  The material used in the office furniture.
     * @param price     The price of the office furniture.
     */
    public OfficeFurniture(String category, boolean ergonomic, String material, double price) {

        this.furnitureCategory = category;
        this.isErgonomic = ergonomic;
        this.material = material;
        this.price = price;
    }

    // Methods
    /**
     * Gets the category of the office furniture.
     * 
     * @return The category of the office furniture.
     */
    public String getCategory() {
        return furnitureCategory;
    }

    /**
     * Sets the category of the office furniture.
     * 
     * @param category The category to be set.
     */
    public void setCategory(String category) {
        this.furnitureCategory = category;
    }

    /**
     * Checks if the office furniture is ergonomic.
     * 
     * @return True if the furniture is ergonomic, false otherwise.
     */
    public boolean isErgonomicFurniture() {
        return isErgonomic;
    }

    /**
     * Sets whether the office furniture is ergonomic or not.
     * Adjusts the price accordingly.
     * 
     * @param ergonomic True if the furniture is ergonomic, false otherwise.
     */
    public void setErgonomic(boolean ergonomic) {
        this.isErgonomic = ergonomic;
        adjustPrice();
    }

    /**
     * Gets the material used in the office furniture.
     * 
     * @return The material used in the office furniture.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets the material used in the office furniture.
     * Adjusts the price accordingly.
     * 
     * @param material The material to be set.
     */
    public void setMaterial(String material) {
        this.material = material;
        adjustPrice();
    }

    /**
     * Gets the price of the office furniture.
     * 
     * @return The price of the office furniture.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the office furniture.
     * 
     * @param price The price to be set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Adjusts the price of the office furniture based on ergonomic and material
     * attributes.
     */
    public void adjustPrice() {
        if (isErgonomic) {
            price += price * 0.1; // 10% increase for ergonomic furniture
        }

        switch (material.toUpperCase()) {
            case "WOOD":
                price += price * 0.15; // 15% increase for wood furniture
                break;
            case "METAL":
                price += price * 0.05; // 5% increase for metal furniture
                break;
        }
    }

    /**
     * Displays detailed information about the office furniture, including category,
     * ergonomic status, material, and price.
     */
    public void displayDetails() {
        System.out.println("Furniture Category: " + getCategory());
        System.out.println("Ergonomic: " + isErgonomicFurniture());
        System.out.println("Material: " + getMaterial());
        System.out.printf("Price: $%.2f\n", price);
    }
}
