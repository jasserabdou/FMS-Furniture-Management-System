/**
 * KidsSet represents a specialized category of furniture items within the
 * FurnitureStore system,
 * explicitly designed for children. This type of furniture emphasizes safety,
 * smaller dimensions,
 * creative designs, and durability to withstand the lively activities of
 * children.
 * Examples include cribs, toddler beds, toy chests, kid-sized tables, and
 * chairs, among others.
 * 
 * The differentiation of KidsSet is essential because children have unique
 * needs when it comes to furniture.
 * Their furniture must be safe, free from sharp edges, made with non-toxic
 * materials, and often
 * incorporates playful designs or themes to cater to their preferences.
 * 
 * Recognizing and classifying KidsSet not only ensures safety and satisfaction
 * for younger users
 * but also assists parents in making informed decisions when furnishing spaces
 * for their children.
 * Additionally, by isolating this category, the store can effectively focus its
 * marketing and
 * sales strategies towards families and institutions catering to children, like
 * schools or daycares.
 */

public abstract class KidsSet extends FurnitureBase {

    // attributes
    private String kidsId;
    private String furName;

    // Constructors
    public KidsSet() {
        super();
        this.kidsId = "Undefined";
        this.furName = "Undefined";
    }

    public KidsSet(String id, String furnitureCategory, int itemCount, double price, String kidsId, String furName) {
        super(id, furnitureCategory, itemCount, price);
        this.kidsId = kidsId;
        this.furName = furName;
    }

    // methods
    public String getKidsId() {
        return kidsId;
    }

    public String getFurName() {
        return furName;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    // Method to show the price of the KidsSet
    public void showPrice() {
        System.out.println("Price for " + furName + " set: $" + getPrice());
    }

    // Method for mystery gift based on the purchase price
    public String mysteryGift() {
        double purchasePrice = getPrice();

        if (purchasePrice > 500) {
            return "Luxury Office Chair";
        } else if (purchasePrice >= 300 && purchasePrice <= 500) {
            return "Desk Organizer Set";
        } else if (purchasePrice >= 200 && purchasePrice < 300) {
            return "Free Lamp";
        } else {
            return "No mystery gift for this purchase";
        }

    }

    public void displayDetails() {
        String gift = mysteryGift();
        System.out.println("Kids Set ID: " + getKidsId());
        System.out.println("Furniture Name: " + getFurName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Mystery Gift: " + gift);
    }

}