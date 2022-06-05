package com.ibook.servlet.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.Book;
import com.ibook.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetBookServlet", value = "/GetBookServlet")
public class GetBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String bookId = request.getParameter("bookId");
        if (bookId!=null){
//            System.out.println("bookId:" + bookId);
            BookServiceImpl bookService = new BookServiceImpl();
            Book book = bookService.getBookById(bookId);
            if (book != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(), book);
                return;
            }
        }
        response.getWriter().write("false");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);
    }
}
