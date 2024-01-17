package za.co.teamsuccess.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.teamsuccess.dao.impl.ProductDAOImpl;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Product;
import za.co.teamsuccess.service.ProductService;
import za.co.teamsuccess.service.impl.ProductServiceImpl;

@WebServlet(name = "ProductController", urlPatterns = {"/Products"})
public class ProductController extends HttpServlet {

    private PreparedStatement ps;
    Connection con;
    private ProductDAOImpl productDAOImpl;
    private DBPoolManagerBasic dbManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext sc = request.getServletContext();
        ProductService productService = new ProductServiceImpl((DBPoolManagerBasic) sc.getAttribute("dbconn"));
        String catagory = request.getParameter("catid");
        
        
        if (catagory == null || catagory.isEmpty()) {
            //call error page of go back to index.html
        }
        int catid = 0;
        try {
            catid = Integer.parseInt(catagory);
        } catch (NumberFormatException nfe) {
        }
        List<Product> productList = productService.getProducts(catid);
        request.getSession().setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("items.jsp");
        dispatcher.forward(request, response);
        
        
        
        
     
////////////////////////////////////////////////////////////////////////////////
       
///////////////////////////////////Admin Actions/////////////////////////////////////////////        
//        String action = request.getServletPath();
//        switch (action) {
//            case "/new":
//                try {
//                showNewForm(request, response);
//            } catch (ServletException e) {
//                System.out.println("Erorr creating a new form : " + e.getMessage());
//            }
//            break;
//            case "/insert":
//                try {
//                insertProduct(request, response);
//
//            } catch (SQLException e) {
//                System.out.println("Error inserting product int dattabase : " + e.getMessage());
//            }
//            break;
//            case "/delete":
//                try {
//                deleteProduct(request, response);
//            } catch (SQLException e) {
//                System.out.println("Error deleting product for database : " + e.getMessage());
//            }
//            break;
//            case "/edit":
//                try {
//                showEditForm(request, response);
//            } catch (ServletException e) {
//                System.out.println("Error editing the product : " + e.getMessage());
//            }
//            break;
//            case "/update":
//                try {
//                updateProduct(request, response);
//            } catch (SQLException e) {
//                System.out.println("Error updating product : " + e.getMessage());
//            }
//            break;
//            default:
//                try {
//                listProduct(request, response);
//            } catch (ServletException e) {
//                System.out.println("Error listing the products : " + e.getMessage());
//            }
//            break;
//        }
//        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
///////////////////////////////////Admin Process//////////////////////////////////////////////
//    private void listProduct(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Product> listProduct = productDAOImpl.selectAllProducts();
//        request.setAttribute("listProduct", listProduct);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("items.jsp");
//        dispatcher.forward(request, response);
//    }
///////////////////////////////////////////////////////////////////////////////////
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
//        dispatcher.forward(request, response);
//    }
//////////////////////////////////////////////////////////////////////////////////    
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int productid = 0;
//        RequestDispatcher dispatcher = null;
//        try {
//            productid = Integer.parseInt(request.getParameter("productid"));
//            Product existingProduct = productDAOImpl.getProduct(productid);
//            if (existingProduct == null) {
//                request.setAttribute("errorMsg", "too Bad!!!");
//                dispatcher = request.getRequestDispatcher("Error.jsp");
//            } else {
//                request.setAttribute("product", existingProduct);
//                dispatcher = request.getRequestDispatcher("product-form.jsp");
//            }
//        } catch (NumberFormatException nfe) {
//            System.out.println("error showing edit form : " + nfe.getMessage());
//            request.setAttribute("errorMsg", "Error in the edit form!");
//            dispatcher = request.getRequestDispatcher("Error.jsp");
//        }
//        dispatcher.forward(request, response);
//    }
//////////////////////////////////////////////////////////////////////////////////
//
//    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        try {
//            int productid = Integer.parseInt(request.getParameter("productid"));
//            int categoryid = Integer.parseInt(request.getParameter("categoryid"));
//            String name = request.getParameter("name");
//            String desc = request.getParameter("desc");
//            Date dateadded = Date.valueOf(request.getParameter("dateadded"));
//            String allergies = request.getParameter("allergies");
//            String dietary = request.getParameter("dietary");
//            int price = Integer.parseInt(request.getParameter("price"));
//            String ingredients = request.getParameter("ingredients");
//            Product product = new Product(productid, categoryid, name, desc, dateadded, allergies, dietary, price, ingredients);
//            productDAOImpl.addProduct(product);
//            response.sendRedirect("list");
//        } catch (NumberFormatException nfe) {
//            System.out.println("Insert Error : " + nfe.getMessage());
//
//            response.sendRedirect("Error.jsp");
//        }
//    }
//////////////////////////////////////////////////////////////////////////////////
//
//    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//
//        ps = con.prepareStatement("update product set name = ?, category =?, desc =?,allergies = ? ,deitary = ? , price = ? ingredients = ?, where productid = ? ");
//        int productid = Integer.parseInt(request.getParameter("productid"));
//        int categoryid = Integer.parseInt(request.getParameter("categoryid"));
//        String name = request.getParameter("name");
//        String desc = request.getParameter("desc");
//        Date dateadded = Date.valueOf(request.getParameter("dateadded"));
//        String allergies = request.getParameter("allergies");
//        String dietary = request.getParameter("dietary");
//        int price = Integer.parseInt(request.getParameter("price"));
//        String ingredients = request.getParameter("ingredients");
//        Product product = new Product(productid, categoryid, name, desc, dateadded, allergies, dietary, price, ingredients);
//        if (productDAOImpl.updateProduct(product)) {
//            response.sendRedirect("list");
//        } else {
//            response.sendRedirect("Error.jsp");
//        }
//    }
//////////////////////////////////////////////////////////////////////////////////   
//
//    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int productid = 0;
//        try {
//            productid = Integer.parseInt(request.getParameter("productid"));
//        } catch (NumberFormatException nfe) {
//            System.out.println("Error deleting user : " + nfe.getMessage());
//            response.sendRedirect("Error.jsp");
//        }
//        if (productDAOImpl.deactivateProduct(productid)) {
//            response.sendRedirect("list");
//        } else {
//            response.sendRedirect("Error.jsp");
}

