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
import java.util.List;
import java.util.UUID;

public class OrderDaoImpl implements OrderDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public int insOrder(Order order) {
        String sql = "insert into orders(id,price,state,user_id) values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, order.getId(), order.getPrice(), order.isState(), order.getUserId());
        return update;
    }

    @Override
    public int insOrderItem(String orderId,CartItem cartItem) {
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
    public Order selOrder(String id) {
        String sql = "select * from orders where id=?";
        List<Order> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class), id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Order selOrderById(String orderId) {
        String sql = "SELECT oi.id item_id,oi.price item_price,o.state,oi.book_id,oi.num FROM orders o,orderitem oi WHERE o.id=oi.order_id AND o.id=?";

        return null;
    }

    @Override
    public List<OrderItem> selOrderItem(String orderId) {
        String sql = "select * from orderitem where order_id=?";
        List<OrderItem> orderItems = jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderItem>(OrderItem.class), orderId);
        return orderItems;
    }
    @Test
    public void test(){
        String sql = "select * from orderitem where order_id=?";
        jdbcTemplate.query(sql, new RowMapper<Order>() {
            @Override
            public Order mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        }, "1");

//        System.out.println(orderItems);
    }


}
