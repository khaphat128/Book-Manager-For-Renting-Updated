/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class MainController extends HttpServlet {

    private final String LOGIN = "LoginController";
    private final String REGISTER_PAGE = "register.jsp";
    private final String LOGIN_PAGE = "login.jsp";
    private final String REGISTER = "RegisterController";
    private final String HOME = "ShowBookController";
    private final String DETAIL_BOOK = "ShowABookDetailController";
    private final String LOGOUT = "LogoutController";
    private final String INSERT_BOOK_PAGE = "insertBook.jsp";
    private final String INSERT_BOOK = "InsertBookController";
    private final String DELETE_BOOK = "DeleteBookController";
    private final String UPDATE_BOOK = "UpdateBookController";
    private final String UPDATE_BOOK_PAGE = "updateBook.jsp";
    private final String ERROR = "login.jsp";
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(LoginController.class);

    private final String ADD_TO_CART = "AddToCartController";
    private final String UPDATE_CART = "UpdateCartController";
    private final String DELETE_CART = "DeleteCartController";
    private final String CHECKOUTCONTROLLER = "CheckOutController";
    private final String CART_PAGE = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");
            switch (action) {
                case "Login":
                    url = LOGIN;
                    break;
                case "Register Page":
                    url = REGISTER_PAGE;
                    break;
                case "Register":
                    url = REGISTER;
                    break;
                case "Login Page":
                    url = LOGIN_PAGE;
                    break;
                case "Search":
                    url = HOME;
                    break;
                case "Home":
                    url = HOME;
                    break;
                case "DetailBook":
                    url = DETAIL_BOOK;
                    break;
                case "Logout":
                    url = LOGOUT;
                    break;
                case "Insert Book Page":
                    url = INSERT_BOOK_PAGE;
                    break;
                case "Insert_Book_Controller":
                    url = INSERT_BOOK;
                    break;
                case "Delete_Book":
                    url = DELETE_BOOK;
                    break;
                case "Update_Book_Page":
                    url = UPDATE_BOOK_PAGE;
                    break;
                case "Update Book":
                    url = UPDATE_BOOK;
                    break;
                case "Add To Cart":
                    url = ADD_TO_CART;
                    break;
                case "Update Cart":
                    url = UPDATE_CART;
                    break;
                case "Delete Cart":
                    url = DELETE_CART;
                    break;
                case "Checkout":
                    url = CHECKOUTCONTROLLER;
                    break;
                case "Cart Page":
                    url = CART_PAGE;
                    break;
                default:
                    url = LOGIN;
            }
        } catch (Exception e) {
            LOGGER.fatal("Error at Login Controller:", e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
