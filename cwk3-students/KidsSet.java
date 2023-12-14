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

    // Attributes
    private String kidsId;
    private String furName;
    private double price;

    // Constructors
    public KidsSet(String id, String furnitureCategory, int itemCount, double price, String kidsId, String furName) {
        super(id, furnitureCategory, itemCount, price);
        this.kidsId = kidsId;
        this.furName = furName;
        this.price = price;
    }

    // Methods

    public KidsSet() {
    }

    /**
     * Gets the identifier for the KidsSet.
     *
     * @return The identifier for the KidsSet.
     */
    public String getKidsId() {
        return kidsId;
    }

    /**
     * Gets the name of the furniture in the KidsSet.
     *
     * @return The name of the furniture in the KidsSet.
     */
    public String getFurName() {
        return furName;
    }

    /**
     * Gets the price of the KidsSet.
     *
     * @return The price of the KidsSet.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Displays the price of the KidsSet.
     */
    public void showPrice() {
        System.out.println("Price for " + furName + " set: $" + getPrice());
    }

    /**
     * Provides surprise gifts based on the price of the KidsSet.
     *
     * @return The mystery gift corresponding to the purchase price.
     */
    public String mysteryGift() {
        if (price > 500) {
            return "Luxury Office Chair";
        } else if (price >= 300 && price <= 500) {
            return "Desk Organizer Set";
        } else if (price >= 200 && price < 300) {
            return "Free Lamp";
        } else {
            return "No mystery gift for this purchase";
        }
    }

    /**
     * Displays detailed information about the KidsSet, including Kids Set ID,
     * furniture name, price, and mystery gift.
     */
    public void displayDetails() {
        String gift = mysteryGift();
        System.out.println("Kids Set ID: " + getKidsId());
        System.out.println("Furniture Name: " + getFurName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Mystery Gift: " + gift);
    }
}
