<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Fashi Template">
        <meta name="keywords" content="Fashi, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>
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

        <!-- Header Section Begin -->

        <%@include file="header.jsp" %>

        <!-- Register Section Begin -->
        <div class="register-login-section spad">
            <div class="container">
                <div class="row">
                    <div class="text-center justify-content-center">
                        <h4 class="text-center bg-danger">${requestScope.MESSAGE}</h4>
                        <h4 class="text-center bg-info">${requestScope.MESSAGE_REGISTER_SUCCESS}</h4>
                    </div>
                    <div class="col-lg-6 offset-lg-3">
                        <div class="login-form">
                            <h2>Login</h2>
                            <form action="MainController" method="POST">
                                <div class="group-input">
                                    <label for="username">User ID *</label>
                                    <input type="text" id="username" name="txtUserID" value="${requestScope.USER_ID}">
                                </div>
                                <div class="group-input">
                                    <label for="pass">Password *</label>
                                    <input type="password" id="pass" name="txtPassword">
                                </div>                              
                                <button type="submit" class="site-btn login-btn" value="Login" name="btnAction">Sign In</button>
                            </form>
                            <div class="switch-login">
                                <c:url var="registerPage" value="MainController">
                                    <c:param name="btnAction" value="Register Page"></c:param>                                 
                                </c:url>
                                <a href="${registerPage}" class="or-login">Or Create An Account</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Register Form Section End -->

        <%@include file="footer.jsp" %>
    </body>

</html>