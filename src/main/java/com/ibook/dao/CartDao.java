package com.ibook.dao;

import com.ibook.bean.Book;
import com.ibook.bean.Cart;
import com.ibook.bean.CartItem;

import java.util.List;

public interface CartDao {
    public int getCartItemNum(String userId ,String bookId);
    public int addCartItem(String userId,String bookId);
    public int delCartItem(String userId,String bookId);
    public Cart selCartByUser(String userId);
    public List<CartItem> getCartItem(String userId);
    public CartItem getCartItem(String userId,String bookId);
    public Book getCartItemBook(String userId, String bookId);
    public int updateCartItemNum(String userId,String bookId,int num);



}
