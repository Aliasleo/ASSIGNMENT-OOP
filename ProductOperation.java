public class ProductOperation {
    private static ProductOperation productOperation;

    public static ProductOperation getInstance(){
        if (productOperation == null) {
            productOperation = new ProductOperation();
        }
        return productOperation;
    }
    public void extractProductsFromFile() {}
    public ProductListResult getProductList(int pageNumber){}
    public boolean deleteProduct(String productId) {
        return false;
    }
    public List<Product> getProductListBy Keyword(String keyword){
        
    }
}



