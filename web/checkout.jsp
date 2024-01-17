<%-- 
    Document   : checkout
    Created on : Feb 1, 2022, 12:47:57 PM
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
        <title>Payment</title>
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
                    <div class="col-lg-7 px-5 pt-5 mb-5">
                        <h1 class="font-weight-bold py-3">Select Payment Method</h1>


                        <div style="display: flex;
                             align-items: center;
                             justify-content: center;">
                            <input checked="checked" type="radio" name="payment" id="card">
                            <label for="card">
                                <i class="fa fa-credit-card" aria-hidden="true"></i>
                                <span>Card</span>
                            </label>
                            <input type="radio" name="payment" id="paypal" onclick="paypal()">
                            <label for="paypal">
                                <i aria-hidden="true" class="fab fa-paypal"></i>
                                <span>PayPal</span>
                            </label>
                        </div>


                        <div class="conts">
                            <div class="card-conts">
                                <div class="front">
                                    <div class="imgs">
                                        <img src="assets/chip.png" alt="">
                                        <img src="assets/pngegg.png" alt="">
                                    </div>
                                    <div class="card-number-box">################</div>
                                    <div class="flexBow">
                                        <div class="box">
                                            <span>CARD HOLDER</span>
                                            <div class="card-holder-name">FULL NAME</div>
                                        </div>
                                        <div class="box">
                                            <span>EXPIRES</span>
                                            <div class="expiration">
                                                <span class="exp-month">MM</span>
                                                <span class="exp-year">YY</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="back">
                                    <div class="stripe"></div>
                                    <div class="box">
                                        <span>CVV</span>
                                        <div class="cvv-box"></div>
                                        <img src="assets/pngegg.png" alt="">
                                    </div>
                                </div>
                            </div>
                            <form method="get" action="http://localhost:8080/TeamSuccessV1/CheckoutController">
                                <input type="hidden" name="pro" value="checkout">
                                <div class="inputBow">
                                    <span>CARD NUMBER</span>
                                    <input style="outline: none;
                                           border: none;
                                           text-decoration: none;
                                           text-transform: uppercase;
                                           border-radius: 10px;
                                           border: 1px solid rgba(0,0,0,.3);
                                           color: black;"
                                           type="text" maxlength="16" class="card-number-input" name="creditcardno">
                                </div>
                                <div class="inputBow">
                                    <span>CARD HOLDER</span>
                                    <input style="outline: none;
                                           border: none;
                                           text-decoration: none;
                                           text-transform: uppercase;
                                           border-radius: 10px;
                                           border: 1px solid rgba(0,0,0,.3);
                                           color: black;"
                                           type="text" class="card-holder-input" name="cardholder">
                                </div>
                                <div class="flexBow">
                                    <div class="inputBow">
                                        <span>EXPIRATION MM</span>
                                        <select style="outline: none;
                                                border: none;
                                                text-decoration: none;
                                                text-transform: uppercase;
                                                border-radius: 10px;
                                                border: 1px solid rgba(0,0,0,.3);
                                                color: black;"
                                                name="" id="" class="month-input">
                                            <option value="month" selected disabled>MONTH</option>
                                            <option value="01">01</option>
                                            <option value="02">02</option>
                                            <option value="03">03</option>
                                            <option value="04">04</option>
                                            <option value="05">05</option>
                                            <option value="06">06</option>
                                            <option value="07">07</option>
                                            <option value="08">08</option>
                                            <option value="09">09</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                        </select>
                                    </div>
                                    <div class="inputBow">
                                        <span>EXPIRATION YY</span>
                                        <select style="outline: none;
                                                border: none;
                                                text-decoration: none;
                                                text-transform: uppercase;
                                                border-radius: 10px;
                                                border: 1px solid rgba(0,0,0,.3);
                                                color: black;"
                                                name="" id="" class="year-input">
                                            <option value="year" selected disabled>YEAR</option>
                                            <option value="2022">2022</option>
                                            <option value="2023">2023</option>
                                            <option value="2024">2024</option>
                                            <option value="2025">2025</option>
                                            <option value="2026">2026</option>
                                            <option value="2027">2027</option>
                                            <option value="2028">2028</option>
                                            <option value="2029">2029</option>
                                            <option value="2030">2030</option>
                                            <option value="2031">2031</option>
                                        </select>
                                    </div>
                                    <div class="inputBow">
                                        <span>CVC</span>
                                        <input style="outline: none;
                                               border: none;
                                               text-decoration: none;
                                               text-transform: uppercase;
                                               border-radius: 10px;
                                               border: 1px solid rgba(0,0,0,.3);
                                               color: black;"
                                               type="text" maxlength="3" class="cvv-input" name="cvc">
                                    </div>
                                </div>
                                <button type="submit" class="btnLogin mt-4 mb-10">Submit</button>
                            </form>
                        </div>
                        <style>
                            input[type="radio"]{
                                -webkit-appearance:none;
                            }
                            label{
                                height: 50px;
                                width: 60px;
                                border:1px solid #000;
                                position: relative;
                                margin: auto;
                                border-radius: 10px;
                                color: #DEDEDE;
                                transition: 0.5s;
                                margin-bottom: 60px;
                            }
                            .fa{
                                font-size: 20px;
                                position: absolute;
                                top:50%;
                                left: 50%;
                                transform: translate(-50%,-80%);
                            }
                            .fab{
                                font-size: 20px;
                                position: absolute;
                                top:50%;
                                left: 50%;
                                transform: translate(-50%,-80%);
                            }
                            label>span{
                                font-size: 18px;
                                position: absolute;
                                top:50%;
                                left: 50%;
                                transform: translate(-50%,80%);
                                font-weight: 500;
                            }
                            input[type="radio"]:checked + label{
                                background-color: #898989;
                                color: #000;
                                box-shadow: 0 15px 45px rgba(24,249,141,0.2);
                            }






                            .conts{
                                background: #eee;
                                display: flex;
                                align-items: center;
                                justify-content: center;
                                flex-flow: column;
                                padding-bottom: 60px;
                                padding-top: 60px;
                            }
                            .conts form{
                                background: #fff;
                                border-radius: 5px;
                                box-shadow: 0 10px 15px rgba(0,0,0,.1);
                                padding: 20px;
                                width: 600px;
                                padding-top: 160px;
                            }
                            .conts form .inputBow{
                                margin-top: 20px;
                            }
                            .conts form .inputBow span{
                                display: block;
                                color: #999;
                                padding-bottom: 5px;
                            }
                            .conts form .inputBow input,
                            .conts form .inputBow select{
                                width: 100%;
                                padding: 10px;
                            }
                            .conts form .flexBow{
                                display: flex;
                                gap: 15px;
                            }
                            .conts form .flexBow .inputBow{
                                flex: 1 1 150px;
                            }
                            .conts .card-conts{
                                margin-bottom: -150px;
                                position: relative;
                                height: 250px;
                                width: 400px;
                            }
                            .conts .card-conts .front{
                                position: absolute;
                                height: 100%;
                                width: 100%;
                                top: 0;
                                left: 0;
                                background: linear-gradient(45deg, #DEDEDE, #898989);
                                border-radius: 5px;
                                backface-visibility: hidden;
                                box-shadow: 0 15px 25px rgba(0,0,0,.2);
                                padding: 20px;
                                transform: perspective(1000px) rotateY(0deg);
                                transition: transform 4s ease-out;
                            }
                            .conts .card-conts .front .imgs{
                                display: flex;
                                align-items: center;
                                justify-content: space-between;
                                padding-top: 10px;
                            }
                            .conts .card-conts .front .imgs img{
                                height: 50px;
                            }
                            .conts .card-conts .front .card-number-box{
                                padding: 30px 0;
                                font-size: 22px;
                                color: #fff;
                            }
                            .conts .card-conts .front .flexBow{
                                display: flex;
                            }
                            .conts .card-conts .front .flexBow .box:nth-child(1){
                                margin-right: auto;
                            }
                            .conts .card-conts .front .flexBow .box{
                                font-size: 15px;
                                color: #fff;
                            }
                            .conts .card-conts .back{
                                position: absolute;
                                top: 0;
                                left: 0;
                                height: 100%;
                                width: 100%;
                                background: linear-gradient(45deg, #DEDEDE, #898989);
                                border-radius: 5px;
                                padding: 20px 0;
                                text-align: right;
                                backface-visibility: hidden;
                                box-shadow: 0 15px 25px rgba(0,0,0,.2);
                                transform: perspective(1000px) rotateY(180deg);
                                transition: transform 4s ease-out;
                            }
                            .conts .card-conts .back .stripe{
                                background: #000;
                                width: 100%;
                                margin: 10px 0;
                                height: 50px;
                            }
                            .conts .card-conts .back .box{
                                padding: 0 20px;
                            }
                            .conts .card-conts .back .box span{
                                color: #fff;
                                font-size: 15px;
                            }
                            .conts .card-conts .back .box .cvv-box{
                                height: 50px;
                                padding: 10px;
                                margin-top: 5px;
                                color: #333;
                                background: #fff;
                                border-radius: 5px;
                                width: 100%;
                            }
                            .conts .card-conts .back .box img{
                                margin-top: 30px;
                                height: 30px;
                            }
                        </style>
                        <script>
                            function paypal() {
                                window.location.href = "https://www.paypal.com/error";
                            }


                            document.querySelector('.card-number-input').oninput = () => {
                                document.querySelector('.card-number-box').innerText = document.querySelector('.card-number-input').value;
                            };

                            document.querySelector('.card-holder-input').oninput = () => {
                                document.querySelector('.card-holder-name').innerText = document.querySelector('.card-holder-input').value;
                            };

                            document.querySelector('.month-input').oninput = () => {
                                document.querySelector('.exp-month').innerText = document.querySelector('.month-input').value;
                            };

                            document.querySelector('.year-input').oninput = () => {
                                document.querySelector('.exp-year').innerText = document.querySelector('.year-input').value;
                            };

                            document.querySelector('.cvv-input').onmouseenter = () => {
                                document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(-180deg)';
                                document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(0deg)';
                            };

                            document.querySelector('.cvv-input').onmouseleave = () => {
                                document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(0deg)';
                                document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(180deg)';
                            };

                            document.querySelector('.cvv-input').oninput = () => {
                                document.querySelector('.cvv-box').innerText = document.querySelector('.cvv-input').value;
                            };

                        </script>
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
