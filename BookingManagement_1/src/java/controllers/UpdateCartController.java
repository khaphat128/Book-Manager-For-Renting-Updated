/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.BookDAO;
import dtos.BookDTO;
import dtos.CartDTO;
import dtos.ItemCart;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class UpdateCartController extends HttpServlet {

    private final String ERROR = "invalid.jsp";
    private final String SUCCESS = "cart.jsp";
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(LoginController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            boolean flag = true;

            int bookID = 0;
            int quantity = 0;

            try {
                bookID = Integer.parseInt(request.getParameter("bookID"));
                quantity = Integer.parseInt(request.getParameter("quantity"));
                if (quantity < 0) {
                    flag = false;
                }
            } catch (NumberFormatException e) {
                flag = false;
            }

            if (flag) {
                HttpSession session = request.getSession();
                CartDTO cart = (CartDTO) session.getAttribute(("CART"));
                if (cart == null) {
                    cart = new CartDTO();
                }
                if (quantity != 0) {
                    BookDAO bookDAO = new BookDAO();
                    BookDTO book = bookDAO.getInfoABookByID(bookID);
                    if (book != null) {
                        ItemCart item = new ItemCart(book, quantity);
                        cart.UpdateCart(item);
                        session.setAttribute("CART", cart);
                    }
                } else {
                    cart.removeFromCart(bookID);
                    session.setAttribute("CART", cart);
                }
                url = SUCCESS;
            }
        } catch (SQLException e) {
            LOGGER.fatal("Error at Login Controller:", e);
        } finally {
            response.sendRedirect(url);
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
