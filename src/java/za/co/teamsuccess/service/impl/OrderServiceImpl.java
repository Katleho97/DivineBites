
package za.co.teamsuccess.service.impl;

import za.co.teamsuccess.dao.ProductDAO;
import za.co.teamsuccess.dao.impl.ProductDAOImpl;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Product;
import za.co.teamsuccess.service.OrderService;


public class OrderServiceImpl implements OrderService{
private DBPoolManagerBasic dbpm;
    public OrderServiceImpl(DBPoolManagerBasic dbpm) {
        this.dbpm=dbpm;
    }

    @Override
    public Product add(int id) {
        ProductDAO productDao = new ProductDAOImpl(dbpm);
        return productDao.getProduct(id);
    }
    
}
