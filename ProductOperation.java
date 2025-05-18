import java.util.List;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;

public class ProductOperation extends Product {
    private static ProductOperation productOperation;
    private List<Product> allProducts = new ArrayList<>();

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
    public List<Product> getProductListByKeyword(String keyword){
        List<Product> matchingProducts = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Keyword is null or empty.");
            return Collections.emptyList();
        }
        String lowerCaseKeyword = keyword.trim().toLowerCase(Locale.ENGLISH); //convert keyword to lowercase
        System.out.println("Searching for products containing keyword: '" + keyword + "'");
        for (Product product : allProducts){
            String lowerCaseProductName = product.getproName().toLowerCase(Locale.ENGLISH);
            if (lowerCaseProductName.contains(lowerCaseKeyword)) {
                matchingProducts.add(product);//If it contains, add the product to the list
            }
        }
        System.out.println("Found " + matchingProducts.size() + "matching products.");
        return matchingProducts;
        
    }
}



