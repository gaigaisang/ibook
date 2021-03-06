package com.ibook.bean;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private Date ordertime;
    private double price;
    private boolean state;
    private String userId;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(String id, Date ordertime, double price, boolean state, String userId, List<OrderItem> orderItems) {
        this.id = id;
        this.ordertime = ordertime;
        this.price = price;
        this.state = state;
        this.userId = userId;
        this.orderItems = orderItems;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", ordertime=" + ordertime +
                ", price=" + price +
                ", state=" + state +
                ", userId='" + userId + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
