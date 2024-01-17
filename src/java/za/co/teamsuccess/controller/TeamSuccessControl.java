package za.co.teamsuccess.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Person;
import za.co.teamsuccess.service.UserService;
import za.co.teamsuccess.service.impl.UserServiceImpl;

public class TeamSuccessControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserService us;
        String process = request.getParameter("pro");
        RequestDispatcher view = null;
        HttpSession session;
        Person person;
        if (process != null) {
            session = request.getSession();
            ServletContext sc = request.getServletContext();
            us = new UserServiceImpl((DBPoolManagerBasic) sc.getAttribute("dbconn"));

            //***********************************************************************************
            if (process.equals("login")) {
                person = us.getUser(request.getParameter("email"), request.getParameter("password"));
                if (us.isValid(person)) {
                    Person pers = (Person) session.getAttribute("person");
                    if (pers == null) {
                        session.setAttribute("person", person);
                        request.setAttribute("loggedin", true);
                    } else {
                        System.out.println("A user is already logged in");
                        request.setAttribute("loggedin", false);
                        request.setAttribute("msg", "User already logged in.");
                        //todo: send error message to index
                    }
                    view = request.getRequestDispatcher("index.jsp");
                } else if (!us.isValid(person)) {
                    System.out.println("User did not log");
                    view = request.getRequestDispatcher("login.jsp");
                } else {
                    System.out.println("User could not log in");
                    view = request.getRequestDispatcher("login.jsp");
                }
            }

            //***********************************************************************************
            if (process.equals("register")) {
                System.out.println("a register was requested");
                person = new Person(
                        request.getParameter("firstname"),
                        request.getParameter("lastname"),
                        request.getParameter("email"),
                        Integer.parseInt(request.getParameter("address")), ///// -------------------------- remember an error WILL happen on Monday
                        request.getParameter("password"),
                        request.getParameter("username"));
                if (us.registerPerson(person)) {
//                    System.out.println("User successfully registered");
//                    System.out.println("Is user valid " + us.isValid(person));
                    session.setAttribute("person", person);
                    view = request.getRequestDispatcher("index.jsp");
                } else {
                    System.out.println("User could not be registered");
                    view = request.getRequestDispatcher("register.jsp");
                }
            }

            //***********************************************************************************
            if (process.equals("logout")) {
                System.out.println("a logout was requested");
                session.removeAttribute("person");
                request.setAttribute("loggedin", false);
                view = request.getRequestDispatcher("index.jsp");
            }
            // ***********************************************************************************
        } else {  //no process value was received
            view = request.getRequestDispatcher("Register.jsp");
        }
        view.forward(request, response);
        //****************************************Admin Processs*********************************

///////////////////////////////Admin access/////////////////////////////////////
//        userDAOImpl = new UserDAOImpl(dbManager);
//        String action = request.getServletPath();
//        switch (action) {
//            case "/new":
//            try {
//                showNewForm(request, response);
//            } catch (ServletException ex) {
//                System.out.println("SQL exception in new: " + ex.getMessage());
//            }
//            break;
//            case "/insert":
//             try {
//                insertUser(request, response);
//            } catch (SQLException ex) {
//                System.out.println("SQL exception in insertUser: " + ex.getMessage());
//            }
//            break;
//            case "/delete":
//                 try {
//                deleteUser(request, response);
//            } catch (SQLException ex) {
//                System.out.println("SQL exception in delete: " + ex.getMessage());
//            }
//
//            break;
//            case "/edit":
//                try {
//                showEditForm(request, response);
//            } catch (SQLException ex) {
//                System.out.println("SQL exception in edit: " + ex.getMessage());
//            }
//            break;
//            case "/update":
//                 try {
//                updateUser(request, response);
//            } catch (SQLException ex) {
//                System.out.println("SQL exception in edit: " + ex.getMessage());
//            }
//            break;
//            default:
//                try {
//                listUser(request, response);
//            } catch (SQLException ex) {
//                System.out.println("SQL exception in listUser: " + ex.getMessage());
//            }
//            break;
//        }
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

//    ///////////////////////////////////////////////////////////////////////////////
//     private void listUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<Person> listUser = userDAOImpl.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//        dispatcher.forward(request, response);
//    }
//////////////////////////////////////////////////////////////////////////////////////
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int personid = 0;
//        RequestDispatcher dispatcher = null;
//        try {
//            personid = Integer.parseInt(request.getParameter("personid"));
//            Person existingUser = userDAOImpl.selectUser(personid);
//            if (existingUser == null) {
//                request.setAttribute("errorMsg", "Too Nice!!");
//                dispatcher = request.getRequestDispatcher("Error.jsp");
//            } else {
//                request.setAttribute("user", existingUser);
//                dispatcher = request.getRequestDispatcher("user-form.jsp");
//            }
//        } catch (NumberFormatException nfe) {
//            System.out.println("Edit Error: " + nfe.getMessage());
//            request.setAttribute("errorMsg", "Aaaaaaaaaah Sir!!");
//            dispatcher = request.getRequestDispatcher("Error.jsp");
//        }
//        dispatcher.forward(request, response);
//    }
///////////////////////////////////////////////////////////////////////////////////
//    private void insertUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        try {
//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            String password = request.getParameter("password");
//            String email = request.getParameter("email");
//            int role = Integer.parseInt(request.getParameter("role"));
//            Person newUser = new Person(firstName, lastName, email, password, role);
//            userDAOImpl.insertUser(newUser);
//            response.sendRedirect("list");
//        } catch (NumberFormatException nfe) {
//            System.out.println("Insert Error : " + nfe.getMessage());
//
//            response.sendRedirect("Error.jsp");
//        }
//    }
//////////////////////////////////////////////////////////////////////////////////
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        ps = con.prepareStatement("update users set name = ?,email= ?, country =? where id = ?");
//        int id = Integer.parseInt(request.getParameter("personid"));
//        String firstName = request.getParameter("firstname");
//        String lastName = request.getParameter("lastname");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//        int role = Integer.parseInt(request.getParameter("role"));
//        Person newUser = new Person(id, firstName, lastName, email, password, role);
//        if (userDAOImpl.updateUser(newUser)) {
//            response.sendRedirect("list");
//        } else {
//            response.sendRedirect("Error.jsp");
//        }
//    }
//////////////////////////////////////////////////////////////////////////////////
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = 0;
//        try {
//            id = Integer.parseInt(request.getParameter("id"));
//        } catch (NumberFormatException nfe) {
//            System.out.println("Error: " + nfe.getMessage());
//            response.sendRedirect("Error.jsp");
//        }
//        if (userDAOImpl.deleteUser(id)) {
//            response.sendRedirect("list");
//        } else {
//            response.sendRedirect("Error.jsp");
//        }
//////////////////////////////////////////////////////////////////////////////////
    @Override
    public String getServletInfo() {
        return "Team Success Controller";
    }// </editor-fold>
}
