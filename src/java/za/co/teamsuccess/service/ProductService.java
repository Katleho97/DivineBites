
package za.co.teamsuccess.service;

import java.util.List;
import za.co.teamsuccess.pojo.Product;


public interface ProductService {
    List<Product> getProducts(int catid);
    Product getProduct(int productid);
}
