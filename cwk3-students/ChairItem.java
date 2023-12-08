class ChairItem extends FurnitureBase {
    // attributes
    private String chairMaterial;

    // Constructor
    public ChairItem() {
        super();
        this.setFurnitureCategory("Chair");
        this.chairMaterial = "Undefined";
    }

    public ChairItem(String id, String chairMaterial, int itemCount, double price) {
        super(id ,"Chair", itemCount, price);
        this.chairMaterial = chairMaterial;
    }

    // methods
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
