<%-- 
    Document   : UpdateBook
    Created on : Jul 8, 2020, 1:29:21 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book Page</title>
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
        <%@include file="header.jsp" %>
        
        <c:if test="${sessionScope.USER.role.roleID==null} || ${sessionScope.USER.role.roleID==1}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <form action="MainController" method="post" class="container" style="width: 50%">

            <input type="hidden" name="bookID" value="${param.bookID}" readonly=""/><br>

            <div class="form-group">
                Image link:<input type="file" name="txtImage" value="" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.ERROR_IMAGE}<br></h3> 
            </div>
            <div class="form-group">
                Title:<input type="text" name="txtTitle" value="${param.title}"class="form-control"/><br>
                <h3 class="text-danger"> ${requestScope.ERROR_TITLE}<br></h3>
            </div>

            <div class="form-group">
                Price:<input type="number" step="0.5" name="txtPrice" min="1" max="100" value="${param.price}" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.ERROR_PRICE}<br></h3>  
            </div>
            <div class="form-group">
                Description:<input type="text" name="txtDescription" value="${param.description}" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.ERROR_DES}<br></h3>  
            </div>
            <div class="form-group">
                Total Amount:<input type="number" name="txtTotalAmount" min="1" max="100" value="${param.totalAmount}" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.ERROR_TOTAL_AMOUNT}<br></h3>      
            </div>

            <div class="form-group">
                Available Amount:<input type="number" name="txtAvailableAmount" min="1" max="100" value="" class="form-control"/><br>
                <h3 class="text-danger">${requestScope.ERROR_AVAILABLE_AMOUNT} </h3> <br>
            </div>
            <div class="form-group">
                <button type="submit" name="btnAction" value="Update Book" class="form-control btn btn-success">Update</button>
            </div>

        </form>

        <%@include file="footer.jsp" %>
    </body>
</html>
