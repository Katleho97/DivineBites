<%-- 
    Document   : Error
    Created on : 26 Jan 2022, 9:22:55 AM
    Author     : Student07
--%>

<%@page import="za.co.teamsuccess.pojo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Error</title>
    </head>
    <body>
        <center>
            <h1>Error</h1>
            <h2>The Error: <%= request.getAttribute("errorMsg")%><br/> </h2>
        </center>	
    </body>
    <footer>
        <section class="footer pt-5">
            <div class="conteiner-fluid pt-5">
                <div class="rowa py-5">
                    <div class="col-lg-10 m-auto">
                        <div class="rowa pb-4">
                            <div class="col-lg-3">
                                <h3 class="py-5">QUICK LINKS</h3>
                                <p class="link" onclick="document.location.href = 'index.jsp'">Product Categories</p>
                                <p class="link" onclick="document.location.href = 'ourStory.jsp'">Our Story</p>
                                <p class="link" onclick="document.location.href = 'contactUs.jsp'">Contact Us</p>
                                <%Person person = (Person) session.getAttribute("person");
                                    if (person == null) {%>
                                <p class="link" onclick="document.location.href = 'login.jsp'">Login/Register</p>  
                                <%}
                                %>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section> 
    </footer>
</html>
