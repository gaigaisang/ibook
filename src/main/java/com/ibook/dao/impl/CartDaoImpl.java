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
    public CartItem getCartItem(String userId, String bookId) {
        String sql = "SELECT * FROM book b,cartitem c WHERE b.id=c.book_id AND c.user_id= ?";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), userId);
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                CartItem cartItem = new CartItem();
                cartItem.setBook(book);
                cartItem.setNum(getCartItemNum(userId, book.getId()));
                return cartItem;
            }
        }
        return null;
    }

    @Override
    public Book getCartItemBook(String userId, String bookId) {
        String sql = "SELECT * FROM cartitem c WHERE c.book_id=? AND c.user_id= ?";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), bookId, userId);
        if (books.size() > 0) {
            return books.get(0);
        }
        return null;
    }

    @Override
    /**
     * 修改购买数量
     * @param userId 用户id
     * @param bookId 书籍id
     * @param num 1增加，-1减少
     */
    public int updateCartItemNum(String userId, String bookId, int num) {
        String sql = "UPDATE cartitem SET num=num+? WHERE book_id=? AND user_id=?";
        int update = jdbcTemplate.update(sql, num, bookId, userId);
        return update;
    }


    @Override
    public int addCartItem(String userId, String bookId) {
        String sql = "INSERT INTO cartitem (user_id,book_id,num) VALUES (?,?,?)";
        int update = jdbcTemplate.update(sql, userId, bookId, 1);
        return update;
    }

    @Override
    public int delCartItem(String userId, String bookId) {
        String sql = "DELETE FROM cartitem WHERE book_id=? AND user_id=?";
        int update = jdbcTemplate.update(sql, bookId, userId);
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
    public void test() {
        Cart cart = selCartByUser("1f125f95-e52f-4ff8-bf3d-432f5844ed14");
        System.out.println(cart);
    }

}
