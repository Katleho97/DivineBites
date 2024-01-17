<%-- 
    Document   : ourStory
    Created on : Jan 19, 2022, 9:44:37 AM
    Author     : student07
--%>

<%@page import="za.co.teamsuccess.pojo.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik+Beastly&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="style.css"/>
        <script src="https://kit.fontawesome.com/16fb45d544.js" crossorigin="anonymous"></script>
        <title>Our Story</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">MRS PAT CAKE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav m-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">HOME</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link" href="ourStory.jsp">
                                OUR STORY
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contactUs.jsp">CONTACT</a>
                        </li>
                    </ul>
                    <table>
                        <tr>
                            <%
                                String theName = "Guest";
                                Person person = (Person) session.getAttribute("person");
                                if (person != null) {
                                    String name[] = person.getEmail().split("@");
                                    theName = name[0].toUpperCase();
                                }
                            %>

                            <%= theName%>
                        </tr>
                        <tr>
                        <button style="background-color: transparent; 
                                color: black; 
                                border: none; 
                                outline: none" 
                                type="button" 
                                class="btnCart">
                            <i class="fas fa-shopping-cart mx-2" onclick="Cart()"></i>

                            <script>
                                function Cart() {
                                    document.location.href = "cart.jsp";
                                }
                            </script>
                            </tr>
                            <tr>
                            <form class="cart">
                                <% if (person == null) { %>
                                <i class="fas fa-sign-in-alt mx-2" onclick="btnClicked()"></i>
                                <script>
                                    function btnClicked() {
                                        document.location.href = "login.jsp";
                                    }
                                </script>
                                <% } %>
                        </button>
                        </form>
                        </tr>
                        <tr>
                            <% if (person != null) { %>
                        <form class="logout" form name="logout" method="get" action="http://localhost:8080/TeamSuccessV1/TeamSuccessControl">
                            <input type="hidden" name="pro" value="logout">
                            <button style="background-color: transparent; 
                                    color: black; 
                                    border: none; 
                                    outline: none" 
                                    class="btnLoout" type="submit">
                                <i class="fas fa-sign-out-alt mx-2"></i>
                            </button>
                        </form>
                        <%}%>
                        </tr>
                    </table>


                </div>
            </div>
        </nav>
        <img class="slg" width="100%" src="assets/ourstory.png">
        <!-- >>>>>>>>>>>>>>>>>>>>>>>>>> Category Section <<<<<<<<<<<<<<<<<<<<<<<<<<< -->


        <section class="category py-5">
            <div class="container-fluid py-5 text-center">
                <h4 style="font-family: 'Krona One', sans-serif;">ESTABLISHED IN 2022</h4>
                <p style="font-family: 'Krona One', sans-serif;">For four (4) weeks we have been mastering our art and serving customers delicious and authentic bakery products.</p>
                <p style="font-family: 'Krona One', sans-serif;">We have a wide variety of freshly baked and ready-to-bake frozen bakery products.</p>
                <p style="font-family: 'Krona One', sans-serif;">Place an order online for delivery or collection. Products purchased are frozen unless stated otherwise.</p>
                <p style="font-family: 'Krona One', sans-serif;">All frozen products sold by Mrs Pat Cake® have been manufactured under the highest food safety standards in the world.</p>
            </div>
        </section>


        <!-- >>>>>>>>>>>>>>>>>>>>>>>>>> footer Section <<<<<<<<<<<<<<<<<<<<<<<<<<< -->



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
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
                                <%if (person == null) {%>
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
