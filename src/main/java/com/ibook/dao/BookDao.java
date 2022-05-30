package com.ibook.dao;

import com.ibook.bean.Book;

import java.util.List;

public interface BookDao {
    public int insBook(Book book);
    public int deleteBook(String id);
    public int updateBook(String id,Book book);
    public Book getBook(String id);
    public List<Book> getAllBook();
    public List<Book> getBookList(String category,int page,int pageSize);
    public List<Book> getBookByName(String name);
    public List<Book> getBookByCategory(String category);


}
