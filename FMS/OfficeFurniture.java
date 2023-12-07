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

    // attributes
    private boolean isErgonomic;
    private String material;
    private double price;

    // Constructors
    public OfficeFurniture() {
        super();
        this.isErgonomic = false;
        this.material = "Undefined";
        this.price = 0.0;
    }

    public OfficeFurniture(String id, String furnitureCategory, boolean isErgonomic, String material, int itemCount,
            double price) {
        super(id, furnitureCategory, itemCount, price);
        this.isErgonomic = isErgonomic;
        this.material = material;
        adjustPrice();
    }

    // methods
    public String getCategory() {
        return getFurnitureCategory();
    }

    public boolean isErgonomicFurniture() {
        return isErgonomic;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    // Method to dynamically adjust the price based on specific attributes
    public void adjustPrice() {

        if (isErgonomic) {
            price += price * 0.10; // 10% increase for ergonomic design
        }

        // Material-Based Adjustment
        switch (material.toLowerCase()) {
            case "wood":
                price += price * 0.15; // 15% increase for wooden furniture
                break;
            case "metal":
                price += price * 0.05; // 5% increase for metal furniture
                break;

        }
    }
}
