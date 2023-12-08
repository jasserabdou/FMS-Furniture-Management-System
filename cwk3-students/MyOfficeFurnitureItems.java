public class MyOfficeFurnitureItems extends OfficeFurniture {

    private String id;
    private int itemCount;
    private double price;

    public MyOfficeFurnitureItems() {
        super();
        this.id = "";
        this.itemCount = 0;
        this.price = 0.0;
    }

    public MyOfficeFurnitureItems(String id, String furnitureCategory, boolean isErgonomic, String material,
            int itemCount, double price) {
        super(furnitureCategory, isErgonomic, material, price);
        this.id = id;
        this.itemCount = itemCount;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public void adjustPrice() {
        super.adjustPrice();
        if (getItemCount() > 5) {
            price -= price * 0.1;
        }
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Office Furniture (ID: " + id + ") purchased by: " + buyer);
    }

    @Override
    public String getFurnitureType() {
        return "Office Furniture";
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Item Count: " + itemCount);
        super.displayDetails();
    }

}
