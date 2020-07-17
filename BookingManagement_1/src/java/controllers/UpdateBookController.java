/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.BookDAO;
import dtos.BookDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class UpdateBookController extends HttpServlet {

    private final String SUCCESS = "ShowBookController";
    private final String ERROR = "updateBook.jsp";
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(LoginController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            boolean check = true;
            int bookID = Integer.parseInt(request.getParameter("bookID"));
            String image = request.getParameter("txtImage");
            if (image == null || image.trim().isEmpty()) {
                request.setAttribute("ERROR_IMAGE", "Image is required!");
                check = false;
            }
            image = "image\\" + image;

            String title;
            title = request.getParameter("txtTitle");
            if (title == null || title.trim().isEmpty()) {
                request.setAttribute("ERROR_TITLE", "Title is required");
                check = false;
            }

            float price = 0;
            try {
                price = Float.parseFloat(request.getParameter("txtPrice"));
                if (price <= 0) {
                    request.setAttribute("ERROR_PRICE", "Price is required");
                    check = false;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("ERROR_PRICE", "Price is not valid");
                check = false;
            }

            String description = request.getParameter("txtDescription");
            if (description.length() == 0 || description.trim().isEmpty()) {
                request.setAttribute("ERROR_DES", "Description is required");
                check = false;
            }

            int totalAmount = 0;
            try {
                totalAmount = Integer.parseInt(request.getParameter("txtTotalAmount"));
                if (totalAmount <= 0) {
                    request.setAttribute("ERROR_TOTAL_AMOUNT", "Total Amount must > 0");
                    check = false;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("ERROR_TOTAL_AMOUNT", "Total Amount not valid");
                check = false;
            }

            int availableAmount = 1;
            try {
                availableAmount = Integer.parseInt(request.getParameter("txtAvailableAmount"));
                if (availableAmount < 1) {
                    request.setAttribute("ERROR_AVAILABLE_AMOUNT", "Available Amount must > 0");
                    check = false;
                }

            } catch (NumberFormatException e) {
                request.setAttribute("ERROR_AVAILABLE_AMOUNT", "Available Amount not valid");
                check = false;
            }

            if (check) {
                BookDTO newBook = new BookDTO(bookID, image, title, price, totalAmount, availableAmount, description);
                BookDAO bookDAO = new BookDAO();
                bookDAO.updateBook(newBook);
                url = SUCCESS;
            }
        } catch (NumberFormatException | SQLException e) {
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
