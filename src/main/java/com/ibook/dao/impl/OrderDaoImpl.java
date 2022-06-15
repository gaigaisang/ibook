package com.ibook.dao.impl;

import com.ibook.bean.CartItem;
import com.ibook.bean.Order;
import com.ibook.bean.OrderItem;
import com.ibook.dao.OrderDao;
import com.ibook.utils.DruidUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class OrderDaoImpl implements OrderDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public int insOrder(Order order) {
        String sql = "insert into orders(id,price,state,user_id) values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, order.getId(), order.getPrice(), order.isState(), order.getUserId());
        return update;
    }

    @Override
    public int insOrderItem(String orderId, CartItem cartItem) {
        String sql = "insert into orderitem(id,book_id,order_id,price,num) values(?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, UUID.randomUUID().toString(), cartItem.getBook().getId(), orderId, cartItem.getPrice(), cartItem.getNum());
        return update;
    }

    @Override
    public int updOrder(String id, Order order) {
        String sql = "update orders set ordertime=?,price=?,state=? where id=?";
        int update = jdbcTemplate.update(sql, order.getOrdertime(), order.getPrice(), order.isState(), id);
        return update;
    }

    @Override
    public Order selOrderById(String id) {
        String sql = "select * from orders where id=?";
        List<Order> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class), id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Order> selOrderByUserId(String userId) {
        String sql = "select * from orders where user_id=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, userId);
        if (list.size() > 0) {
            List<Order> orders = new ArrayList<>();
            for (Map<String, Object> map : list) {
                Order order = new Order();
                order.setId((String) map.get("id"));
                order.setPrice((Double) map.get("price"));
                order.setOrdertime((Date) map.get("ordertime"));
                order.setState((int) map.get("state") != 0);
                order.setUserId((String) map.get("user_id"));
                order.setOrderItems(selOrderItem(order.getId()));
                orders.add(order);
            }

            return orders;
        } else return null;

    }

    @Test
    public void test3() {
        List<Order> orders = selOrderByUserId("1f125f95-e52f-4ff8-bf3d-432f5844ed14");
        orders.sort((o1, o2) -> o2.getOrdertime().compareTo(o1.getOrdertime()));
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Override
    public Order selOrderItemByOrderId(String orderId) {
        return null;
    }

    @Override
    public Order selOrder(String orderId) {
        String sql = "SELECT oi.id item_id,oi.price item_price,o.state,oi.book_id,oi.num FROM orders o,orderitem oi WHERE o.id=oi.order_id AND o.id=?";

        return null;
    }

    @Override
    public List<OrderItem> selOrderItem(String orderId) {
        String sql = "select * from orderitem where order_id=?";
        List<OrderItem> orderItems = new ArrayList<>();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, orderId);
        for (Map<String, Object> map : list) {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(map.get("id").toString());
            CartItem cartItem = new CartItem();
            cartItem.setBook(new BookDaoImpl().getBook(map.get("book_id").toString()));
            cartItem.setPrice(Double.parseDouble(map.get("price").toString()));
            cartItem.setNum(Integer.parseInt(map.get("num").toString()));
            orderItem.setCartItem(cartItem);
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    @Test
    public void test() {
        System.out.println(selOrderItem("7bc83035-2335-4448-9635-b316f3aa14ee").size());
    }

    @Test
    public void test2() {
        String sql = "select * from orders";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> map : list) {
            System.out.println(map.get("state"));

        }
    }


}
