<%-- 
    Document   : register
    Created on : Jan 17, 2022, 10:37:39 AM
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
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <script src="https://kit.fontawesome.com/16fb45d544.js" crossorigin="anonymous"></script>
        <title>Mrs Pat Cake</title>
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


        <section class="form my-4 mx-5">
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-lg-5">
                        <img src="assets/logo.JPG" class="img-fluid" alt="">
                    </div>
                    <div class="col-lg-7 px-5 pt-5">
                        <h1 class="font-weight-bold py-3">Register</h1>
                        <h4>Register a new account</h4>
                        <form form name="register" method="get" action="http://localhost:8080/TeamSuccessV1/TeamSuccessControl">
                            <input type="hidden" name="pro" value="register">
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <input type="text" name="username" placeholder="Username" class="form-control my-3 p-4" required>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <input type="text" name="firstname" placeholder="First Name" class="form-control my-3 p-4" required>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <input type="text" name="lastname" placeholder="Last Name" class="form-control my-3 p-4" required>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <input type="text" name="cellphonenumber" placeholder="Cellphone Number" class="form-control my-3 p-4" required>
                                </div>
                            </div>
                            <!--                            <div class="form-row">
                                                            <div class="col-lg-7">
                                                                <label for="list">Title</label>
                                                                <select id="list" name="title">
                                                                    <option value="Mr">Mr</option>
                                                                    <option value="Mr">Mrs</option>
                                                                    <option value="Mr">Ms</option>
                                                                    <option value="Mr">Dr</option>
                                                                    <option value="Mr">Professor</option>
                                                                </select>
                                                            </div>
                                                        </div>-->
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <input type="email" name="email" placeholder="Email Address" class="form-control my-3 p-4" required>
                                </div>
                            </div>
                            <!-- <div class="form-row">
                                                            <div class="col-lg-7">
                                                                <input type="number" name="cellPhoneNumber" placeholder="Cell Phone Number" class="form-control my-3 p-4">
                                                            </div>
                                                        </div>-->
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <input id="password" type="password" name="password" placeholder="Password" class="form-control my-3 p-4" required>

                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <input id="ConfirmPassword" type="password" name="ConfirmPassword" placeholder="Confirm Password" class="form-control my-3 p-4" required>
                                    <p id="message"></p>

                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-lg-7">
                                    <button type="submit" class="btnRegister mt-3 mb-5" onclick="checkPassword()">Register</button>

                                    <script>
                                        function checkPassword() {
                                            let password = document.getElementById("password").value;
                                            let ConfirmPassword = document.getElementById("ConfirmPassword").value;
                                            console.log((password, ConfirmPassword));
                                            let message = document.getElementById("message");

                                            if (password.length !== 0) {
                                                if (password === ConfirmPassword) {

                                                } else {
                                                    message.textContent = "Password does not match!";
                                                    message.style = "#ff4d4d";
                                                }
                                            }
                                        }
                                    </script>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </section>
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
