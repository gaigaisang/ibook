package com.ibook.dao;

import com.ibook.bean.Order;

public interface OrderDao {
    public int insOrder(Order order);
    public int updOrder(String id , Order order);
    public Order selOrder(String id);

}
