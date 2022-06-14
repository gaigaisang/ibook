package com.ibook.servlet.android;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.Book;
import com.ibook.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParseBookServlet", value = "/ParseBookServlet")
public class ParseBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String keyword = request.getParameter("keyword");
        if (keyword != null) {
            System.out.println(keyword);
            BookServiceImpl bookService = new BookServiceImpl();
            List<Book> books = bookService.parseBook(keyword);
            if (books != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(), books);
            }else {
                response.getWriter().write("false");
            }
        } else response.getWriter().write("false");
    }


}
