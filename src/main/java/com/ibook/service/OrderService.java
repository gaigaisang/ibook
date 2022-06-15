package com.ibook.service;

import com.ibook.bean.CartItem;
import com.ibook.bean.Order;

import java.util.List;

public interface OrderService {
    public String initOrder(String userId, List<CartItem> cartItems);
    public List<Order> getOrderList(String userId,String state);
}
