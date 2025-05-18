package ModelClass;

public class Order {
    private String orderId;
    private String userId;
    private String proId;
    private String orderTime;

    public Order(String orderId, String userId, String proId, String orderTime){
        this.orderId = orderId;
        this.userId = userId;
        this.proId = proId;
        this.orderId = orderId;
    }

    public void setorderId(String orderId){
        this.orderId = orderId;
    }
    public void setuserId(String userId){
        this.userId = userId;
    }
    public void setproId(String proId){
        this.proId = proId;
    }
    public void setorderTime(String orderTime){
        this.orderTime = orderTime;
    }

    public String getorderId(String orderId){
       return orderId;
    }
    public String getuserId(String userId){
        return userId;
    }
    public String getproId(String proId){
        return proId;
    }
    public String getorderTime(String orderTime){
        return orderTime;
    }

    @Override
    public String toString() {
        return "Order {" +
        "order_id : " + orderId + "\""+
        "user_id : " + userId + "\"" +
        "pro_id : " + proId + "\"" +
        "order_time" + orderTime +  "\"" +
        "}";
    }
}
