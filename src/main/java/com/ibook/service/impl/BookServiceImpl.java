package com.ibook.service.impl;

import com.ibook.bean.Book;
import com.ibook.bean.Page;
import com.ibook.dao.impl.BookDaoImpl;
import com.ibook.service.BookService;


import java.util.ArrayList;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = bookDao.getAllBook();
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
    public List<Book> getBookByCategory(String category) {
        List<Book> books = bookDao.getBookByCategory(category);
        if (books != null) {
            return books;
        }
        return null;
    }

    @Override
    public Page getBookByPage(int index,int pageSize, String category) {
        Page page = new Page();
        page.setPage(index);
        page.setPageSize(pageSize);
        page.setTotal(bookDao.getAllBook().size());
        page.setTotalPage(page.getTotal()%page.getPageSize()==0?page.getTotal()/page.getPageSize():page.getTotal()/page.getPageSize()+1);
        page.setList(bookDao.getBookList(category,page.getPage(),page.getPageSize()));
        return page;
    }

    @Override
    public List<Book> parseBook(String keyword) {
        keyword.length();
        String[] str=new String[keyword.length()%2==0?keyword.length()/2:keyword.length()/2+1];
        for (int i = 0; i < str.length; i++) {
            str[i] = keyword.substring(i * 2, i * 2 + 2);
        }
        List<Book> books = new ArrayList<>();
        for (String s : str) {
            List<Book> book = bookDao.getBookByName(s);
            if (book != null) {
                books.addAll(book);
            }
        }

        List<Book> bookList = new ArrayList<>();
        for (Book value : books) {
            if (!bookList.contains(value)) {
                bookList.add(value);
            }
        }

        return bookList;
    }

}
