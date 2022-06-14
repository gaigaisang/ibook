package com.ibook.service;

import com.ibook.bean.CartItem;

import java.util.List;

public interface OrderService {
    public String initOrder(String userId, List<CartItem> cartItems);
}
