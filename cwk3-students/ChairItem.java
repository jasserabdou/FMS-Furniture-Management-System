/**
 * ChairItem represents a type of furniture item within the FurnitureStore
 * system.
 * It extends the FurnitureBase class and adds specific attributes and behaviors
 * for chairs.
 */

class ChairItem extends FurnitureBase {
    // Attributes
    private String chairMaterial;

    // Constructors
    public ChairItem() {
        super();
        this.setFurnitureCategory("Chair");
        this.chairMaterial = "Undefined";
    }

    public ChairItem(String id, String chairMaterial, int itemCount, double price) {
        super(id, "Chair", itemCount, price);
        this.chairMaterial = chairMaterial;
    }

    // Methods
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.12;
    }

    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Chair purchased by: " + buyer);
    }

    @Override
    public String getFurnitureType() {
        return "Chair";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Chair Material: " + chairMaterial);
        System.out.println("Discount: $" + calculateDiscount());
    }
}
