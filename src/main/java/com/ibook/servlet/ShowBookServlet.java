package com.ibook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.Page;
import com.ibook.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShowBookServlet", value = "/ShowBookServlet")
public class ShowBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String category = request.getParameter("category");
        if (category != null) {
            BookServiceImpl bookService = new BookServiceImpl();
            Page page = bookService.getBookByPage(1, 2, category);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), page);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
