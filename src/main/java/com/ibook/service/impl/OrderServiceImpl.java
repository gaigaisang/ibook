package com.ibook.service.impl;

import com.ibook.bean.CartItem;
import com.ibook.bean.Order;
import com.ibook.dao.impl.OrderDaoImpl;
import com.ibook.service.OrderService;

import java.util.ArrayList;
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

    @Override
    public List<Order> getOrderList(String userId, String state) {
        List<Order> orders = orderDao.selOrderByUserId(userId);
        if (orders==null){
            return null;
        }
        switch (state) {
            case "all":
                orders.sort((o1, o2) -> o2.getOrdertime().compareTo(o1.getOrdertime()));
                return orders;
            case "true":
                List<Order> orders1 = new ArrayList<>();
                for (Order order : orders) {
                    if (order.isState()) {
                        orders1.add(order);
                    }
                }
                orders1.sort((o1, o2) -> o2.getOrdertime().compareTo(o1.getOrdertime()));
                return orders1;
            case "false":
                List<Order> orders2 = new ArrayList<>();
                for (Order order : orders) {
                    if (!order.isState()) {
                        orders2.add(order);
                    }
                }
                orders2.sort((o1, o2) -> o2.getOrdertime().compareTo(o1.getOrdertime()));
                return orders2;

        }
        return null;

    }
}
