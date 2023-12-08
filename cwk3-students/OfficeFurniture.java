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

    private String furnitureCategory;
    private boolean isErgonomic;
    private String material;
    private double price;

    public OfficeFurniture() {
        super();
        this.furnitureCategory = "";
        this.isErgonomic = false;
        this.material = "";
        this.price = 0.0;
    }

    public OfficeFurniture(String category, boolean ergonomic, String material, double price) {
        super();
        this.furnitureCategory = category;
        this.isErgonomic = ergonomic;
        this.material = material;
        this.price = price;

    }

    public String getCategory() {
        return furnitureCategory;
    }

    public void setCategory(String category) {
        this.furnitureCategory = category;
    }

    public boolean isErgonomicFurniture() {
        return isErgonomic;
    }

    public void setErgonomic(boolean ergonomic) {
        this.isErgonomic = ergonomic;
        adjustPrice();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
        adjustPrice();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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

    public void displayDetails() {
        System.out.println("Furniture Category: " + getCategory());
        System.out.println("Ergonomic: " + isErgonomicFurniture());
        System.out.println("Material: " + getMaterial());
        System.out.printf("Price: $%.2f\n", price);
        ;
    }
}
