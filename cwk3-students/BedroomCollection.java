/**
 * BedroomCollection represents a type of furniture item within the
 * FurnitureStore system,
 * specifically tailored for bedrooms. It extends the FurnitureBase class and
 * adds attributes
 * and behaviors related to beds.
 */
public class BedroomCollection extends FurnitureBase {
    // Attributes
    private String bedSize;

    // Constructor
    public BedroomCollection() {
        super();
        this.setFurnitureCategory("Bed");
        this.bedSize = "Undefined";
    }

    public BedroomCollection(String id, String bedSize, int itemCount, double price) {
        super(id, "Bed", itemCount, price);
        this.bedSize = bedSize;
    }

    // Methods
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public String getFurnitureType() {
        return "Bed";
    }

    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Bed purchased by: " + buyer);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Bed Size: " + bedSize);
        System.out.println("Discount: $" + calculateDiscount());
    }
}
