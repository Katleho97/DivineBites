<%-- 
    Document   : cart
    Created on : Jan 24, 2022, 9:38:24 AM
    Author     : student07
--%>

<%@page import="za.co.teamsuccess.pojo.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.co.teamsuccess.pojo.Product"%>
<%@page import="java.util.List"%>
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
        <title>Cart</title>
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


        <!-- >>>>>>>>>>>>>>>>>>>>>>>>>> Section <<<<<<<<<<<<<<<<<<<<<<<<<<< -->

        <% List<CartItem> cartList = (ArrayList<CartItem>) session.getAttribute("cart"); %>
        <section class="form my-4 mx-5">
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-lg-5">
                        <img src="assets/logo.JPG" class="img-fluid" alt="">
                    </div>
                    <div class="col-lg-7 px-5 pt-5">
                        <h1 class="font-weight-bold py-3" style="text-align: center;">SHOPPING CART</h1>
                        <div style="margin: 80px auto; margin-top: 0px">

                            <table id="myTable" class="table">
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Name</th>
                                        <th>Qty</th>
                                        <th>Price</th>
                                        <th class="text-right">
                                            <span style="float: right" id="amount" class="amount">Amount</span>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% if (cartList != null) {

                                            for (CartItem cartItem : cartList) {
                                    %>
                                    <tr>



                                        <td>
                                            <div class="product-img">
                                                <div class="img-prdct">

                                                    <img src="<%=cartItem.getProduct().getPicture()%>" class="img-prdct">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <p><%=cartItem.getProduct().getName()%></p>
                                            <i class="fas fa-trash" onclick="document.location.href = 'RemoveFromCartController?productid=<%=cartItem.getProduct().getProductid()%>'"> Remove</i>
                                        </td>
                                        <td>
                                            <div class="button-container">
                                                <input type="number" name="qty" min="1" max="10" class="qty form-control" value="<%=cartItem.getQuantity()%>"/>

                                            </div>
                                        </td>
                                        <td>
                                            <input type="text" value="<%=cartItem.getProduct().getPrice()%>" class="price form-control" disabled>
                                        </td>
                                        <td align="right">R <span id="amount" class="amount">0</span>
                                        </td>
                                    </tr>
                                    <%}
                                        }%>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <td colspan="4"></td>
                                        <td align="right">
                                            <strong>TOTAL = R <span id="total" class="total">0</span>
                                            </strong>
                                        </td>
                                    </tr>

                                </tfoot>

                            </table>
                            <%if (person != null) {
                                    if (cartList != null) {%>
                            <a href="checkoutDetails.jsp"><button type="submit" class="btnRegister mb-3">Checkout Details</button></a>
                            <%} else {%>
                            <p>Your Cart Is Currently Empty.</p>
                            <a href="index.jsp"><button type="submit" class="btnRegister mb-3">Continue Sopping</button></a>
                            <%}
                                }%>

                            <script>
                                $(document).ready(function () {
                                    update_amounts();
                                    $('.qty, .price').on('keyup keypress blur change', function (e) {
                                        update_amounts();
                                    });
                                });

                                function update_amounts() {
                                    var sum = 0.0;
                                    $('#myTable > tbody  > tr').each(function () {
                                        var qty = $(this).find('.qty').val();
                                        var price = $(this).find('.price').val();
                                        var amount = (qty * price);
                                        sum += amount;
                                        $(this).find('.amount').text('' + amount);
                                    });
                                    $('.total').text(sum);
                                }
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
                                    if (QtyVal > 0) {
                                        $n.val(QtyVal - 1);
                                    }
                                    update_amounts();
                                });
                            </script>
                            <style>
                                .form-control:disabled, .form-control[readonly]{
                                    background-color: #fff;
                                }
                                .table tr,
                                .table tr td{
                                    vertical-align: middle;
                                }
                                .button-container{
                                    display: flex;
                                    align-items: center;
                                }
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
                                    background-color: #fff;
                                    border: 1px solid #ced4da;
                                    border-radius: .25rem;
                                }
                                .cart-qty-plus:hover,
                                .cart-qty-minus:hover{
                                    background-color: #5161ce;
                                    color: #fff;
                                }
                                .img-prdct{
                                    width: 75px;
                                    height: 50px;
                                    background-color: #5161ce;
                                    border-radius: 4px;
                                }
                                .img-prdct img{
                                    width: 100%;
                                }

                                thead tr{
                                    background-color: #F3F3F3;
                                }
                                .img-prdct{
                                    width:115px !important;
                                    height:100px !important;
                                }
                                .cart-qty-plus{
                                    background-color:#00a5e8;
                                    color:white;
                                    font-weight: 600;
                                }
                                .cart-qty-minus{
                                    background-color:#00a5e8;
                                    color:white;
                                    font-weight: 600;
                                }
                            </style>
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
