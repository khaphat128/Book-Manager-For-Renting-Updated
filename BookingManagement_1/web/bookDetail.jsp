<%-- 
    Document   : bookDetail
    Created on : Jul 5, 2020, 12:24:46 AM
    Author     : Administrator
--%>

<%@page import="dtos.UserDTO"%>
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
        <title>Book Detail</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

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

        <section class="product-shop spad page-details">

            <div class="container">
                <div class="row">
                    <div class="col-lg-9">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="product-pic-zoom">
                                    <img class="product-big-img" src="${requestScope.BOOK_DETAIL.image}" alt="">
                                </div>

                            </div>
                            <div class="col-lg-6">
                                <div class="product-details">
                                    <div class="pd-title">
                                        <span>Fashion Book</span>
                                        <h3>${requestScope.BOOK_DETAIL.title}</h3>
                                        <a href="#" class="heart-icon"><i class="icon_heart_alt"></i></a>
                                    </div>
                                  
                                    <div class="pd-desc">
                                        <p>${requestScope.BOOK_DETAIL.description}</p>
                                        <h4>$ ${requestScope.BOOK_DETAIL.price} <span>$ ${requestScope.BOOK_DETAIL.price+15}</span></h4>
                                    </div>
                                    <c:if test="${sessionScope.USER.role.roleID == 1}">
                                        <form method="POST" action="MainController">
                                            <div class="quantity">
                                                <input type="hidden" name="bookID" value="${requestScope.BOOK_DETAIL.bookID}"/>
                                                <div class="pro-qty">
                                                    <input type="text" value="1" name="quantity">
                                                </div>
                                                <button type="submit" value="Add To Cart" name="btnAction" class="primary-btn pd-cart">Add To Cart</button>
                                            </div>
                                        </form>
                                    </c:if>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </section>

        <%@include file="footer.jsp" %> 

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