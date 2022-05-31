package com.ibook.dao.impl;

import com.ibook.bean.Book;
import com.ibook.bean.Cart;
import com.ibook.bean.CartItem;
import com.ibook.dao.CartDao;
import com.ibook.service.impl.UserServiceImpl;
import com.ibook.utils.DruidUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;


public class CartDaoImpl implements CartDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public int getCartItemNum(String userId, String bookId) {
        String sql = "SELECT c.num FROM cartitem c WHERE c.book_id= ? AND c.user_id= ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, bookId, userId);
        sqlRowSet.next();
        int i = sqlRowSet.getInt(1);
        return i;
    }

    @Override
    public List<CartItem> getCartItem(String userId) {
        List<CartItem> cartItems = new ArrayList<>();
        String sql = "SELECT * FROM book b,cartitem c WHERE b.id=c.book_id AND c.user_id= ?";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), userId);
        for (Book book : books) {
            CartItem cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setNum(getCartItemNum(userId, book.getId()));
            cartItems.add(cartItem);
        }
        return cartItems;
    }

    @Override
    public int addCartItem(String userId, CartItem cartItem) {
        String sql = "INSERT INTO cartitem (user_id,book_id,num) VALUES (?,?,?)";
        int update = jdbcTemplate.update(sql, userId, cartItem.getBook().getId(), cartItem.getNum());
        return update;
    }

    @Override
    public Cart selCartByUser(String userId) {

        Cart cart = new Cart();
        cart.setUser(userService.findUserById(userId));
        cart.setCartitems(getCartItem(userId));
        return cart;

    }
    @Test
    public void test(){
        Cart cart = selCartByUser("1f125f95-e52f-4ff8-bf3d-432f5844ed14");
        System.out.println(cart);
    }

}
