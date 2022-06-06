package com.ibook.dao.impl;

import com.ibook.bean.CartItem;
import com.ibook.bean.Order;
import com.ibook.dao.OrderDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class OrderDaoImpl implements OrderDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public int insOrder(Order order) {
        String sql = "insert into order(id,ordertime,price,state,user_id) values(?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, UUID.randomUUID().toString(), order.getOrdertime(), order.getPrice(), order.getUser().getId());
        return update;
    }

    @Override
    public int updOrder(String id, Order order) {
        String sql = "update order set ordertime=?,price=?,state=? where id=?";
        int update = jdbcTemplate.update(sql, order.getOrdertime(), order.getPrice(), order.isState(), id);
        return update;
    }

    @Override
    public Order selOrder(String id) {
        String sql = "select * from order where id=?";
        List<Order> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class), id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insOrderItem(String id, CartItem cartItem) {
        String sql = "insert into orderitem(id,num,price,order_id,book_id) values(?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, UUID.randomUUID().toString(), cartItem.getNum(), cartItem.getPrice(), id, cartItem.getBook().getId());
        return 0;
    }
}
