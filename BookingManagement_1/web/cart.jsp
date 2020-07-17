<%-- 
    Document   : cart
    Created on : Jul 9, 2020, 8:59:21 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Fashi Template">
        <meta name="keywords" content="Fashi, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cart</title>


        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/themify-icons.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body>
        <%@include file="header.jsp" %>
        <c:if test="${sessionScope.USER==null || sessionScope.USER.role.roleID==0}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <!-- Shopping Cart Section Begin -->
        <section class="shopping-cart spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="cart-table">
                            <c:if test="${empty sessionScope.CART.allItems}">
                                <h3 class="text-danger text-center">
                                    You have no book in cart!
                                </h3>
                            </c:if>
                            <c:if test="${not empty sessionScope.CART.allItems}">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Image</th>
                                            <th class="p-name">Product Name</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                            <th>Delete</th>
                                            <th>Update</th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach var="item" items="${sessionScope.CART.allItems}">
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="bookID" value="${item.book.bookID}"/>
                                            <tr>
                                                <td class="cart-pic first-row"><img src="${item.book.image}" alt="" style="width: 60%"></td>
                                                <td class="cart-title first-row">
                                                    <h5>${item.book.title}</h5>
                                                </td>
                                                <td class="p-price first-row">$${item.book.price}</td>
                                                <td class="qua-col first-row">
                                                    <div class="quantity">
                                                        <div class="pro-qty">
                                                            <input type="text" value="${item.quantity}" name="quantity">
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="total-price first-row">$${item.book.price * item.quantity}</td>
                                                <td class="close-td first-row">
                                                    <button type="submit" name="btnAction" value="Delete Cart" class="up-cart btn-danger">Delete</button>
                                                </td>
                                                <td class="cart-pic first-row">
                                                    <button class="btn-info up-cart" type="submit" name="btnAction" value="Update Cart">Update</button>
                                                </td> 
                                            </tr>
                                        </form>

                                    </c:forEach>

                                    </tbody>
                                </table>
                            </c:if>

                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="cart-buttons">
                                    <a href="${home}" class="primary-btn continue-shop">Continue shopping</a>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <c:if test="${sessionScope.CART!=null && sessionScope.CART.isEmpty == false}">
                                    <h3 class="text-info">Total <span>$${sessionScope.CART.totalPrice}</h3>   
                                </c:if>
                            </div>

                            <div class="col-lg-4">
                                <div class="proceed-checkout">
                                    <form action="MainController" method="POST">
                                        <input type="date" name="dateReturn" value=""/>

                                        <c:if test="${empty sessionScope.CART.allItems}">
                                            <button type="submit" class="proceed-btn" name="btnAction" value="Checkout" disabled="">
                                                Checkout
                                            </button>
                                        </c:if>
                                        <c:if test="${not empty sessionScope.CART.allItems}">
                                            <button type="submit" class="proceed-btn" name="btnAction" value="Checkout" >
                                                Checkout
                                            </button>
                                        </c:if>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shopping Cart Section End -->

        <%@include file="footer.jsp" %>

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/jquery.dd.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>