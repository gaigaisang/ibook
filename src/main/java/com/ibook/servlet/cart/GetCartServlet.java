package com.ibook.servlet.cart;

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
        if (request.getParameter("userid")!=null){
            Cart cart = cartService.getCart(request.getParameter("userid"));
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), cart);
            return;
        }
//        System.out.println(userid);
        if (userid != null) {
            Cart cart = cartService.getCart(userid);
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), cart);
        }else response.getWriter().write("null");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
