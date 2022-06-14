package com.ibook.dao;

import com.ibook.bean.CartItem;
import com.ibook.bean.Order;
import com.ibook.bean.OrderItem;

import java.util.List;

public interface OrderDao {
    public int insOrder(Order order);
    public int insOrderItem(String orderId, CartItem cartItem);
    public int updOrder(String id , Order order);
    public Order selOrder(String id);
    public Order selOrderById(String orderId);
    public List<OrderItem> selOrderItem(String orderId);

}
