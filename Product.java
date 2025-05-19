package ModelClass;

public class Product {
    private String proId;
    private String proModel;
    private String proCategory;
    private String proName;
    private double proCurrentPrice;
    private double proRawPrice;
    private double proDiscount;
    private int proLikesCount;

    public Product(String proId, String proModel, String proCategory,
    String proName, double proCurrentPrice, double proRawPrice,
    double proDiscount, int proLikesCount){
        this.proId = proId;
        this.proModel = proModel;
        this.proCategory = proCategory;
        this.proName = proName;
        this.proCurrentPrice = proCurrentPrice;
        this.proRawPrice = proRawPrice;
        this.proDiscount = proDiscount;
        this.proLikesCount = proLikesCount;
    }

    public void setproID(String proId){
        this.proId = proId;
    }
    public void setproModel(String proModel){
        this.proModel = proModel;
    }
    public void setproCategory(String proCategory){
        this.proCategory = proCategory;
    }
    public void setproName(String proName){
        this.proName = proName;
    }
    public void setproCurrentPrice(double proCurrentPrice){
        this.proCurrentPrice = proCurrentPrice;
    }
    public void setproRawPrice(double proRawPrice){
        this.proRawPrice = proRawPrice;
    }
    public void setproDiscount(double proDiscount){
        this.proDiscount = proDiscount;
    }
    public void setproLikesCount(int proLikesCount){
        this.proLikesCount = proLikesCount;
    }

    public String getproId(){
        return proId;
    }
    public String getproModel(){
        return proModel;
    }
    public String getproCategory(){
        return proCategory;
    }
    public String getproName(){
        return proName;
    }
    public double getproCurrentPrice(){
        return proCurrentPrice;
    }
    public double getproRawPrice(){
        return proRawPrice;
    }
    public double getproDiscount(){
        return proDiscount;
    }
    public int getproLikesCount(){
        return proLikesCount;
    }

    public Product (){
        this.proId = "Default";
        this.proModel ="Default";
        this.proCategory = "Default";
        this.proName = "Default";
        this.proCurrentPrice = 0.0;
        this.proRawPrice = 0.0;
        this.proDiscount = 0.0;
        this.proLikesCount = 0;
    }
    
    public String toString(){
        return "Product {" +
            "pro_id : " + proId + "\"" +
            "pro_model : " + proModel + "\"" +
            "pro_category : " + proCategory + "\"" +
            "pro_name : " + proName + "\"" +
            "pro_currentprice : " + proCurrentPrice + "\"" +
            "pro_rawprice : " + proRawPrice + "\"" +
            "pro_discount : " + proDiscount + "\"" +
            "pro_likescount : " + proLikesCount + "\"" +
            "}";
    }
    

}
