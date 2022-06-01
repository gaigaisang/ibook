package com.ibook.dao;

import com.ibook.bean.Cart;
import com.ibook.bean.CartItem;

import java.util.List;

public interface CartDao {
    public int getCartItemNum(String userId ,String bookId);
    public int addCartItem(String userId,String bookId);
//    public void deleteCart(int userId,int bookId);
//    public void updateCart(int userId,int bookId,int count);
    public Cart selCartByUser(String userId);
    public List<CartItem> getCartItem(String userId);



}
