/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Administrator
 */
public class BookDTO {

    private int bookID;
    private String image;
    private String title;
    private float price;
    private int totalAmount;
    private int availableAmount;
    private String description;
    private boolean status;
   

    public BookDTO() {
    }

    public BookDTO(int bookID, String image, String title, float price, int totalAmount, int availableAmount, String description, boolean status) {
        this.bookID = bookID;
        this.image = image;
        this.title = title;
        this.price = price;
        this.totalAmount = totalAmount;
        this.availableAmount = availableAmount;
        this.description = description;
        this.status = status;
    }

    public BookDTO(String image, String title, float price, int totalAmount, int availableMount, String description) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.totalAmount = totalAmount;
        this.availableAmount = availableMount;
        this.description = description;
    }

    public BookDTO(int bookID, String image, String title, float price, int totalAmount, int availableAmount, String description) {
        this.bookID = bookID;
        this.image = image;
        this.title = title;
        this.price = price;
        this.totalAmount = totalAmount;
        this.availableAmount = availableAmount;
        this.description = description;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
