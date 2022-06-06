package com.ibook.servlet.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.Book;
import com.ibook.bean.Page;
import com.ibook.dao.impl.BookDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetBookByNameServlet", value = "/GetBookByNameServlet")
public class GetBookByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String bookname = request.getParameter("bookname");
        if (bookname!=null){
            BookDaoImpl bookDao = new BookDaoImpl();
            List<Book> books = bookDao.getBookByName(bookname);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), books);
        }
        response.getWriter().write("false");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
