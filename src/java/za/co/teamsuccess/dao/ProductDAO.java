package za.co.teamsuccess.dao;

import java.util.List;

import za.co.teamsuccess.pojo.Product;

public interface ProductDAO {

    Product getProduct(int productid);

    List<Product> getProductsByProductid();

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deactivateProduct(int productid);

    boolean activateProduct(int productid);

    public List<Product> getProductsByCategoryid(int catid);
}
