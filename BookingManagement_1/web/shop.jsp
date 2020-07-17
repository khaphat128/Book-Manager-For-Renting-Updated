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
        <title>Book For Everyone</title> 

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
        <h3 class="text-center text-danger">${requestScope.DETELE_MESS}</h3>
        <section class="product-shop spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
                        <form action="MainController" method="get">
                            <div class="filter-widget">
                                <h4 class="fw-title">Price</h4>
                                <div class="filter-range-wrap">
                                    <div class="range-slider">
                                        <div class="price-input">
                                            <input type="text" id="minamount" readonly="" name="txtPriceFrom">
                                            <input type="text" id="maxamount" readonly="" name="txtPriceTo">
                                        </div>
                                    </div>
                                    <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                         data-min="0" data-max="100">
                                        <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                        <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                        <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="filter-widget">
                                <h4 class="fw-title">Title</h4>
                                <div class="fw-size-choose">
                                    <div class="price-input">
                                        <input type="text" name="txtSearch" value="${requestScope.SEARCH_VALUE}">
                                    </div>                                
                                </div>
                            </div>
                            <div class="filter-widget">                              
                                <button type="submit" name="btnAction" value="Search" class="filter-btn">Filter</button>                              
                            </div>
                        </form>


                    </div>
                    <div class="col-lg-9 order-1 order-lg-2">
                        <div class="product-show-option">
                            <div class="row">
                                <div class="col-lg-7 col-md-7">
                                    <div class="select-option">
                                        <!--                                        <select class="sorting">
                                                                                    <option value="">Default Sorting</option>
                                                                                </select>
                                                                                <select class="p-show">
                                                                                    <option value="">Show:</option>
                                                                                </select>-->
                                    </div>
                                </div>
                                <div class="col-lg-5 col-md-5 text-right">
                                    <p>Show ${requestScope.LIST_BOOK.size()} Books</p>
                                </div>
                            </div>
                        </div>
                        <div class="product-list">
                            <div class="row">
                                <c:if test="${empty requestScope.LIST_BOOK}">
                                    <div class="justify-content-center col-12">
                                        <h3 class="text-center text-danger">NOT FOUND</h3>
                                    </div>
                                </c:if>
                                <c:forEach var="dto" items="${requestScope.LIST_BOOK}" varStatus="counter">
                                    <div class="col-lg-4 col-sm-6">
                                        <div class="product-item">
                                            <div class="pi-pic">                                  
                                                <img src="${dto.image}" alt="">
                                                <div class="sale pp-sale">Sale</div>
                                                <div class="icon">
                                                    <i class="icon_heart_alt"></i>
                                                </div>
                                                <ul>
                                                    <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                                    <li class="quick-view">
                                                        <form action="MainController" method="post">
                                                            <input type="hidden" name="bookID" value="${dto.bookID}"/>
                                                            <button type="submit" name="btnAction" value="DetailBook">+ Quick View</button>
                                                        </form>
                                                    </li>
                                                    <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                                                </ul>
                                            </div>
                                            <div class="pi-text">
                                                <!--     <div class="catagory-name">Towel</div> -->
                                                <a href="#">
                                                    <h5>${dto.title}</h5>
                                                </a>
                                                <div class="product-price">
                                                    $ ${dto.price}
                                                    <span>$ ${dto.price+15}</span>
                                                </div>
                                            </div>
                                            <div class="pi-text">
                                                <c:if test="${sessionScope.USER!=null && not empty sessionScope.USER}">
                                                    <c:if test="${sessionScope.USER.role.roleID eq 0}">
                                                        <form action="MainController" method="post">
                                                            <input type="hidden" name="bookID" value="${dto.bookID}"/>
                                                            <button name="btnAction" value="Delete_Book" class="btn btn-danger">Delete</button>
                                                        </form>
                                                    </c:if>
                                                </c:if>
                                            </div>
                                            <div class="pi-text">
                                                <c:if test="${sessionScope.USER!=null && not empty sessionScope.USER}">
                                                    <c:if test="${sessionScope.USER.role.roleID eq 0}">
                                                        <form action="MainController" method="post">
                                                            <input type="hidden" name="bookID" value="${dto.bookID}"/>
                                                            <input type="hidden" name="image" value="${dto.image}"/>
                                                            <input type="hidden" name="title" value="${dto.title}"/>
                                                            <input type="hidden" name="price" value="${dto.price}"/>
                                                            <input type="hidden" name="description" value="${dto.description}"/>
                                                            <input type="hidden" name="totalAmount" value="${dto.totalAmount}"/>
                                                            <input type="hidden" name="availableAmount" value="${dto.availableAmount}"/>
                                                            <button name="btnAction" value="Update_Book_Page" class="btn btn-danger">Update</button>
                                                        </form>
                                                    </c:if>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

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

        <%@include file="footer.jsp" %>
    </body>

</html>