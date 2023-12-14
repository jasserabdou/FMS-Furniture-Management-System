import java.util.*;

/**
 * A Purchaser is a vital entity in the FurnitureStore system. Each Purchaser has an ID, 
 * a name, contact information including phone number, email, and a physical address. 
 * Purchasers are the customers or clients who make orders or procure furniture items 
 * from the store. The system keeps track of each Purchaser to maintain order histories, 
 * shipping details, and other transaction-related records. Detailed information about 
 * every Purchaser is essential for the store's customer relationship management, 
 * facilitating personalized services, promotions, and streamlined communication.
 */
import java.util.ArrayList;
import java.util.Date;

class Purchaser {
    // attributes
    private String id; // Unique identifier for the purchaser
    private String name; // Name of the purchaser
    private String furnitureType; // Preferred furniture type of the purchaser
    private String contactDetails; // Contact details of the purchaser (e.g., phone number, email, address)
    private Date purchaseDate; // Date of the most recent purchase made by the purchaser
    private ArrayList<String> purchaseHistory; // List of items purchased by the purchaser

    // Constructor
    /**
     * Constructs a new Purchaser with the given parameters.
     * 
     * @param id            The unique identifier for the purchaser.
     * @param name          The name of the purchaser.
     * @param furnitureType The preferred furniture type of the purchaser.
     */
    public Purchaser(String id, String name, String furnitureType) {
        this(id, name, furnitureType, "", new Date());
    }

    /**
     * Constructs a new Purchaser with the given parameters.
     * 
     * @param id             The unique identifier for the purchaser.
     * @param name           The name of the purchaser.
     * @param furnitureType  The preferred furniture type of the purchaser.
     * @param contactDetails The contact details of the purchaser.
     * @param purchaseDate   The date of the most recent purchase made by the
     *                       purchaser.
     */
    public Purchaser(String id, String name, String furnitureType, String contactDetails, Date purchaseDate) {
        this.id = id;
        this.name = name;
        this.furnitureType = furnitureType;
        this.contactDetails = contactDetails;
        this.purchaseDate = purchaseDate;
        this.purchaseHistory = new ArrayList<>();
    }

    // methods
    /**
     * Gets the name of the purchaser.
     * 
     * @return The name of the purchaser.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unique identifier of the purchaser.
     * 
     * @return The unique identifier of the purchaser.
     */
    public String getID() {
        return id;
    }

    /**
     * Gets the preferred furniture type of the purchaser.
     * 
     * @return The preferred furniture type of the purchaser.
     */
    public String getFurnitureType() {
        return furnitureType;
    }

    /**
     * Gets the contact details of the purchaser.
     * 
     * @return The contact details of the purchaser.
     */
    public String getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the contact details of the purchaser.
     * 
     * @param contact The contact details to be set.
     */
    public void setContactDetails(String contact) {
        this.contactDetails = contact;
    }

    /**
     * Adds an item to the purchase history of the purchaser.
     * 
     * @param item The item to be added to the purchase history.
     */
    public void addToPurchaseHistory(String item) {
        purchaseHistory.add(item);
    }

    /**
     * Gets the purchase history of the purchaser.
     * 
     * @return The purchase history of the purchaser.
     */
    public List<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    /**
     * Checks if the number of purchases made by the purchaser is below a specified
     * threshold.
     * 
     * @param thresholdValue The threshold value for the number of purchases.
     * @return True if the number of purchases is below the threshold; false
     *         otherwise.
     */
    public boolean isPurchaseValid(int thresholdValue) {
        return purchaseHistory.size() < thresholdValue;
    }

    /**
     * Displays detailed information about the purchaser, including purchase details
     * and history.
     */
    public void displayDetails() {
        System.out.println("\nPurchaser ID: " + id);
        System.out.println("Purchaser Name: " + name);
        System.out.println("Preferred Furniture Type: " + furnitureType);
        System.out.println("Contact Details: " + contactDetails);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Purchase History:");

        for (String item : purchaseHistory) {
            System.out.println("- " + item);
        }
    }
}
