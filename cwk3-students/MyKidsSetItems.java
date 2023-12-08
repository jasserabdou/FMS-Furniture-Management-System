public class MyKidsSetItems extends KidsSet {

    public MyKidsSetItems() {
        super();
    }

    public MyKidsSetItems(String id, String furnitureCategory, int itemCount, double price, String kidsId,
            String furName) {
        super(id, furnitureCategory, itemCount, price, kidsId, furName);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public void associatePurchaser(String buyer) {
        System.out.println("Kids Set purchased by: " + buyer);
    }

    @Override
    public String getFurnitureType() {
        return "Kids Set";
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); 
    }
}
