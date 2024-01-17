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
import za.co.teamsuccess.pojo.PaymentCard;
import za.co.teamsuccess.pojo.Person;
import za.co.teamsuccess.service.CheckoutService;
import za.co.teamsuccess.service.impl.CheckoutServiceImpl;

@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CheckoutService checkoutService;
        response.setContentType("text/html;charset=UTF-8");
        String process = request.getParameter("pro");
        ServletContext sc = request.getServletContext();
        RequestDispatcher view = null;
        if (process != null && !process.isEmpty()) {
            checkoutService = new CheckoutServiceImpl((DBPoolManagerBasic) sc.getAttribute("dbconn"));
            if (process.equals("checkout")) {
                if (checkoutService.checkout(
                        new PaymentCard(request.getParameter("creditcardno"), request.getParameter("cardholder"), request.getParameter("cvc")),
                        (Person) request.getSession().getAttribute("person"),
                        (ArrayList) request.getSession().getAttribute("cart"))) {
                    view = request.getRequestDispatcher("index.jsp");
                }
            } else {
                view = request.getRequestDispatcher("error.jsp");
            }
            view.forward(request, response);
        }
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
