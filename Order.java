import java.util.List;
import java.text.SimpleDateFormat; // Needed for date formatting if setting current time
import java.util.Date; // Needed for Date object
import java.util.Locale; // Needed for SimpleDateFormat
public class Order extends User {
    protected String orderId;
    protected String userId;
    protected String proId;
    protected String orderTime;

    public Order(String orderId, String userId, String proId, String orderTime){
        this.orderId = orderId;
        this.userId = userid;
        this.proId = proId;
        this.orderTime = orderTime;
    }
    public Order() {
        this.orderId = null;
        this.userId = null;
        this.proId = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss", Locale.ENGLISH);
        this.orderTime = dateFormat.format(new Date());
    }
    private List<Product> productList;

    // existing constructors, methods...

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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

    public String getOrderId(String orderId){
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
        return "{\"order_id\" :\""+ orderId +
        "\", \"user_id\":\"" + userId +
        "\", \"pro_id\":\"" + proId + 
        "\", \"order_time\":\"" + orderTime + 
        "\"}";
    }
}
