package com.ibook.servlet.android;

import com.ibook.service.impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet-android", value = "/AddToCartServlet-android")
public class AddToCartServletandroid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String bookId = request.getParameter("bookId");
        String userId = request.getParameter("userId")  ;
        System.out.println(bookId);
        System.out.println(userId);
        CartServiceImpl cartService = new CartServiceImpl();
        Boolean result = cartService.addToCart(userId, bookId);
        response.getWriter().write(result.toString());
    }
}
