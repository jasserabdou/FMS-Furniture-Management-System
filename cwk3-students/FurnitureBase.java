
/**
 * FurnitureBase represents an individual furniture item within the FurnitureStore system.
 * Each FurnitureBase has a unique ID, a description detailing its characteristics, 
 * a type or category (like chair, table, bed), materials used, dimensions, 
 * and a price. The store's inventory is essentially a collection of FurnitureBase objects.
 * The system relies on the comprehensive data within each FurnitureBase 
 * to manage stock levels, make sales transactions, and provide detailed 
 * product information to both staff and customers. Properly maintained 
 * FurnitureBase records ensure that the store can track product availability, 
 * popularity, and sales trends over time.
 */

import java.util.ArrayList;


abstract class FurnitureBase {
   // attributes
   private String id;
   private String furnitureCategory;
   private int itemCount;
   private double price;
   private static ArrayList<FurnitureBase> furnitureInventory = new ArrayList<>();

   // constructor
   public FurnitureBase() {
      this.id = "";
      this.furnitureCategory = "Undefined";
      this.itemCount = 0;
      this.price = 0.0;
      furnitureInventory.add(this);
   }

   public FurnitureBase(String id, String furnitureCategory, int itemCount, double price) {
      this.id = id;
      this.furnitureCategory = furnitureCategory;
      this.itemCount = itemCount;
      this.price = price;
      furnitureInventory.add(this);
   }

   // methods
   public String getID() {
      return id;
   }

   public abstract double calculateDiscount();

   public abstract String getFurnitureType();

   public String getFurnitureCategory() {
      return furnitureCategory;
   }

   public void setFurnitureCategory(String category) {
      this.furnitureCategory = category;
   }

   public void displayDetails() {
      System.out.println("\nFurniture ID: " + id);
      System.out.println("Furniture Category: " + furnitureCategory);
      System.out.println("Item Count: " + itemCount);
      System.out.println("Price: $" + price);
   }

   public abstract void associatePurchaser(String buyer);

   public static void showAllFurnitureDetails() {
      for (FurnitureBase furniture : furnitureInventory) {
         furniture.displayDetails();
      }
   }

   public double getPrice() {
      return price;
   }

   @Override
   public String toString() {
      return "Furniture ID: " + id + "\nFurniture Category: " + furnitureCategory +
            "\nItem Count: " + itemCount + "\nPrice: $" + price;
   }


}
