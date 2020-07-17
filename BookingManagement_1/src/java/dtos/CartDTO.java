/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class CartDTO {

    private Map<Integer, ItemCart> cart;

    public CartDTO() {
        cart = new HashMap<>();
    }

    public Map<Integer, ItemCart> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, ItemCart> cart) {
        this.cart = cart;
    }
    

    public void addToCart(ItemCart item) {
        if (cart.containsKey(item.getBook().getBookID())) {
            int oldQuantity = cart.get(item.getBook().getBookID()).getQuantity();
            int newQuantity = item.getQuantity();
            item.setQuantity(oldQuantity + newQuantity);
        }
        cart.put(item.getBook().getBookID(), item);
    }

    public void UpdateCart(ItemCart item) {
        if (cart.containsKey(item.getBook().getBookID())) {
            cart.put(item.getBook().getBookID(), item);
        }
    }

    public void UpdateCart(int bookID, int quantity) {
        if (cart.containsKey(bookID)) {
            ItemCart item = cart.get(bookID);
            item.setQuantity(quantity);
        }
    }

    public void removeFromCart(int bookID) {
        if (cart.containsKey(bookID)) {
            cart.remove(bookID);
        }
    }

    public float getTotalPrice() {
        if (cart.isEmpty()) {
            return 0;
        }
        float total = 0;
        for (ItemCart item : cart.values()) {
            total += item.getBook().getPrice() * item.getQuantity();
        }
        return total;
    }

    public Collection<ItemCart> getAllItems() {
        return cart.values();
    }
    
    public boolean getIsEmpty(){
        return cart.isEmpty();
    }

}
