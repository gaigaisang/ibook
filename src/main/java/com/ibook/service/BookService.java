package com.ibook.service;

import com.ibook.bean.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBook();
    public Book getBookById(String id);
    public List<Book> getBookByName(String name);
    public List<Book> getBookByCategory(String category_id);
}
