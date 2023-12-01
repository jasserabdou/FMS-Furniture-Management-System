class BedroomCollection extends FurnitureBase {
    // attributes
    private String bedSize;

    // constructor
    public BedroomCollection() {
        super();
        this.setFurnitureCategory("Bed");
        this.bedSize = "Undefined";
    }

    public BedroomCollection(String id, String bedSize, int itemCount, double price) {
        super(id, "Bed", itemCount, price);
        this.bedSize = bedSize;
    }

    // methods
    @Override
    public double calculateDiscount() {

        return getPrice() * 0.15;
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