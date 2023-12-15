import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {
    private Scanner scanner;

    public Tester() {
        new FurnitureStore("Furniture Management System", "Downtown");
        scanner = new Scanner(System.in);
    }

    // The doTest() method where you will write code to test your system
    public void doTest() {
        try {
            // Asking the user to enter the number of furniture items
            System.out.println("Welcome to the Furniture Management System!");
            System.out.println("Please enter the number of furniture items:");
            int numFurniture = Integer.parseInt(scanner.nextLine());

            // Creating an array of furniture items
            FurnitureBase[] furnitureItems = new FurnitureBase[numFurniture];

            // Looping through the array and asking the user to enter the details of each
            // furniture item
            for (int i = 0; i < numFurniture; i++) {
                System.out.println("Please enter the details of furniture item " + (i + 1) + ":");
                System.out.println("Enter the type of furniture (Sofa, Bed, Chair, Table, or Wardrobe):");
                String type = scanner.nextLine();
                System.out.println("Enter the ID of the furniture:");
                String id = scanner.nextLine();
                System.out.println("Enter the name of the furniture:");
                String name = scanner.nextLine();
                System.out.println("Enter the quantity of the furniture:");
                int quantity = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the price of the furniture:");
                double price = Double.parseDouble(scanner.nextLine());

                // Creating a furniture item based on the type and adding it to the array
                switch (type) {
                    case "Sofa":
                        furnitureItems[i] = new SofaItem(id, name, quantity, price);
                        break;
                    case "Bed":
                        furnitureItems[i] = new BedroomCollection(id, name, quantity, price);
                        break;
                    case "Chair":
                        furnitureItems[i] = new ChairItem(id, name, quantity, price);
                        break;
                    case "Table":
                        furnitureItems[i] = new TableItem(id, name, quantity, price);
                        break;
                    case "Wardrobe":
                        furnitureItems[i] = new WardrobeItem(id, name, quantity, price);
                        break;
                    default:
                        System.out.println("Invalid type. Please try again.");
                        i--; // decrement the index to repeat the iteration
                }
            }

            // Asking the user to enter the number of purchasers
            System.out.println("Please enter the number of purchasers:");
            int numPurchasers = Integer.parseInt(scanner.nextLine());

            // Creating an array of purchasers
            Purchaser[] purchasers = new Purchaser[numPurchasers];

            // Looping through the array and asking the user to enter the details of each
            // purchaser
            for (int i = 0; i < numPurchasers; i++) {
                System.out.println("Please enter the details of purchaser " + (i + 1) + ":");
                System.out.println("Enter the ID of the purchaser:");
                String id = scanner.nextLine();
                System.out.println("Enter the name of the purchaser:");
                String name = scanner.nextLine();
                System.out.println("Enter the address of the purchaser:");
                String address = scanner.nextLine();
                System.out.println("Enter the contact details of the purchaser:");
                String contactDetails = scanner.nextLine();
                System.out.println("Enter the date of purchase (dd/mm/yyyy):");
                String date = scanner.nextLine();

                // Creating a date object from the string
                Date dateOfPurchase = null;
                try {
                    dateOfPurchase = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Creating a purchaser object and adding it to the array
                purchasers[i] = new Purchaser(id, name, address, contactDetails, dateOfPurchase);
            }

            // Asking the user to enter the number of orders
            System.out.println("Please enter the number of orders:");
            int numOrders = Integer.parseInt(scanner.nextLine());

            // Creating an array of orders
            Order[] orders = new Order[numOrders];

            // Looping through the array and asking the user to enter the details of each
            // order
            for (int i = 0; i < numOrders; i++) {
                System.out.println("Please enter the details of order " + (i + 1) + ":");
                System.out.println("Enter the ID of the order:");
                String id = scanner.nextLine();
                System.out.println("Enter the ID of the furniture item:");
                String furnitureId = scanner.nextLine();
                System.out.println("Enter the ID of the purchaser:");
                String purchaserId = scanner.nextLine();
                System.out.println("Enter the quantity of the order:");
                int quantity = Integer.parseInt(scanner.nextLine());

                // Finding the furniture item and the purchaser from the arrays using the IDs
                FurnitureBase furnitureItem = null;
                Purchaser purchaser = null;
                for (int j = 0; j < numFurniture; j++) {
                    if (furnitureItems[j].getID().equals(furnitureId)) {
                        furnitureItem = furnitureItems[j];
                        break;
                    }
                }
                for (int j = 0; j < numPurchasers; j++) {
                    if (purchasers[j].getID().equals(purchaserId)) {
                        purchaser = purchasers[j];
                        break;
                    }
                }

                // Creating an order object and adding it to the array
                orders[i] = new Order(id, furnitureItem, purchaser, quantity);
            }

            // Asking the user what they want to see
            System.out.println("Please enter one of the following options:");
            System.out.println("1. All Furniture Details");
            System.out.println("2. All Purchaser Details");
            System.out.println("3. All Orders Details");
            System.out.println("4. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            while (option != 4) {
                switch (option) {
                    case 1:
                        // Displaying details FurnitureBase
                        System.out.println("\nAll Furniture Details:");
                        for (int i = 0; i < numFurniture; i++) {
                            furnitureItems[i].displayDetails();
                        }
                        break;
                    case 2:
                        // Displaying details Purchaser
                        System.out.println("\nAll Purchaser Details:");
                        for (int i = 0; i < numPurchasers; i++) {
                            purchasers[i].displayDetails();
                        }
                        break;
                    case 3:
                        // Displaying details Orders
                        System.out.println("\nAll Orders Details:");
                        for (int i = 0; i < numOrders; i++) {
                            orders[i].displayDetails();
                        }
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
                System.out.println("Please enter another option or 4 to exit:");
                option = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("Thank you for using the Furniture Management System!");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again.");
        } finally {
            scanner.close();
        }
    }

    // Main method to make the class executable
    // No need to change this
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.doTest();
    }
}
