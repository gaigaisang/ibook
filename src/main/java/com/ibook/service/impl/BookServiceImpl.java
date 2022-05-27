package com.ibook.service.impl;

import com.ibook.bean.Book;
import com.ibook.dao.impl.BookDaoImpl;
import com.ibook.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = bookDao.getBookList();
        if (bookList != null) {
            return bookList;
        }
        return null;
    }

    @Override
    public Book getBookById(String id) {
        Book book = bookDao.getBook(id);
        if (book != null) {
            return book;
        }
        return null;
    }

    @Override
    public List<Book> getBookByName(String name) {
        List<Book> books = bookDao.getBookByName(name);
        if (books != null) {
            return books;
        }
        return null;
    }

    @Override
    public List<Book> getBookByCategory(String category_id) {
        List<Book> books = bookDao.getBookByCategory(category_id);
        if (books != null) {
            return books;
        }
        return null;
    }
}
