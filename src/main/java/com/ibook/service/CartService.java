package com.ibook.service;

import com.ibook.bean.Cart;
import com.ibook.bean.CartItem;

public interface CartService {
    public Boolean addToCart(String bookId, CartItem cartItem);
    public Boolean removeFromCart(String bookId, String userId);
    public Boolean clearCart(String userId);
    public Cart getCart(String userId);
}
