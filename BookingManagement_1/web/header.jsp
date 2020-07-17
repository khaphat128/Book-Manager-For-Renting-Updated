<%-- 
    Document   : header
    Created on : Jun 22, 2020, 11:22:24 PM
    Author     : Administrator
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header-section">          
    <div class="nav-item">
        <div class="container">
            
            <nav class="nav-menu mobile-menu">
                <ul>
                    <c:url var="home" value="MainController">
                        <c:param name="btnAction" value="Home"></c:param>
                    </c:url>
                    <li><a href="${home}">Home</a></li>
                        <c:if test="${sessionScope.USER!=null && not empty sessionScope.USER}">
                            <c:if test="${sessionScope.USER.role.roleID eq 0}">
                            <li><a href="#">Manager</a>
                                <ul class="dropdown">
                                    <li><a href="#">Manager Book</a></li>
                                        <%-- insert a book --%>
                                    <li>
                                        <c:url var="insert" value="MainController">
                                            <c:param name="btnAction" value="Insert Book Page"></c:param>
                                        </c:url>
                                        <a href="${insert}">Insert A Book</a>
                                    </li>
                                    <%-- update a book --%>

                                    <li><a href="#">Manager User</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.USER.role.roleID != 0}">
                            <li>
                                <c:url var="cart" value="MainController">
                                    <c:param name="btnAction" value="Cart Page"></c:param>
                                </c:url>
                                <a href="${cart}">Cart</a>
                            </li>
                        </c:if>

                        <li><a href="#">${sessionScope.USER.userName}</a>
                            <ul class="dropdown">
                                <li><a>Update Profile</a></li>
                                    <c:if test="${sessionScope.USER.role.roleID != 0}">
                                    <li><a>History</a></li>
                                    <li><a>Return Book</a></li>
                                    </c:if>
                            </ul>
                        </li>
                        <li>
                            <c:url var="logout" value="MainController">
                                <c:param name="btnAction" value="Logout"></c:param>
                            </c:url>
                            <a href="${logout}">Logout</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.USER == null}">
                        <li>
                            <c:url var="login" value="MainController">
                                <c:param name="btnAction" value="Login"></c:param>
                            </c:url>
                            <a href="${login}">Login</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
        </div>
    </div>
</header>
<!-- Header End -->