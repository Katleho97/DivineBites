package za.co.teamsuccess.service.impl;

import java.util.List;
import za.co.teamsuccess.dao.ProductDAO;
import za.co.teamsuccess.dao.impl.ProductDAOImpl;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Product;
import za.co.teamsuccess.service.ProductService;

public class ProductServiceImpl implements ProductService{

    ProductDAO productDao;
    
    public ProductServiceImpl(DBPoolManagerBasic dbpm) {
        productDao = new ProductDAOImpl(dbpm);
    }

    @Override
    public List<Product> getProducts(int catid) {
        return productDao.getProductsByCategoryid(catid);
    }
    
    @Override
    public Product getProduct(int productid){
        return productDao.getProduct(productid);
    }

}
