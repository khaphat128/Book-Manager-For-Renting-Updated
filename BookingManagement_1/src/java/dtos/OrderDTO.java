/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class OrderDTO {
    private int orderID;
    private float totalPrice;
    private Date date;
    private Date dateReturn;
    private UserDTO user;

    public OrderDTO() {
    }

    public OrderDTO(int orderID) {
        this.orderID = orderID;
    }

    public OrderDTO(int orderID, float totalPrice, Date date, UserDTO user) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.user = user;
    }

    public OrderDTO(int orderID, float totalPrice, Date date, Date dateReturn, UserDTO user) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.dateReturn = dateReturn;
        this.user = user;
    }
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }
    
    
}
