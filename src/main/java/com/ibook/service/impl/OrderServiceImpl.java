package com.ibook.service.impl;

import com.ibook.bean.CartItem;
import com.ibook.bean.Order;
import com.ibook.bean.OrderItem;
import com.ibook.dao.impl.OrderDaoImpl;
import com.ibook.service.OrderService;

import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    OrderDaoImpl orderDao = new OrderDaoImpl();

    @Override
    public String initOrder(String userId, List<CartItem> cartItems) {
        Order order = new Order();
        Double price = 0.0;
        String orderId = UUID.randomUUID().toString();
        for (CartItem cartItem : cartItems) {
            price += cartItem.getPrice();
        }
        order.setId(orderId);
        order.setUserId(userId);
        order.setPrice(price);
        order.setState(false);
        int i = orderDao.insOrder(order);

        for (CartItem cartItem : cartItems) {
            int i1 = orderDao.insOrderItem(orderId, cartItem);
        }
        return orderId;
    }
}
