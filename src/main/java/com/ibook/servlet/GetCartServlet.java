package com.ibook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.Cart;
import com.ibook.service.impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetCartServlet", value = "/GetCartServlet")
public class GetCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        CartServiceImpl cartService = new CartServiceImpl();
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");
        System.out.println(userid);
        Cart cart = cartService.getCart(userid);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), cart);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
