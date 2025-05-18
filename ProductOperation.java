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
    public Product getProductById(String productId) {
        for (Product product : allProducts) {
            if (product.getproId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
    public void generateCategoryFigure(){
        /**
        * Generates a bar chart showing the total number of products
        * for each category in descending order.
        * Saves the figure into the data/figure folder.
        */
        
    }
    public void generateDiscountFigure(){
        /**
        * Generates a pie chart showing the proportion of products that have
        * a discount value less than 30, between 30 and 60 inclusive,
        * and greater than 60.
        * Saves the figure into the data/figure folder.
        */
        
    }
    public void generateLikesCountFigure(){
        /**
        * Generates a chart displaying the sum of products' likes_count
        * for each category in ascending order.
        * Saves the figure into the data/figure folder.
        */

    }
    public void generateDiscountLikesCountFigure(){
        /**
        * Generates a scatter chart showing the relationship between
        * likes_count and discount for all products.
        * Saves the figure into the data/figure folder.
        */
        
    }
    public void deleteAllProducts(){
        allProducts.clear();
    }
}



