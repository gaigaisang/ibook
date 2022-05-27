package com.ibook.dao.impl;

import com.ibook.bean.Book;
import com.ibook.dao.BookDao;
import com.ibook.utils.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class BookDaoImpl implements BookDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public int insBook(Book book) {
        String sql = "insert into book(id,name,author,price,image,description,category_id,num) values(?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, UUID.randomUUID().toString(), book.getName(), book.getAuthor(), book.getPrice(), book.getImage(), book.getDescription(), book.getCategory_id(), book.getNum());
        return update;
    }

    @Override
    public int deleteBook(String id) {
        String sql = "delete from book where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public int updateBook(String id, Book book) {
        String sql = "update book set name = ?,author = ?,price = ?,image = ?,description = ?,category_id = ?,num = ? where id = ?";
        int update = jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getImage(), book.getDescription(), book.getCategory_id(), book.getNum(), id);
        return update;
    }

    @Override
    public List<Book> getBookList() {
        String sql = "select * from book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public Book getBook(String id) {
        String sql = "select * from book where id = ?";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Book> getBookByName(String name) {
        String sql = "select * from book where name like ?";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), "%" + name + "%");
        return list;
    }

    @Override
    public List<Book> getBookByCategory(String category_id) {
        String sql = "select * from book where category_id = ?";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), category_id);
        return list;
    }
}
