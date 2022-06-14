package com.ibook.service;

import com.ibook.bean.Book;
import com.ibook.bean.Page;

import java.util.List;

public interface BookService {
    public List<Book> getAllBook();
    public Book getBookById(String id);
    public List<Book> getBookByName(String name);
    public List<Book> getBookByCategory(String category_id);
    public Page getBookByPage(int index,int pageSize, String category);
    public List<Book> parseBook(String keyword);
}
