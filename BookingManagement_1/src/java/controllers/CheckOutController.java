/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.OrderDAO;
import daos.OrderDetailDAO;
import dtos.CartDTO;
import dtos.ItemCart;
import dtos.OrderDTO;
import dtos.OrderDetailDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.sql.Date;
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
public class CheckOutController extends HttpServlet {

    private final String ERROR = "invalid.jsp";
    private final String SUCCESS = "cart.jsp";
    private final String LOGIN = "login.jsp";
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(LoginController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {

            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("USER");
            if (user == null || user.getRole().getRoleID() == 0) {
                url = LOGIN;
            } else {
                CartDTO cart = (CartDTO) session.getAttribute(("CART"));
                if (cart != null && !cart.getAllItems().isEmpty()) {
                    String dateStr = request.getParameter("dateReturn");
                    try {

                        //Create OrderDTO
                        Date date = Date.valueOf(dateStr);
                        OrderDAO orderDAO = new OrderDAO();
                        OrderDTO dto = new OrderDTO();
                        dto.setDate(new Date(System.currentTimeMillis()));
                        dto.setDateReturn(date);
                        dto.setTotalPrice(cart.getTotalPrice());
                        dto.setUser(user);
                        // Insert Order
                        if (orderDAO.InsertOrder(dto)) {
                            //Get Already OrderID
                            int orderID = orderDAO.getLastOrderIDByUser(user.getUserID());
                            //Insert all orderDetail
                            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                            for (ItemCart item : cart.getAllItems()) {
                                OrderDetailDTO detailDTO = new OrderDetailDTO();
                                detailDTO.setOrder(new OrderDTO(orderID));
                                detailDTO.setBook(item.getBook());
                                detailDTO.setTotalPrice(item.getQuantity() * item.getBook().getPrice());
                                detailDTO.setAmount(item.getQuantity());
                                orderDetailDAO.insertOrderDetail(detailDTO);
                            }
                        }
                        session.setAttribute("CART", new CartDTO());
                    } catch (SQLException e) {
                    }
                }
                url = SUCCESS;
            }

        } catch (Exception e) {
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
