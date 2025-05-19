public class OrderOperation {
    public static OrderOperation getInstance() {
        if (instance == null) {
            instance = new OrderOperation();
        }
        return instance;
    }
    public String generateUniqueOrderId() {
        String orderId = "o_" + System.currentTimeMillis();
        return orderId;
    }
    public boolean createanOrder(Order order) {
        if (order == null) {
            System.out.println("Order is null.");
            return false;
        }
        if (order.getOrderId() == null || order.getOrderId().isEmpty()) {
            System.out.println("Order ID is null or empty.");
            return false;
        }
        if (order.getProductList() == null || order.getProductList().isEmpty()) {
            System.out.println("Product list is null or empty.");
            return false;
        }
        System.out.println("customerID: " + order.getCustomerId());
        System.out.println("productID: " + product.getProductId());
        System.out.println("createTime: " + order.getCreateTime());
        // Add logic to save the order to a database or file
        return true;
    }
    public boolean deleteOrder(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            System.out.println("Order ID is null or empty.");
            return false;
        }
        System.out.println("orderId: "+ orderId);
        // Add logic to check if the order exists in a database or file
        // Add logic to delete the order from a database or file
        return true;
    }
    public OrderListResult getOrderList(String customerId, int pageNumber) {
        final int itemsPerPage=10;
        if (customerId == null || customerId.trim().isEmpty()) {
            System.out.println("Warning: customerId is null or empty. Returning empty list.");
            // Return empty result for invalid customer ID
            return new OrderListResult(Collections.emptyList(), pageNumber < 1 ? 1 : pageNumber, 0, customerId);
        }
        System.out.println("Retrieving orders for customer: " + customerId + ", page: " + pageNumber);
        List<Order> customerOrders = allOrders.stream()
                .filter(order -> customerId.equals(order.getCustomerId()))
                .collect(Collectors.toList());//filter orders by customerId
        int totalCustomerOrders = customerOrders.size();
        int totalPages = (int) Math.ceil((double) totalCustomerOrders / itemsPerPage);//ceil(x) lam tron ve so nguyen gan nhat
        return new OrderListResult(pageNumber, totalPages, customerId);
        //NEED HELP
    }
    public void generateTestOrderData(){
        /**
    * Automatically generates test data including customers and orders.
    * Creates 10 customers and randomly generates 50-200 orders for each.
    * Order times should be scattered across different months of the year.
    */
    }
    public void generateSingleCustomerConsumptionFigure(String customerId){
        /**
        * Generates a chart showing the consumption (sum of order prices)
        * across 12 different months for the given customer.
        * @param customerId The ID of the customer
        */
    }
    public void generateAllCustomerConsumptionFigure(){
        /**
        * Generates a chart showing the consumption (sum of order prices)
        * across 12 different months for all customers.
        */
    }
    public void generateAllTop10BestSellersFigure(){
        /**
        * Generates a graph showing the top 10 best-selling products
        * sorted in descending order.
        */
    }
    public void deleteAllOrders(){
        /**
        * Removes all data in the data/orders.txt file.
        */
    }

}
