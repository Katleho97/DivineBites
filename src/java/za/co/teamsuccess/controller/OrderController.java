
package za.co.teamsuccess.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.CartItem;
import za.co.teamsuccess.pojo.Product;
import za.co.teamsuccess.service.OrderService;
import za.co.teamsuccess.service.impl.OrderServiceImpl;

/**
 *
 * @author Student07
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String process = request.getParameter("pro");
        response.setContentType("text/html;charset=UTF-8");
        ServletContext sc = request.getServletContext();
        ArrayList<CartItem> cart;
        RequestDispatcher view = null;
        if (process != null && !process.isEmpty()) {

            OrderService orderService = new OrderServiceImpl((DBPoolManagerBasic) sc.getAttribute("dbconn"));

            if (process.equals("add")) {
                System.out.println("added to cart");
                int idNum = 0;
                try{
                    idNum = Integer.parseInt(request.getParameter("id"));
                }catch(NumberFormatException nfe){
                    System.out.println("Error adding to cart : " + nfe.getMessage());
                }
                Product product = orderService.add(idNum);
                cart = (ArrayList<CartItem>) request.getSession().getAttribute("cart");
                if (cart == null) {
//                   
                    cart = new ArrayList<>();
                    request.getSession().setAttribute("cart", cart);
                }
                int qty = 1;
                try {
                    qty = Integer.parseInt(request.getParameter("qty"));
                } catch (NumberFormatException nfe) {
                    System.out.println("Error adding to cart : " + nfe.getMessage());
                }
                if (qty > 0 && product != null) {
                    boolean added = false;
                    for (CartItem item : cart) {
                        if (item.getProduct().getProductid() == idNum) {
                            item.setQuantity(item.getQuantity() + qty);
                            added = true;
                            break;
                        }
                    }
                    if (!added) {
                        cart.add(new CartItem(qty, product));
                    }
                }
                view = request.getRequestDispatcher("items.jsp");

            }
            view.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
