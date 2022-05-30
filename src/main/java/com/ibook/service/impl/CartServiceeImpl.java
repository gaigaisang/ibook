package com.ibook.service.impl;

import com.ibook.bean.CartItem;
import com.ibook.dao.impl.CartDaoImpl;
import com.ibook.service.CartService;

public class CartServiceeImpl implements CartService {
    CartDaoImpl cartDao = new CartDaoImpl();
    @Override
    public Boolean addToCart(String userId, CartItem cartItem) {
        int i = cartDao.addCartItem(userId, cartItem);
        if (i>0) {
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
}
