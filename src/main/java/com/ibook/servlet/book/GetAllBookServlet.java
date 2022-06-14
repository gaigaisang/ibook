package com.ibook.servlet.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.Book;
import com.ibook.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllBookServlet", value = "/GetAllBookServlet")
public class GetAllBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> books = bookService.getAllBook();
        ObjectMapper mapper = new ObjectMapper();
        if (books != null) {
            mapper.writeValue(response.getWriter(), books);
        }else {
            mapper.writeValue(response.getWriter(), "false");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
