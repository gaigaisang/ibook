package com.ibook.service.impl;

import com.ibook.bean.Book;
import com.ibook.bean.Cart;
import com.ibook.bean.CartItem;
import com.ibook.dao.impl.CartDaoImpl;
import com.ibook.service.CartService;

public class CartServiceImpl implements CartService {
    CartDaoImpl cartDao = new CartDaoImpl();

    @Override
    public Boolean updateCartItemNum(String userId, String bookId, int num) {
        int i = cartDao.updateCartItemNum(userId, bookId, num);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addToCart(String userId, String bookId) {
        System.out.println("2222");
        if (cartDao.getCartItemBook(userId, bookId)!=null){
            return false;
        }
        int i = cartDao.addCartItem(userId, bookId);
//        System.out.println("i="+i);
        if (i>0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delCartitem(String userId, String bookId) {
        int i = cartDao.delCartItem(userId, bookId);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeFromCart(String bookId, String userId) {
        return null;
    }

    @Override
    public Boolean clearCart(String userId) {
        return null;
    }

    @Override
    public Cart getCart(String userId) {
        Cart cart = cartDao.selCartByUser(userId);
        if (cart!=null) {
            return cart;
        }
        return null;
    }

}
