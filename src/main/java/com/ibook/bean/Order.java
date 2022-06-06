package com.ibook.bean;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private Date ordertime;
    private double price;
    private boolean state;
    private User user;
    private List<CartItem> cartItems;

    public Order() {
    }

    public Order(String id, Date ordertime, double price, boolean state, User user, List<CartItem> cartItems) {
        this.id = id;
        this.ordertime = ordertime;
        this.price = price;
        this.state = state;
        this.user = user;
        this.cartItems = cartItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", ordertime=" + ordertime +
                ", price=" + price +
                ", state=" + state +
                ", user=" + user +
                ", cartItems=" + cartItems +
                '}';
    }
}
