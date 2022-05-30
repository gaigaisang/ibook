package com.ibook.service.impl;

import com.ibook.bean.Book;
import com.ibook.bean.Page;
import com.ibook.dao.impl.BookDaoImpl;
import com.ibook.service.BookService;
import org.junit.Test;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public List<Book> getAllBook() {
//        List<Book> bookList = bookDao.getBookList();
//        if (bookList != null) {
//            return bookList;
//        }
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
    @Test
    public void test(){
        System.out.println(bookDao.getBookList("all",1,12));
//        System.out.println(getBookByPage(1,10,"all"));
    }
}
