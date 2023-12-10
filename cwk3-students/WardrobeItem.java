public class WardrobeItem extends FurnitureBase {
    // attributes
    private String wardrobeMaterial;

    // constructor
    public WardrobeItem() {
        super();
        this.setFurnitureCategory("Wardrobe");
        this.wardrobeMaterial = "Undefined";
    }

    public WardrobeItem(String id, String wardrobeMaterial, int itemCount, double price) {
        super(id, "Wardrobe", itemCount, price);
        this.wardrobeMaterial = wardrobeMaterial;
    }

    // methods
    @Override
    public double calculateDiscount() {
        // You can customize the discount calculation for wardrobes if needed
        return getPrice() * 0.1;
    }

    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Wardrobe purchased by: " + buyer);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Wardrobe Material: " + wardrobeMaterial);
        System.out.println("Discount: $" + calculateDiscount());
    }

    @Override
    public String getFurnitureType() {
        return "Wardrobe";
    }
}
