<%-- 
    Document   : error
    Created on : Jan 27, 2022, 11:18:37 AM
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
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <title>ERROR</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="login.jsp">MRS PAT CAKE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!--                    <ul class="navbar-nav m-auto mb-2 mb-lg-0">
                                            <li class="nav-item">
                                                <a class="nav-link" href="index.jsp">HOME</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="products.jsp">PRODUCTS</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">SPECIALS</a>
                                            </li>
                                            <li class="nav-item dropdown">
                                                <a class="nav-link" href="ourStory.jsp">
                                                    OUR STORY
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="contactUs.jsp">CONTACT</a>
                                            </li>
                                        </ul>-->
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
                        <h1 class="font-weight-bold py-3">Sorry!</h1>
                        <h4>User Does Not Exist</h4>
                        <p>Click <a href="login.jsp">here</a> to try again.</p>
                        <p>Don't have an account? <a href="register.jsp">Register here.</a></p>
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
