public class TableItem extends FurnitureBase {
    // attributes
    private String tableMaterial;

    // constructor
    public TableItem() {
        super();
        this.setFurnitureCategory("Table");
        this.tableMaterial = "Undefined";
    }

    public TableItem(String id, String tableMaterial, int itemCount, double price) {
        super(id, "Table", itemCount, price);
        this.tableMaterial = tableMaterial;
    }

    // methods
    @Override
    public double calculateDiscount() {
        // You can customize the discount calculation for tables if needed
        return getPrice() * 0.1;
    }

    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Table purchased by: " + buyer);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Table Material: " + tableMaterial);
        System.out.println("Discount: $" + calculateDiscount());
    }

    @Override
    public String getFurnitureType() {
        return "Table";
    }
}
