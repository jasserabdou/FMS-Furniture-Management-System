class SofaItem extends FurnitureBase {
    // attributes
    private String sofaMaterial;

    // constructor
    public SofaItem() {
        super();
        this.setFurnitureCategory("Sofa");
        this.sofaMaterial = "Undefined";
    }

    public SofaItem(String id, String sofaMaterial, int itemCount, double price) {
        super(id, "Sofa", itemCount, price);
        this.sofaMaterial = sofaMaterial;

    }

    // methods
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Sofa purchased by: " + buyer);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Sofa Material: " + sofaMaterial);
        System.out.println("Discount: $" + calculateDiscount());
    }

    @Override
    public String getFurnitureType() {
        return "Sofa";
    }

}
