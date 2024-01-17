package za.co.teamsuccess.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.ContactUs;
import za.co.teamsuccess.service.ContactUsService;
import za.co.teamsuccess.service.impl.ContactUsServiceImpl;

@WebServlet(name = "ContactUsFormController", urlPatterns = {"/ContactUsFormController"})
public class ContactUsFormController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactUs contactUs;
        ContactUsService cs;
        response.setContentType("text/html;charset=UTF-8");
        String process = request.getParameter("pro");
        ServletContext sc = request.getServletContext();
        RequestDispatcher view = null;
        if (process != null && !process.isEmpty()) {
            cs = new ContactUsServiceImpl((DBPoolManagerBasic) sc.getAttribute("dbconn"));
            if (process.equals("ContactUs")) {
                System.out.println("a contactusform was requested");
                contactUs = new ContactUs();
                contactUs.setName(request.getParameter("name"));
                contactUs.setEmail(request.getParameter("email"));
                contactUs.setSubject(request.getParameter("subject"));
                contactUs.setMessage(request.getParameter("message"));
                if (cs.contactUs(contactUs)) {
                    System.out.println("Contact us form succesfully added");
                    view = request.getRequestDispatcher("index.jsp");

                } else {
                    System.out.println("Could not process Contact us form");
                    view = request.getRequestDispatcher("contactUs.jsp");
                }
                view.forward(request, response);
            }
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
}
