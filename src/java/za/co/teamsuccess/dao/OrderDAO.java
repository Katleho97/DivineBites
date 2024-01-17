
package za.co.teamsuccess.dao;

import java.util.List;
import za.co.teamsuccess.pojo.Order;

public interface OrderDAO {
    public boolean insertOrder(Order product);
    public List<Order> userOrders(int personid);
     public boolean cancelOrder(int id);
     int getLastOrderId();
     boolean updateLastOrderId(int orderNumber);
     boolean updateOrderLineItem(int orderNo, int productId, int qty);
}
