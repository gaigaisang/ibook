package com.ibook.bean;

public class OrderItem {
    private String id;
    private CartItem cartItem;
    public OrderItem() {
    }

    public OrderItem(String id, CartItem cartItem) {
        this.id = id;
        this.cartItem = cartItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", cartItem=" + cartItem +
                '}';
    }
}
