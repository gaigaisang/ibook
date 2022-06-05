package com.ibook.servlet.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.Category;
import com.ibook.dao.impl.CategoryDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetCategoryServlet", value = "/GetCategoryServlet")
public class GetCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        List<Category> categories = categoryDao.selAllCategory();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), categories);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);
    }
}
