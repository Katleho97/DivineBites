package za.co.teamsuccess.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.teamsuccess.dao.ProductDAO;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Product;

/**
 *
 * @author Student07
 */
public class ProductDAOImpl implements ProductDAO {

    private PreparedStatement ps;
    private Connection con;
    private ResultSet rs;
    final private DBPoolManagerBasic dbManager;

    public ProductDAOImpl(DBPoolManagerBasic dbManager) {
        this.dbManager = dbManager;
    }
    //******************Returning product object*******************************

    @Override
    public Product getProduct(int productid) {
        Product product = null;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("select productid,categoryid,productname,productdesc,allergies,dietary,price,ingredients,picture from product where productid = ? and active = 1 ");
            ps.setInt(1, productid);
            rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(
                        rs.getString("productname"),
                        rs.getInt("price"),
                        rs.getString("productdesc"),
                        rs.getString("allergies"),
                        rs.getString("dietary"),
                        rs.getString("ingredients"),
                        rs.getInt("categoryid"),
                        rs.getInt("productid")
                   );
                product.setPicture(rs.getString("picture"));
            }
        } catch (SQLException ex) {
            System.out.println("Error returning product information from database " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return product;
    }

    // ********************************************************************************************************
    @Override
    public List<Product> getProductsByCategoryid(int categoryid) {
        List<Product> products = new ArrayList<>();
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("select productid,categoryid,productname,productdesc,allergies,dietary,price,ingredients, picture from product where categoryid = ? and active = 1");
            ps.setInt(1, categoryid);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product =  new Product(
                        rs.getString("productname"),
                        rs.getInt("price"),
                        rs.getString("productdesc"),
                        rs.getString("allergies"),
                        rs.getString("dietary"),
                        rs.getString("ingredients"),
                        rs.getInt("categoryid"),
                        rs.getInt("productid"));
                product.setPicture( rs.getString("picture"));
                products.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error unable to get the products from the database : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return products;
    }

    //*******************************************************************************************************
    @Override
    public boolean addProduct(Product product) {
        boolean retVal = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("insert into product(productid,categoryid,"
                    + "productname,productdesc,dateadded,allergies,dietary,price,ingredients,active)"
                    + " values(null,null,?,?,now(),?,?,?,?,?");
           ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getAllergies());
            ps.setString(4, product.getDietary());
            ps.setInt(5, product.getPrice());
            ps.setString(6, product.getIngredients());

            retVal = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error adding product to database " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return retVal;
    }
//***********************************************************************************************************
     public List<Product> selectAllProducts() {

        List<Product> product = new ArrayList<>();

        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM product AS i where active = 1 order BY i.categoryid asc");
            rs = ps.executeQuery();
            while (rs.next()) {
                int productid = rs.getInt("productid");
                int categoryid = rs.getInt("categoryid");
                String name = rs.getString("productname");
                String desc = rs.getString("productdesc");
                Date dateadded = rs.getDate("dateadded");
                String allergies = rs.getString("allergies");
                String dietary = rs.getString("dietary");
                int price = rs.getInt("price");
                String ingredients = rs.getString("ingredients");
                int active = rs.getInt("active");

                product.add(new Product(productid, categoryid, name, desc, dateadded, allergies, dietary, price,
                        ingredients, active));
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching products from the database : " + ex.getMessage());
        }
        return product;
    }
//**************************************************************************************
    @Override
    public List<Product> getProductsByProductid() {
        List<Product> products = new ArrayList<>();
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("select productid,categoryid,name,desc,allergies,dietary,price,ingredients from product where active = 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("desc"),
                        rs.getString("allergies"),
                        rs.getString("dietary"),
                        rs.getString("ingredients"),
                        rs.getInt("categoryid"),
                        rs.getInt("productid")));
            }
        } catch (SQLException ex) {
            System.out.println("Error unable to get the products from the database : " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return products;
    }
//***********************************************************************************************************

    @Override
    public boolean updateProduct(Product product) {
        boolean rowUpdated = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("update product set name = ?,desc= ?, , allergies = ?, dietary = ?, price = ?, ingredients = ? where productid = ?");
            rs = ps.executeQuery();
            System.out.println("updated Product:" + ps);

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getAllergies());
            ps.setString(4, product.getDietary());
            ps.setInt(5, product.getPrice());
            ps.setString(6, product.getIngredients());
            ps.setInt(7, product.getProductid());

            rowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating product " + e.getMessage());
        } finally {
            closeStreams();
        }
        return rowUpdated;
    }

    //***********************************************************************************************************
    private boolean activateDeleteProduct(int productid, boolean activate) {
        boolean producDeleted = false;
        try {
            con = dbManager.getConnection();
            ps = con.prepareStatement("update product set active = ? where productid = ?");
            ps.setBoolean(1, activate);
            ps.setInt(2, productid);
            producDeleted = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error deleting/deactivating product from database " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return producDeleted;
    }

    //***********************************************************************************************************
    @Override
    public boolean activateProduct(int productid) {
        return activateDeleteProduct(productid, true);
    }
    //***********************************************************************************************************

    @Override
    public boolean deactivateProduct(int productid) {
        return activateDeleteProduct(productid, false);
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

}
