<%-- 
    Document   : BakedCupcakes
    Created on : Jan 21, 2022, 10:43:51 AM
    Author     : student07
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.co.teamsuccess.pojo.Product"%>
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
        <script src='https://code.jquery.com/jquery-3.4.1.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'></script>
        <script  src="./script.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Rubik+Beastly&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="style.css"/>
        <script src="https://kit.fontawesome.com/16fb45d544.js" crossorigin="anonymous"></script>
        <title>Baked Cupcakes</title>
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


        <% List<Product> productList = (ArrayList<Product>) session.getAttribute("productList"); %>
        <section class="category py-5">
            <div class="container-fluid py-5 text-center">
                <h1 style="font-family: 'Krona One', sans-serif;">SELECT DESIRED ITEM</h1>
                <div class="row1 py-5">
                    <div class="col-lg-11 m-auto pt-3">

                        <div class="row py-5">
                            <%   if (productList != null) {
                                    for (Product product : productList) {
                            %>
                            <div class="col-lg-3"> 
                                <div class="card py-3">
                                    <div class="card-body">
                                        <form method="get" action="http://localhost:8080/TeamSuccessV1/OrderController">
                                            <input type="hidden" name="pro" value="add">
                                            <input type="hidden" name="id" value="<%=product.getProductid()%>">

                                            <img src=<%=product.getPicture()%> class="img-fluid my-3" alt="">
                                            <h6><%=product.getName()%></h6>
                                            <h6>R <%=product.getPrice()%></h6>

                                            <label for="updateC">Quantity</label>
                                            <table style="width: 100%;">
                                                <td class="button-container">
                                                    <button class="cart-qty-minus" type="button" value="-">-</button>
                                                    <input style="align-self: center" type="number" name="qty" min="1" max="10" class="qty form-control" value="1"/>
                                                    <button class="cart-qty-plus" type="button" value="+">+</button>
                                                </td>
                                            </table>
                                            <table style="width: 100%;">
                                                <td>
                                                    <button style="width: 80%;"
                                                            type="button" 
                                                            class="btnRegister mt-3"
                                                            onclick="document.location.href = 'ItemController?itemid=<%=product.getProductid()%>'">

                                                        Details

                                                        <i class="fas fa-info-circle mx-2">
                                                        </i>
                                                    </button> 
                                                </td>
                                                <td>

                                                    <button style="width: 80%;" 
                                                            type="submit" 
                                                            class="btnRegister mt-3">

                                                        Add To Cart
                                                        <i class="fas fa-shopping-cart mx-2" >
                                                        </i>
                                                    </button>

                                                </td>
                                            </table>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <%}
                                }%>
                        </div>
                    </div> 
                </div>
            </div>
        </section>

        <!-- >>>>>>>>>>>>>>>>>>>>>>>>>> footer Section <<<<<<<<<<<<<<<<<<<<<<<<<<< -->
        <script>
            //----------------for quantity-increment-or-decrement-------
            var incrementQty;
            var decrementQty;
            var plusBtn = $(".cart-qty-plus");
            var minusBtn = $(".cart-qty-minus");
            var incrementQty = plusBtn.click(function () {
                var $n = $(this)
                        .parent(".button-container")
                        .find(".qty");
                if (Number($n.val()) <= 9) {
                    $n.val(Number($n.val()) + 1);
                    update_amounts();
                }

            });

            var decrementQty = minusBtn.click(function () {
                var $n = $(this)
                        .parent(".button-container")
                        .find(".qty");
                var QtyVal = Number($n.val());
                if (QtyVal > 1) {
                    $n.val(QtyVal - 1);
                }
                update_amounts();
            });
        </script>
        <style>
            .button-container .form-control{
                max-width: 80px;
                text-align: center;
                display: inline-block;
                margin: 0px 5px;
            }
            .cart-qty-plus,
            .cart-qty-minus{
                width: 38px;
                height: 38px;
                background-color: #D0D0D0;
                border: 1px solid #ADADAD;
                border-radius: .25rem;
            }
            .cart-qty-plus:hover,
            .cart-qty-minus:hover{
                background-color: #ADADAD;
            }
            .cart-qty-plus{
                background-color: #E4E4E4;
                font-weight: 600;
            }
            .cart-qty-minus{
                background-color: #E4E4E4;
                font-weight: 600;
            }
        </style>



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
