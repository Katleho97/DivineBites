package za.co.teamsuccess.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.teamsuccess.dao.OrderDAO;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Order;
import za.co.teamsuccess.pojo.Product;

public class OrderDAOImpl implements OrderDAO {

    private PreparedStatement ps;
    private Connection con;
    final private DBPoolManagerBasic dbManager;
    private ResultSet rs;

    public OrderDAOImpl(DBPoolManagerBasic dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public boolean insertOrder(Order order) {
        boolean inserted = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into ordertable(orderid,addressid,personid,orderdate) VALUES (?,?,?,CURDATE())");
            ps.setInt(1, order.getOrderId());
            ps.setInt(2, order.getAddresid());
            ps.setInt(3, order.getPersonid());
            inserted = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error placing order : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return inserted;
    }
////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<Order> userOrders(int productid) {
        List<Order> userOrders = new ArrayList<>();
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("select * from ordertable where orderid = ? by orderid desc");
            ps.setInt(1, productid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                ProductDAOImpl productDAOImpl = new ProductDAOImpl(dbManager);
                int productID = rs.getInt("productid");
                Product product = productDAOImpl.getProduct(productID);
                order.setOrderId(rs.getInt("orderid"));
                order.setOrderId(productid);
                order.setAddresid(rs.getInt("adressid"));
                order.setPersonid(rs.getInt("productid"));
                order.setOrderdate(rs.getString("orderdate"));

                userOrders.add(order);
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching list of orders : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return userOrders;
    }
/////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean cancelOrder(int orderid) {
        boolean orderCancelled = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("delete from ordertable where orderid = ?");
            ps.setInt(1, orderid);
            orderCancelled = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error deleting order from database : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return orderCancelled;
    }

    @Override
    public int getLastOrderId() {
        int invoiceId = 0;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("SELECT lastid FROM lastidtable WHERE keyid='orderNo'");
            rs = ps.executeQuery();
            if (rs.next()) {
                invoiceId = rs.getInt("lastid");
            }
        } catch (SQLException ex) {
            System.out.println("Error getting invoice from database : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return invoiceId;
    }

    
    @Override
    public boolean updateOrderLineItem(int orderNo, int productId, int qty){
        boolean inserted = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into orderproduct (orderid,productid,qty) values(?,?,?)");
            ps.setInt(1, orderNo);
            ps.setInt(2, productId);
            ps.setInt(3, qty);
            inserted = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error placing order line items : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return inserted;
    }
    //***********************************************************************************************************
    private void closeStreams() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error closing ResultSet: " + ex.getMessage());
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error closing prepared statement: " + ex.getMessage());
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }
        rs = null;
        ps = null;
        con = null;
    }

    //***********************************************************************************************************
    @Override
    public boolean updateLastOrderId(int orderNumber) {
        boolean retVal = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("UPDATE lastidtable SET lastid=? WHERE keyid='orderNo'");
            ps.setInt(1, orderNumber);
            if (ps.executeUpdate() > 0) {
                retVal = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error updating order number in database : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return retVal;
    }

}
