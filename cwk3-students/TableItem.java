/**
 * TableItem represents a type of furniture item within the FurnitureStore
 * system.
 * It extends the FurnitureBase class and adds specific attributes and behaviors
 * for tables.
 */
public class TableItem extends FurnitureBase {
    // Attributes
    private String tableMaterial;

    // Constructors
    public TableItem() {
        super();
        this.setFurnitureCategory("Table");
        this.tableMaterial = "Undefined";
    }

    public TableItem(String id, String tableMaterial, int itemCount, double price) {
        super(id, "Table", itemCount, price);
        this.tableMaterial = tableMaterial;
    }

    // Methods
    @Override
    public double calculateDiscount() {
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
