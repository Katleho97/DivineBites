<%-- 
    Document   : index
    Created on : Jan 14, 2022, 9:40:27 AM
    Author     : student07
--%>

<%@page import="za.co.teamsuccess.pojo.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik+Beastly&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="style.css"/>
        <script src="https://kit.fontawesome.com/16fb45d544.js" crossorigin="anonymous"></script>

        <title>Welcome </title>
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


        <!-- >>>>>>>>>>>>>>>>>>>>>>>>>> Category Section <<<<<<<<<<<<<<<<<<<<<<<<<<< -->


        <section class="category py-5">
            <div class="container-fluid py-5 text-center">
                <h1 style="font-family: 'Krona One', sans-serif;">BROWSE TOP CATEGORIES</h1>
                <div class="row1 py-5">
                    <div class="col-lg-11 m-auto pt-3">
                        <div class="row py-5">
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="BakedCupcakes()">
                                        <img src="assets/Cupcakes.jpg" class="img-fluid my-3" alt="">
                                        <h6>Baked Cupcakes</h6>
                                    </div>
                                    <script>

                                        function BakedCupcakes() {
                                            document.location.href = "Products?catid=1";
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="FreshlyBaked()">
                                        <img src="assets/freshlybaked.jpg" class="img-fluid my-3" alt="">
                                        <h6>Freshly Baked</h6>
                                    </div>
                                    <script>
                                        function FreshlyBaked() {
                                            document.location.href = "Products?catid=5";
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="cookies()">
                                        <img src="assets/CHOCOLATE.jpg" class="img-fluid my-3" alt="">
                                        <h6>Cookies</h6>
                                    </div>
                                    <script>
                                        function cookies() {
                                            document.location.href = "Products?catid=2";
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="boxedDeals()">
                                        <img src="assets/Gingerbread.jpg" class="img-fluid my-3" alt="">
                                        <h6>Box Deals</h6>
                                    </div>
                                    <script>
                                        function boxedDeals() {
                                            document.location.href = "Products?catid=3";
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="CelebrationCakes()">
                                        <img src="assets/CELEBRATION.jpg" class="img-fluid my-3" alt="">
                                        <h6>Celebration Cakes</h6>
                                    </div>
                                    <script>
                                        function CelebrationCakes() {
                                            document.location.href = "Products?catid=4";
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="Milk()">
                                        <img src="assets/milk.jpg" class="img-fluid my-3" alt="">
                                        <h6>Milk</h6>
                                    </div>
                                    <script>
                                        function Milk() {
                                            document.location.href = "Products?catid=6";
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="iceCream()">
                                        <img src="assets/icecreamcake.jpg" class="img-fluid my-3" alt="">
                                        <h6>Ice-Cream Cake</h6>
                                    </div>
                                    <script>
                                        function iceCream() {
                                            document.location.href = "Products?catid=7";
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="card py-3">
                                    <div class="card-body" onclick="Muffin()">
                                        <img src="assets/Muffin.jpg" class="img-fluid my-3" alt="">
                                        <h6>Muffins</h6>
                                    </div>
                                    <script>
                                        function Muffin() {
                                            document.location.href = "Products?catid=8";
                                        }
                                    </script>
                                </div>
                            </div>
                        </div> 
                    </div>
                </div>
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
                                <p class="link" onclick="document.location.href='index.jsp'">Product Categories</p>
                                <p class="link" onclick="document.location.href='ourStory.jsp'">Our Story</p>
                                <p class="link" onclick="document.location.href='contactUs.jsp'">Contact Us</p>
                                <%if (person == null) {%>
                                <p class="link" onclick="document.location.href='login.jsp'">Login/Register</p>  
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
