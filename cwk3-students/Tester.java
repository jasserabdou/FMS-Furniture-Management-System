/**
 * The Tester class is responsible for testing the Furniture Management System.
 * It creates instances of furniture items, purchasers, and orders,
 * and displays details of furniture, purchasers, and orders.
 */
public class Tester {
    private FurnitureStore FMS;

    /**
     * Constructor for the Tester class.
     * Initializes the FurnitureStore for testing.
     */
    public Tester() {
        FMS = new FurnitureStore("Furniture Management System", "Downtown");
    }

    /**
     * The doTest() method where you will write code to test your system.
     * It creates furniture items, purchasers, and orders, and displays details.
     */
    public void doTest() {
        // Creating furniture items
        FurnitureBase Sofa = new SofaItem("1", "Leather Sofa", 2, 800);
        FurnitureBase Bed = new BedroomCollection("2", "King Size Bed", 1, 1200);
        FurnitureBase Chair = new ChairItem("3", "Wooden Chair", 5, 100);
        FurnitureBase Table = new TableItem("4", "Dining Table", 3, 300);
        FurnitureBase Wardrobe = new WardrobeItem("5", "3-door Wooden Wardrobe", 4, 900);

        // Creating purchasers
        Purchaser IKEA = new Purchaser("1", "IKEA", "", "Email: ikea@example.com", null);
        Purchaser Walmart = new Purchaser("2", "Walmart", "", "Email: walmart@example.com", null);
        Purchaser WestElm = new Purchaser("3", "West Elm", "", "Email: westelm@example.com", null);
        Purchaser Target = new Purchaser("4", "Target", "", "Email: target@example.com", null);
        Purchaser HomeGoods = new Purchaser("5", "HomeGoods", "", "Email: homegoods@example.com", null);

        // Creating orders
        Order order1 = new Order("101", Chair, IKEA, 5);
        Order order2 = new Order("102", Table, Walmart, 3);
        Order order3 = new Order("103", Sofa, WestElm, 2);
        Order order4 = new Order("104", Bed, Target, 1);
        Order order5 = new Order("105", Wardrobe, HomeGoods, 4);

        // Displaying details FurnitureBase
        System.out.println("\nAll Furniture Details:");
        FurnitureBase.showAllFurnitureDetails();
        System.out.println("------------------------------------------------");

        // Displaying details Purchaser
        System.out.println("\nAll Purchaser Details:");
        IKEA.displayDetails();
        Walmart.displayDetails();
        WestElm.displayDetails();
        Target.displayDetails();
        HomeGoods.displayDetails();
        System.out.println("------------------------------------------------");

        // Displaying details Orders
        System.out.println("\nAll Orders Details:");
        order1.displayDetails();
        order2.displayDetails();
        order3.displayDetails();
        order4.displayDetails();
        order5.displayDetails();
        System.out.println("------------------------------------------------");
    }

    /**
     * Main method to make the class executable.
     * No need to change this.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.doTest();
    }
}
