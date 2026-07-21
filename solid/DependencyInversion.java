package solid;

public class DependencyInversion {
    class BadCode {
        // Problematic approach that violates DIP
        class EmailNotifier {
            public void sendEmail(String message) {
                // Configure SMTP
                // Set up email templates
                // Send email implementation
                System.out.println(message);
            }
        }
        class DatabaseLogger {
            public void logTransaction(String log) {
                System.out.println(log);
            }
        }
        class InventorySystem {
            public void updateStock(Order order) {
                // get supplies implementation
            }
        }
        class Product {
            String itemName;
            String itemId;
            public String getItemId() {
                return this.itemId;
            }
            public String getItemName() {
                return this.itemName;
            }
        }
        class Order {
            Product product;
            String orderId;

            public String getOrderId() {
                return orderId;
            }

            public Product getProduct() {
                return product;
            }
        }

        class OrderService {
            private EmailNotifier emailNotifier;
            private DatabaseLogger logger;
            private InventorySystem inventory;
            public OrderService() {
                // Direct dependencies on concrete implementations
                this.emailNotifier = new EmailNotifier();
                this.logger = new DatabaseLogger();
                this.inventory = new InventorySystem();
            }
            public void placeOrder(Order order) {
                // Process order
                inventory.updateStock(order);
                emailNotifier.sendEmail("Order #" + order.getOrderId() + " placed successfully");
                logger.logTransaction("Order placed: " + order.getOrderId());
            }
        }
    }
    class GoodCode {
        // Better approach following DIP
        interface NotificationService {
            void sendNotification(String message);
        }

        interface LoggingService {
            void logMessage(String message);
            void logError(String error);
        }

        interface InventoryService {
            void updateStock(Order order);
            boolean checkAvailability(Product product);
        }

        class EmailNotifier implements NotificationService {
            @Override
            public void sendNotification(String message) {
                // Email specific implementation
            }
        }

        class SMSNotifier implements NotificationService {
            @Override
            public void sendNotification(String message) {
                // SMS specific implementation
            }
        }

        class PushNotifier implements NotificationService {
            @Override
            public void sendNotification(String message) {
                // Push notification specific implementation
            }
        }

        class DatabaseLogger implements LoggingService {
            @Override
            public void logMessage(String message) {
                // Database logging implementation
            }
            @Override
            public void logError(String error) {
                // Error logging implementation
            }
        }
        class Product {
            String itemName;
            String itemId;
            public String getItemId() {
                return this.itemId;
            }
            public String getItemName() {
                return this.itemName;
            }
        }
        class Order {
            Product product;
            String orderId;

            public String getOrderId() {
                return orderId;
            }

            public Product getProduct() {
                return product;
            }
        }

        class OrderService {
            private final NotificationService notificationService;
            private final LoggingService loggingService;
            private final InventoryService inventoryService;
            // Constructor injection of dependencies
            public OrderService(NotificationService notificationService,
                                LoggingService loggingService, InventoryService inventoryService) {
                this.notificationService = notificationService;
                this.loggingService = loggingService;
                this.inventoryService = inventoryService;
            }

            public void placeOrder(Order order) {
                try {
                    // Check inventory
                    if (inventoryService.checkAvailability(order.getProduct())) {
                        // Process order
                        inventoryService.updateStock(order);
                        // Send notification
                        notificationService.sendNotification(
                                "Order #" + order.getOrderId() + " placed successfully");
                        // Log success
                        loggingService.logMessage(
                                "Order processed successfully: " + order.getOrderId());
                    }
                } catch (Exception e) {
                    loggingService.logError(
                            "Error processing order: " + order.getOrderId() + " - " + e.getMessage());
                    throw e;
                }
            }
        }
    }

    // Usage with dependency injection
//    NotificationService emailNotifier = new EmailNotifier();
//    LoggingService logger = new DatabaseLogger();
//    InventoryService inventory = new WarehouseInventoryService();
//    OrderService orderService = new OrderService(emailNotifier, logger, inventory);
}
