<%-- 
    Document   : insertBook
    Created on : Jul 7, 2020, 1:06:00 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert A Type Of Book Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
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

        <%@include file="header.jsp"%>
        <c:if test="${sessionScope.USER==null || sessionScope.USER.role.roleID == 1}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <div class="container text-center">
            <h3 class="text-danger">Create Book</h3>
        </div>
        <form action="MainController" method="post" class="container" style="width: 50%">
            <div class="form-group">
                Image link:<input type="file" name="txtImage" value="" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.IMAGE_ERROR}</h3>
            </div>
            <div class="form-group">
                Title:<input type="text" name="txtTitle" value="${requestScope.TITLE}"class="form-control"/><br>
                <h3 class="text-danger">${requestScope.TITLE_ERROR}</h3>
            </div>
            <div class="form-group">
                Price:<input type="number" step="0.5" name="txtPrice" min="1" max="100" value="" class="form-control"/><br>
                <h4 class="text-danger">${requestScope.PRICE_ERROR}</h4>
            </div>
            <div class="form-group">
                Description:<input type="text" name="txtDescription" value="" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.DESCRIPTION_ERROR}</h3>
            </div>
            <div class="form-group">
                Available Amount:<input type="number" name="txtAvailableAmount" min="1" max="100" value="" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.AVAILABLE_AMOUNT_ERROR}</h3>
            </div>
            <div class="form-group">
                <button type="submit" name="btnAction" value="Insert_Book_Controller" class="form-control btn btn-success">Insert</button>
            </div>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
