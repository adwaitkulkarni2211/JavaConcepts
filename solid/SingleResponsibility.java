package solid;

public class SingleResponsibility {
    // Violation of single responsibility.
    // This baker has taken up way too much work.
    class DistractedBaker {
        public void bakeBread() {
            System.out.println("baking a bread, but it's going to take some time. Sorry, I got a lot on my plate.");
        }
        public void cleanBakery() {
            System.out.println("Oh shoot! I burnt the breads I was baking!");
        }
        public void orderSupplies() {
            System.out.println("I need 100KG flour, stat!");
        }
        public void serve() {
            System.out.println("2 breads comin' right up!");
        }
    }

    // single responsibility in action
    class GoodBaker {
        public void bakeBread() {
            System.out.println("baking a bread!");
        }
    }
    class Janitor {
        public void cleanBakery() {
            System.out.println("cleaning the bakery!");
        }
    }
    class InventoryManager {
        public void orderSupplies() {
            System.out.println("I need 100KG flour, stat!");
        }
        public void discardWaste() {
            System.out.println("Eww, bugs!");
        }
    }
    class Waiter {
        public void serve() {
            System.out.println("Enjoy your bread!");
        }
    }
}
